/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import asn.tech.tpcustomercherifa.entity.Client;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Gère la persistance des Clients.
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Client> getAllCustomers() {
        Query query = em.createNamedQuery("Client.findAll");
        return query.getResultList();
    }

    @Transactional
    public Client update(Client client) {
        return em.merge(client);
    }

    @Transactional
    public void persist(Client client) {
        em.persist(client);
    }
}
