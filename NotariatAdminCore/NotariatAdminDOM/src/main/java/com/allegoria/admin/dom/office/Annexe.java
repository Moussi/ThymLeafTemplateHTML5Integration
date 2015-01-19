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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Entity
@Table(name = "annexe")
@NamedQueries({
    @NamedQuery(name = "Annexe.findAll", query = "SELECT a FROM Annexe a")})
public class Annexe implements Serializable {
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
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "SIEGE")
    private Boolean siege;
    @OneToMany(mappedBy = "annexeFk")
    private Collection<Utilisateur> utilisateurCollection;
    @JoinColumn(name = "OFFICE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Office officeFk;
    @JoinColumn(name = "COORDONNEE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Coordonnee coordonneeFk;
    @JoinColumn(name = "ADRESSE_FK", referencedColumnName = "ID")
    @ManyToOne
    private AdresseOffice adresseFk;

    public Annexe() {
    }

    public Annexe(Long id) {
        this.id = id;
    }

    public Annexe(Long id, int versioning) {
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getSiege() {
        return siege;
    }

    public void setSiege(Boolean siege) {
        this.siege = siege;
    }

    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    public Office getOfficeFk() {
        return officeFk;
    }

    public void setOfficeFk(Office officeFk) {
        this.officeFk = officeFk;
    }

    public Coordonnee getCoordonneeFk() {
        return coordonneeFk;
    }

    public void setCoordonneeFk(Coordonnee coordonneeFk) {
        this.coordonneeFk = coordonneeFk;
    }

    public AdresseOffice getAdresseFk() {
        return adresseFk;
    }

    public void setAdresseFk(AdresseOffice adresseFk) {
        this.adresseFk = adresseFk;
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
        if (!(object instanceof Annexe)) {
            return false;
        }
        Annexe other = (Annexe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.typelocalfondpage.Annexe[ id=" + id + " ]";
    }
    
}
