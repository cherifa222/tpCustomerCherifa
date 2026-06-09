/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asn.tech.tpcustomercherifa.jsf;

import asn.tech.tpcustomercherifa.entity.Compte;
import Service.CompteManager;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

/**
 * Convertisseur pour l'entité Compte.
 */
@FacesConverter(value = "compteConverter", managed = true)
public class CompteConverter implements Converter<Compte> {

    @Inject
    private CompteManager compteManager;

    /**
     * Convertit une String en Compte.
     */
    @Override
    public Compte getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) return null;
        return compteManager.findById(value);
    }

    /**
     * Convertit un Compte en String.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Compte compte) {
        if (compte == null) return "";
        return compte.getCode();
    }
}
