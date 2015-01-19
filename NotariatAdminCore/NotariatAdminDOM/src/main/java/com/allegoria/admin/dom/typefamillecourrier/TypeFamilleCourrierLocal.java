/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typefamillecourrier;

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
@Table(name = "type_famille_courrier_local")
@NamedQueries({
    @NamedQuery(name = "TypeFamilleCourrierLocal.findAll", query = "SELECT t FROM TypeFamilleCourrierLocal t")})
public class TypeFamilleCourrierLocal implements Serializable {
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
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @OneToMany(mappedBy = "familleFk")
    private Collection<TypeCourrierLocal> typeCourrierLocalCollection;

    public TypeFamilleCourrierLocal() {
    }

    public TypeFamilleCourrierLocal(Long id) {
        this.id = id;
    }

    public TypeFamilleCourrierLocal(Long id, int versioning) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public Collection<TypeCourrierLocal> getTypeCourrierLocalCollection() {
        return typeCourrierLocalCollection;
    }

    public void setTypeCourrierLocalCollection(Collection<TypeCourrierLocal> typeCourrierLocalCollection) {
        this.typeCourrierLocalCollection = typeCourrierLocalCollection;
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
        if (!(object instanceof TypeFamilleCourrierLocal)) {
            return false;
        }
        TypeFamilleCourrierLocal other = (TypeFamilleCourrierLocal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.typeacte.TypeFamilleCourrierLocal[ id=" + id + " ]";
    }
    
}
