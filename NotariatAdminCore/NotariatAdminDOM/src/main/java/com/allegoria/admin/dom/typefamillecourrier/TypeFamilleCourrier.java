/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typefamillecourrier;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.dossier.TypeDossier;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_famille_courrier")
@NamedQueries({
    @NamedQuery(name = "TypeFamilleCourrier.findAll", query = "SELECT t FROM TypeFamilleCourrier t")})
public class TypeFamilleCourrier implements Serializable {
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
    
    @OneToMany(mappedBy = "familleMereFk")
    private Collection<TypeFamilleCourrier> typeFamilleCourrierCollection;
    @JoinColumn(name = "FAMILLE_MERE_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeFamilleCourrier familleMereFk;
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name = "TYPES_COURRIERS2TYPES_FAMILLES", joinColumns = { 
			@JoinColumn(name = "TYPES_FAMILLES_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_COURRIERS_FK", 
					nullable = false, updatable = false) })
    
    private Set<TypeCourrier> typeCourriers= new  HashSet<TypeCourrier>();
    
   
    

	public Set<TypeCourrier> getTypeCourriers() {
		return typeCourriers;
	}

	public void setTypeCourriers(Set<TypeCourrier> typeCourriers) {
		this.typeCourriers = typeCourriers;
	}

	public TypeFamilleCourrier() {
    }

    public TypeFamilleCourrier(Long id) {
        this.id = id;
    }

    public TypeFamilleCourrier(Long id, int versioning) {
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

   

    public Collection<TypeFamilleCourrier> getTypeFamilleCourrierCollection() {
        return typeFamilleCourrierCollection;
    }

    public void setTypeFamilleCourrierCollection(Collection<TypeFamilleCourrier> typeFamilleCourrierCollection) {
        this.typeFamilleCourrierCollection = typeFamilleCourrierCollection;
    }

    public TypeFamilleCourrier getFamilleMereFk() {
        return familleMereFk;
    }

    public void setFamilleMereFk(TypeFamilleCourrier familleMereFk) {
        this.familleMereFk = familleMereFk;
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
        if (!(object instanceof TypeFamilleCourrier)) {
            return false;
        }
        TypeFamilleCourrier other = (TypeFamilleCourrier) object;
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
