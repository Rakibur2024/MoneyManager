package com.moneymanager.MoneyManager.service;

import com.moneymanager.MoneyManager.entity.Event;
import com.moneymanager.MoneyManager.payload.ResponseMessage;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface EventService {
    public ResponseEntity<ResponseMessage> addEvent(@RequestBody Event event);
    public List<Event> eventList(int pageNumbmer, int pageSize);
    public List<Event> eventListWithPaging(int pageNumbmer, int pageSize);
    public List<Event> eventListWithSorting();
    public List<Event> eventListByType(Long typeId);

    public Optional<Event> eventById(Long id);
    public ResponseEntity<ResponseMessage> eventDeleteById(Long id);
    public Event eventUpdateById(Event event, Long id);
}
