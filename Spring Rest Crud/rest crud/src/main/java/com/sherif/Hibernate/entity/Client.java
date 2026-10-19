package com.sherif.Hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;



    @Transient
    private Client client;


    public Client(String mShelf, String mail) {
        this.name=name;
        this.email=email;
    }
}
