/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typefamillecourrier;

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
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.allegoria.admin.dom.dossier.TypeDossier;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_comparution_courrier")
@NamedQueries({
    @NamedQuery(name = "TypeComparutionCourrier.findAll", query = "SELECT t FROM TypeComparutionCourrier t")})
public class TypeComparutionCourrier implements Serializable {
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
    @Column(name = "TYPE_COMPARUTION")
    private String typeComparution;
    @ManyToMany(mappedBy="typeComparutionCourriers")
    private Set<TypeDossier> typedossiers= new  HashSet<TypeDossier>();
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "TYPES_COMPARUTIONS2TYPES_COURRIERS" ,joinColumns = { 
            @JoinColumn(name = "TYPES_COMPARUTIONS_FK", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "TYPES_COURRIERS_FK", nullable = false, updatable = false) })
	@OrderColumn(name="TYPE_COMPARUTION_COURRIER_TYPES_COURRIERS_IDX")
	private Set<TypeCourrier> typeCourriers= new  HashSet<TypeCourrier>();
	
    
    public TypeComparutionCourrier() {
    }

    public TypeComparutionCourrier(Long id) {
        this.id = id;
    }

    public TypeComparutionCourrier(Long id, int versioning) {
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

    public String getTypeComparution() {
        return typeComparution;
    }

    public void setTypeComparution(String typeComparution) {
        this.typeComparution = typeComparution;
    }
    
    
    public Set<TypeDossier> getTypedossiers() {
		return typedossiers;
	}

	public void setTypedossiers(Set<TypeDossier> typedossiers) {
		this.typedossiers = typedossiers;
	}
	
	

	public Set<TypeCourrier> getTypeCourriers() {
		return typeCourriers;
	}

	public void setTypeCourriers(Set<TypeCourrier> typeCourriers) {
		this.typeCourriers = typeCourriers;
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
        if (!(object instanceof TypeComparutionCourrier)) {
            return false;
        }
        TypeComparutionCourrier other = (TypeComparutionCourrier) object;
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
