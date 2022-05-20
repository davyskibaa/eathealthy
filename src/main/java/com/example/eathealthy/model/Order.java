package com.example.eathealthy.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kit;

    private String date;

    private String time;

    private String address;

    private String wishes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {}

    public Order(String kit, String date, String time, String address, String wishes, User user) {
        this.kit = kit;
        this.date = date;
        this.time = time;
        this.address = address;
        this.wishes = wishes;
        this.user = user;
    }
}
