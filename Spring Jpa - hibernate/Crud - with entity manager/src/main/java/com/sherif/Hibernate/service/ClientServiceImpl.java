package com.sherif.Hibernate.service;


import com.sherif.Hibernate.entity.Client;
import com.sherif.Hibernate.entity.CreateUserRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{


    private final EntityManager entityManager;

    @Autowired
    public ClientServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Transactional
//    public Client create(CreateUserRequest request) {
//        Client client = new Client();
//        client.setName(request.name());
//        client.setEmail(request.email());
//
//        return clientRepository.save(client);
//    }


    @Override
    @Transactional
    public Client create(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client findById(Long id) {
        return entityManager.find(Client.class,id);
    }

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> theQuery = entityManager.createQuery("FROM Client",Client.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Client> findByLastName(String theLastName) {
        TypedQuery<Client> typedQuery=entityManager.createQuery(
                "FROM Client WHERE lastName=:thData",Client.class);
        typedQuery.setParameter("thData",theLastName);
        return typedQuery.getResultList();
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
