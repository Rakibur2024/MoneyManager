package com.moneymanager.MoneyManager.implementation;

import com.moneymanager.MoneyManager.entity.Event;
import com.moneymanager.MoneyManager.payload.ResponseMessage;
import com.moneymanager.MoneyManager.repository.EventRepository;
import com.moneymanager.MoneyManager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepo;

    ResponseMessage responseMessage;

    @Override
    public ResponseEntity<ResponseMessage> addEvent(@RequestBody Event event){
        if(eventRepo.countByEventName(event.getEventName()) > 0){
            responseMessage = new ResponseMessage("Sorry ! Event already exists !!!");
            return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.BAD_REQUEST);
        } else {
            Event savedEvent = eventRepo.save(event);
            responseMessage = new ResponseMessage("Added Successfully !!!");
            return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
        }

    }

    @Override
    public List<Event> eventList(int pageNumbmer, int pageSize){
        Pageable sortById =  PageRequest.of(
                pageNumbmer,
                pageSize,
                Sort.by("id").descending()
        );

        List<Event> events = eventRepo.findAll(sortById).getContent();
        return events;
    }

    @Override
    public List<Event> eventListWithPaging(int pageNumbmer, int pageSize){
        Pageable eventListPaging = PageRequest.of(
                pageNumbmer,
                pageSize
        );

        List<Event> eventListWithPaging = eventRepo.findAll(eventListPaging).getContent();
        return eventListWithPaging;
    }

    @Override
    public List<Event> eventListWithSorting(){
        Sort sortedEventList = Sort.by("id").descending();

        List<Event> eventListWithSorting = eventRepo.findAll(sortedEventList);
        return eventListWithSorting;
    }

    @Override
    public List<Event> eventListByType(Long typeId){
        Pageable pageable = PageRequest.of(
                0,
                1,
                Sort.by("id").descending()
        );
        List<Event> events = eventRepo.findByTypeId(typeId,pageable);
        return events;
    }
}
