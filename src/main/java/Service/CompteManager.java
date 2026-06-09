/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import asn.tech.tpcustomercherifa.entity.Compte;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Gère la persistance des Comptes.
 */
@RequestScoped
public class CompteManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Compte> getAllComptes() {
        return em.createNamedQuery("Compte.findAll", Compte.class).getResultList();
    }

    public Compte findById(String code) {
        return em.find(Compte.class, code);
    }
}
