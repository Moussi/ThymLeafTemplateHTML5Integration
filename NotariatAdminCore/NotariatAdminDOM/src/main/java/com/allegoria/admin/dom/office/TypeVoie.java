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
@Table(name = "type_voie")
@NamedQueries({
    @NamedQuery(name = "TypeVoie.findAll", query = "SELECT t FROM TypeVoie t")})
public class TypeVoie implements Serializable {
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
    @Column(name = "CODE")
    private String code;
    @Column(name = "POSITION")
    private Integer position;
    @Size(max = 255)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "COURANT")
    private Boolean courant;
    @OneToMany(mappedBy = "typeVoieFk")
    private Collection<AdresseOffice> adresseOfficeCollection;

    public TypeVoie() {
    }

    public TypeVoie(Long id) {
        this.id = id;
    }

    public TypeVoie(Long id, int versioning) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getCourant() {
        return courant;
    }

    public void setCourant(Boolean courant) {
        this.courant = courant;
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
        if (!(object instanceof TypeVoie)) {
            return false;
        }
        TypeVoie other = (TypeVoie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.typelocalfondpage.TypeVoie[ id=" + id + " ]";
    }
    
}
