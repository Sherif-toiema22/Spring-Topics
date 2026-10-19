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
    public List<Client> findAll() {

        // create a query
        TypedQuery<Client> theQuery = entityManager.createQuery("from Client", Client.class);

        // execute query and get result list
        List<Client> clients = theQuery.getResultList();

        // return the results
        return clients;
    }
}










