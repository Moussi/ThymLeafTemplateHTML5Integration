/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.office;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "topad")
@NamedQueries({
    @NamedQuery(name = "Topad.findAll", query = "SELECT t FROM Topad t")})
public class Topad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSIONING")
    private int versioning;
    @Size(max = 255)
    @Column(name = "CODE_DEPARTEMENT")
    private String codeDepartement;
    @Size(max = 255)
    @Column(name = "CODE_COMMUNE")
    private String codeCommune;
    @Size(max = 255)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Size(max = 255)
    @Column(name = "NOM_VILLE")
    private String nomVille;
    @Size(max = 255)
    @Column(name = "CODE_SAGES")
    private String codeSages;
    @Column(name = "FICTIF")
    private Boolean fictif;
    @Column(name = "ANCIENNE_COMMUNE")
    private Boolean ancienneCommune;
    @Column(name = "BUREAUX_FK")
    private Integer bureauxFk;
    @Size(max = 255)
    @Column(name = "NOM_VILLE_INSEE")
    private String nomVilleInsee;
    @Column(name = "TAUX_FK")
    private Integer tauxFk;
    @OneToMany(mappedBy = "topadFk")
    private Collection<AdresseOffice> adresseOfficeCollection;

    public Topad() {
    }

    public Topad(Long id) {
        this.id = id;
    }

    public Topad(Long id, int versioning) {
        this.id = id;
        this.versioning = versioning;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersioning() {
        return versioning;
    }

    public void setVersioning(int versioning) {
        this.versioning = versioning;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getCodeSages() {
        return codeSages;
    }

    public void setCodeSages(String codeSages) {
        this.codeSages = codeSages;
    }

    public Boolean getFictif() {
        return fictif;
    }

    public void setFictif(Boolean fictif) {
        this.fictif = fictif;
    }

    public Boolean getAncienneCommune() {
        return ancienneCommune;
    }

    public void setAncienneCommune(Boolean ancienneCommune) {
        this.ancienneCommune = ancienneCommune;
    }

    public Integer getBureauxFk() {
        return bureauxFk;
    }

    public void setBureauxFk(Integer bureauxFk) {
        this.bureauxFk = bureauxFk;
    }

    public String getNomVilleInsee() {
        return nomVilleInsee;
    }

    public void setNomVilleInsee(String nomVilleInsee) {
        this.nomVilleInsee = nomVilleInsee;
    }

    public Integer getTauxFk() {
        return tauxFk;
    }

    public void setTauxFk(Integer tauxFk) {
        this.tauxFk = tauxFk;
    }

    public Collection<AdresseOffice> getAdresseOfficeCollection() {
        return adresseOfficeCollection;
    }

    public void setAdresseOfficeCollection(Collection<AdresseOffice> adresseOfficeCollection) {
        this.adresseOfficeCollection = adresseOfficeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topad)) {
            return false;
        }
        Topad other = (Topad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.typelocalfondpage.Topad[ id=" + id + " ]";
    }
    
}
