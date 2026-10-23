package com.sherif.Hibernate.dao;

import com.sherif.Hibernate.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOJpaImpl implements ClientDao {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public ClientDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public Client create(Client client) {
//        Client client1=new Client();
//        entityManager.per
        return entityManager.merge(client);
    }

    @Override
    public Client findById(Long id) {
        Client client=entityManager.find(Client.class,id);
        if (client ==null)
            throw new RuntimeException("User not found with id: " + id);
        return client;
    }

    @Override
    public List<Client> findAll() {

        // create a query
        TypedQuery<Client> theQuery = entityManager.createQuery("from Client", Client.class);

        // execute query and get result list
        List<Client> clients = theQuery.getResultList();

        // return the results
        return clients;
    }

    @Override
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    @Override
    public void delete(Long id) {
        Client client=entityManager.find(Client.class,id);
        if (client ==null)
            throw new RuntimeException("User not found with id: " + id);
        entityManager.remove(client);

    }
}










