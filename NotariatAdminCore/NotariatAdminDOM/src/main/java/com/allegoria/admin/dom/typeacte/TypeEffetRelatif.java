/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typeacte;

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
@Table(name = "type_effet_relatif")
@NamedQueries({
    @NamedQuery(name = "TypeEffetRelatif.findAll", query = "SELECT t FROM TypeEffetRelatif t")})
public class TypeEffetRelatif implements Serializable {
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
    @Column(name = "NATURE")
    private String nature;
    @Column(name = "HISTORIQUE")
    private Boolean historique;
    @OneToMany(mappedBy = "typeEffetFk")
    private Collection<TypeActe> typeActeCollection;

    public TypeEffetRelatif() {
    }

    public TypeEffetRelatif(Long id) {
        this.id = id;
    }

    public TypeEffetRelatif(Long id, int versioning) {
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

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Boolean getHistorique() {
        return historique;
    }

    public void setHistorique(Boolean historique) {
        this.historique = historique;
    }

    public Collection<TypeActe> getTypeActeCollection() {
        return typeActeCollection;
    }

    public void setTypeActeCollection(Collection<TypeActe> typeActeCollection) {
        this.typeActeCollection = typeActeCollection;
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
        if (!(object instanceof TypeEffetRelatif)) {
            return false;
        }
        TypeEffetRelatif other = (TypeEffetRelatif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }
    
}
