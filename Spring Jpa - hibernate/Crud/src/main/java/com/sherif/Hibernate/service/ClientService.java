package com.sherif.Hibernate.service;

import com.sherif.Hibernate.entity.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Client client);
    void delete(Long id);

}
