package com.moneymanager.MoneyManager.controller;

import com.moneymanager.MoneyManager.entity.Event;
import com.moneymanager.MoneyManager.payload.ResponseMessage;
import com.moneymanager.MoneyManager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping("/listWithPagingAndSorting/{pageNumbmer}/{pageSize}")
    public List<Event> eventList(@Param("pageNumbmer") int pageNumbmer, @Param("pageSize") int pageSize){
        return eventService.eventList(pageNumbmer,pageSize);
    }

    @GetMapping("/listWithPaging/{pageNumber}/{pageSize}")
    public List<Event> eventListWithPaging(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize){
        return eventService.eventListWithPaging(pageNumber,pageSize);
    }

    @GetMapping("/listWithSorting")
    public List<Event> eventListWithSorting(){
        return eventService.eventListWithSorting();
    }

    @GetMapping("/listByType/{typeId}")
    public List<Event> eventListByType(@Param("typeId") Long typeId){
        return eventService.eventListByType(typeId);
    }

    @GetMapping("/byid/{id}")
    public Optional<Event> eventById(@Param("id") Long id){
        return eventService.eventById(id);
    }

    @DeleteMapping("/delete/byid/{id}")
    public ResponseEntity<ResponseMessage> eventDeleteById(@Param("id") Long id){
        return eventService.eventDeleteById(id);
    }

    @PutMapping("/update/byid/{id}")
    public Event eventUpdateById(@RequestBody Event event, @Param("id") Long id){
        return eventService.eventUpdateById(event,id);
    }
}
