package com.moneymanager.MoneyManager.repository;

import com.moneymanager.MoneyManager.entity.SubEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubEventRepository extends JpaRepository<SubEvent, Long> {
}
