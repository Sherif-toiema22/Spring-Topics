package com.sherif.Hibernate.dao;

import com.sherif.Hibernate.entity.Client;

import java.util.List;

public interface ClientDao {

    Client create(Client client);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Client client);
    void delete(Long id);

}
