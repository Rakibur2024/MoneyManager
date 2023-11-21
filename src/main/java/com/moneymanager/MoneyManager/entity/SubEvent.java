package com.moneymanager.MoneyManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_events")
public class SubEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sub_event_name")
    private String subEventName;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "event_id",
            referencedColumnName = "id"
    )
    private Event event;
}
