package com.moneymanager.MoneyManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "types")
public class Type {
    @Id
    private Long id;

    @Column(name = "type_name")
    private String typeName;
}
