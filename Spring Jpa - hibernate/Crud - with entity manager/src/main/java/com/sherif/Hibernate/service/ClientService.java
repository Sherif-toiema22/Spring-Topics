package com.sherif.Hibernate.service;

import com.sherif.Hibernate.entity.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client);
    Client findById(Long id);
    List<Client> findAll();
    List<Client> findByLastName(String theLastName);
    Client update(Client client);
    int update(Long id, String firstName, String lastName, String email);
    void delete(Long id);

}
