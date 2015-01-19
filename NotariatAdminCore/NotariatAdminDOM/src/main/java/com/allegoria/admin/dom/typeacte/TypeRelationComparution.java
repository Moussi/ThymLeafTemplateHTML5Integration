/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typeacte;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_relation_comparution")
@NamedQueries({
    @NamedQuery(name = "TypeRelationComparution.findAll", query = "SELECT t FROM TypeRelationComparution t")})
public class TypeRelationComparution implements Serializable {
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
    @Column(name = "NOM_RELATION")
    private String nomRelation;
    @ManyToMany(mappedBy="typeRelationComparution",fetch=FetchType.EAGER)
    private Set<TypeActe> typesActe= new  HashSet<TypeActe>();
    @ManyToMany(mappedBy="typeRelationComparution")
    private Set<TypeActeLocal> typesActeLocaux= new  HashSet<TypeActeLocal>();
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name = "TYPES_COMPARANT2TYPES_RELATION",  joinColumns = { 
			@JoinColumn(name = "TYPES_RELATION_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_COMPARANT_FK", 
					nullable = false, updatable = false) })
    private Set<TypeComparant> typeComparants =new  HashSet<TypeComparant>();
    
    public TypeRelationComparution() {
    }

    public TypeRelationComparution(Long id) {
        this.id = id;
    }

    public TypeRelationComparution(Long id, int versioning) {
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

    public String getNomRelation() {
        return nomRelation;
    }

    public void setNomRelation(String nomRelation) {
        this.nomRelation = nomRelation;
    }
    
    
    public Set<TypeActe> getTypesActe() {
		return typesActe;
	}

	public void setTypesActe(Set<TypeActe> typesActe) {
		this.typesActe = typesActe;
	}

	

	
	public Set<TypeComparant> getTypeComparants() {
		return typeComparants;
	}

	public void setTypeComparants(Set<TypeComparant> typeComparants) {
		this.typeComparants = typeComparants;
	}

	public Set<TypeActeLocal> getTypesActeLocaux() {
		return typesActeLocaux;
	}

	public void setTypesActeLocaux(Set<TypeActeLocal> typesActeLocaux) {
		this.typesActeLocaux = typesActeLocaux;
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
        if (!(object instanceof TypeRelationComparution)) {
            return false;
        }
        TypeRelationComparution other = (TypeRelationComparution) object;
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
