package com.sherif.Hibernate.service;


import com.sherif.Hibernate.entity.Client;
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
//    public Client create(Client client) {
//        entityManager.persist(client);
//        return client;
//    }

    @Override
    @Transactional
    public Client create(Client client){
        Client client1=new Client(client);
        entityManager.persist(client1);
        return client1;
    }

    @Override
    public Client findById(Long id) {
        Client client = entityManager.find(Client.class, id);
        if (client == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT u FROM Client u", Client.class
        );
        return query.getResultList();
    }

    @Override
    @Transactional
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    @Override
    @Transactional
    public void  delete(Long id){
        Client client=entityManager.find(Client.class,id);
        if (client!=null)
            entityManager.remove(client);

    }
}
