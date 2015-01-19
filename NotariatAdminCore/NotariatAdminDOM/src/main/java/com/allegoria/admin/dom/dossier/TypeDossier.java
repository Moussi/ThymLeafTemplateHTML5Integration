/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.dossier;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.typeacte.TypeRelationComparution;
import com.allegoria.admin.dom.typefamillecourrier.TypeComparutionCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrierLocal;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleMereCourrier;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_dossier")
@NamedQueries({
    @NamedQuery(name = "TypeDossier.findAll", query = "SELECT t FROM TypeDossier t")})
public class TypeDossier implements Serializable {
    
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
    @OneToMany(mappedBy = "typeDossierFk")
    private Collection<TypeCourrier> typeCourrierCollection;
    @OneToMany(mappedBy = "typeDossierFk")
    private Collection<TypeCourrierLocal> typeCourrierLocalCollection;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TYPE_DOSSIER2TYPES_COMPARUTIONS", joinColumns = { 
			@JoinColumn(name = "TYPE_DOSSIER_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_COMPARUTIONS_FK", 
					nullable = false, updatable = false) })
    private Set<TypeComparutionCourrier> typeComparutionCourriers= new  HashSet<TypeComparutionCourrier>();
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TYPES_DOSSIERS2TYPES_FAMILLES_MERES", joinColumns = { 
    		@JoinColumn(name = "TYPES_DOSSIERS_FK", nullable = false, updatable = false) }, 
    		inverseJoinColumns = { @JoinColumn(name = "TYPES_FAMILLES_MERES_FK", 
    		nullable = false, updatable = false) })
    private Set<TypeFamilleMereCourrier> typeFamilleMereCourriers= new  HashSet<TypeFamilleMereCourrier>();
    
    
    public TypeDossier() {
    }

    public TypeDossier(Long id) {
        this.id = id;
    }

    public TypeDossier(Long id, int versioning) {
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
    
    

    public Set<TypeComparutionCourrier> getTypeComparutionCourriers() {
		return typeComparutionCourriers;
	}

	public void setTypeComparutionCourriers(
			Set<TypeComparutionCourrier> typeComparutionCourriers) {
		this.typeComparutionCourriers = typeComparutionCourriers;
	}

	public Set<TypeFamilleMereCourrier> getTypeFamilleMereCourriers() {
		return typeFamilleMereCourriers;
	}

	public void setTypeFamilleMereCourriers(
			Set<TypeFamilleMereCourrier> typeFamilleMereCourriers) {
		this.typeFamilleMereCourriers = typeFamilleMereCourriers;
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
        if (!(object instanceof TypeDossier)) {
            return false;
        }
        TypeDossier other = (TypeDossier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }

    public Collection<TypeCourrier> getTypeCourrierCollection() {
        return typeCourrierCollection;
    }

    public void setTypeCourrierCollection(Collection<TypeCourrier> typeCourrierCollection) {
        this.typeCourrierCollection = typeCourrierCollection;
    }
    
}
