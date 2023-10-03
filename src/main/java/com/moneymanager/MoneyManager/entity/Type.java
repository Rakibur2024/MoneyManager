package com.moneymanager.MoneyManager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "type_name")
    private String typeName;
}
