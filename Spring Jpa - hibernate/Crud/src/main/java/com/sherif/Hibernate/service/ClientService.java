package com.sherif.Hibernate.service;


import com.sherif.Hibernate.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    private final EntityManager entityManager;

    @Autowired
    public ClientService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//    @Transactional
//    public Client create(Client client) {
//        entityManager.persist(client);
//        return client;
//    }
    @Transactional
    public Client createClient(Client client){
        Client client1=new Client(client);
        entityManager.persist(client1);
        return client1;
    }

//    @Transactional
//    public Client updateUser(Long id, String name, String email) {
//
//        Client user = entityManager.find(Client.class, id);
//
//        if (user == null) {
//            throw new RuntimeException("User not found");
//        }
//
//        user.setName(name);
//        user.setEmail(email);
//
//        return user;
//    }
    @Transactional
    public Client update(Client client) {
        return entityManager.merge(client);
    }


    public List<Client> getAllUsers() {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT u FROM Client u", Client.class
        );
        return query.getResultList();
    }

    
    //return one
    public Client getUser(Long id) {
        Client client = entityManager.find(Client.class, id);
        if (client == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return client;
    }

    @Transactional
    public void  deleteClient(Long id){
        Client client=entityManager.find(Client.class,id);
        if (client!=null)
            entityManager.remove(client);

    }
}
