package com.moneymanager.MoneyManager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "amounts")
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    @JsonFormat(pattern = "YYYY-mm-dd")
    private Date date;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "event_id",
            referencedColumnName = "id"
    )
    private Event event;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "sub_event_id",
            referencedColumnName = "id"
    )
    private SubEvent subEvent;
}
