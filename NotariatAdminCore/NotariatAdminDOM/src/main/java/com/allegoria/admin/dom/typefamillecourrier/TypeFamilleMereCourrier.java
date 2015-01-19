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
import javax.persistence.Lob;
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
@Table(name = "type_famille_mere_courrier")
@NamedQueries({
    @NamedQuery(name = "TypeFamilleMereCourrier.findAll", query = "SELECT t FROM TypeFamilleMereCourrier t")})
public class TypeFamilleMereCourrier implements Serializable {
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
    @Column(name = "OFFICE")
    private Boolean office;
    @Column(name = "NON_AFFICHE")
    private Boolean nonAffiche;
    @Lob
    @Size(max = 65535)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name = "TYPES_FAMILLES_FILLES2TYPES_FAMILLES_MER", joinColumns = { 
			@JoinColumn(name = "TYPES_FAMILLES_MERES_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_FAMILLES_FILLES_FK", 
					nullable = false, updatable = false) })
    private Set<TypeFamilleCourrier> typeFamilleCourriers= new  HashSet<TypeFamilleCourrier>();
    
    
    public TypeFamilleMereCourrier() {
    }

    public TypeFamilleMereCourrier(Long id) {
        this.id = id;
    }

    public TypeFamilleMereCourrier(Long id, int versioning) {
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

    public Boolean getOffice() {
        return office;
    }

    public void setOffice(Boolean office) {
        this.office = office;
    }

    public Boolean getNonAffiche() {
        return nonAffiche;
    }

    public void setNonAffiche(Boolean nonAffiche) {
        this.nonAffiche = nonAffiche;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
    public Set<TypeFamilleCourrier> getTypeFamilleCourriers() {
		return typeFamilleCourriers;
	}

	public void setTypeFamilleCourriers(
			Set<TypeFamilleCourrier> typeFamilleCourriers) {
		this.typeFamilleCourriers = typeFamilleCourriers;
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
        if (!(object instanceof TypeFamilleMereCourrier)) {
            return false;
        }
        TypeFamilleMereCourrier other = (TypeFamilleMereCourrier) object;
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
