package com.sherif.Hibernate.dao;

import com.sherif.Hibernate.entity.Client;

import java.util.List;

public interface ClientDao {
    List<Client> findAll();

}
