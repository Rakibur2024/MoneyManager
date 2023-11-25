package com.moneymanager.MoneyManager.repository;

import com.moneymanager.MoneyManager.entity.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Long countByEventName(String eventName);
    List<Event> findByTypeId(Long typeId, Pageable pageable);
    Long countById(Long id);

}
