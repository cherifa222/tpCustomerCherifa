/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package asn.tech.tpcustomercherifa.jsf;

import asn.tech.tpcustomercherifa.entity.Client;
import asn.tech.tpcustomercherifa.entity.Compte;
import Service.CompteManager;
import service.CustomerManager;
import java.io.Serializable;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 * Backing bean pour la page customerDetails.xhtml.
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Client customer;

    @Inject
    private CustomerManager customerManager;

    @Inject
    private CompteManager compteManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Client getCustomer() {
        return customer;
    }

    /**
     * Retourne la liste de tous les Comptes.
     */
    public List<Compte> getComptes() {
        return compteManager.getAllComptes();
    }

    /**
     * Met à jour dans la base de données les données du client.
     * @return la prochaine page à afficher.
     */
    public String update() {
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }
}