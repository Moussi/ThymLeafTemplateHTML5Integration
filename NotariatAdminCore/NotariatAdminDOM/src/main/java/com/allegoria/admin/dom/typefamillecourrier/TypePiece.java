/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typefamillecourrier;

import java.io.Serializable;
import java.math.BigInteger;
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

import com.allegoria.admin.dom.dossier.TypeDossier;
import com.allegoria.admin.dom.typeacte.TypeComparant;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_piece")
@NamedQueries({
    @NamedQuery(name = "TypePiece.findAll", query = "SELECT t FROM TypePiece t")})
public class TypePiece implements Serializable {
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
    @Column(name = "LIBELLE")
    private String libelle;
    @Size(max = 255)
    @Column(name = "EMPLACEMENT")
    private String emplacement;
    @Size(max = 255)
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @Column(name = "GENRE_ACTE_ID")
    private BigInteger genreActeId;
    @Size(max = 255)
    @Column(name = "GENRE_ACTE_CODE")
    private String genreActeCode;
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name = "TYPES_COMPARANTS2TYPES_PIECES",  joinColumns = { 
			@JoinColumn(name = "TYPES_PIECES_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_COMPARANTS_FK", 
					nullable = false, updatable = false) })
    private Set<TypeComparant> typesComparants =new  HashSet<TypeComparant>();
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name = "TYPES_DOSSIERS2TYPES_PIECES", joinColumns = { 
			@JoinColumn(name = "TYPES_PIECES_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_DOSSIERS_FK", 
					nullable = false, updatable = false) })
    private Set<TypeDossier> typesDossiers= new  HashSet<TypeDossier>();
    
    public TypePiece() {
    }

    public TypePiece(Long id) {
        this.id = id;
    }

    public TypePiece(Long id, int versioning) {
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
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

    public BigInteger getGenreActeId() {
        return genreActeId;
    }

    public void setGenreActeId(BigInteger genreActeId) {
        this.genreActeId = genreActeId;
    }

    public String getGenreActeCode() {
        return genreActeCode;
    }

    public void setGenreActeCode(String genreActeCode) {
        this.genreActeCode = genreActeCode;
    }

    
    public Set<TypeComparant> getTypesComparants() {
		return typesComparants;
	}

	public void setTypesComparants(Set<TypeComparant> typesComparants) {
		this.typesComparants = typesComparants;
	}

	public Set<TypeDossier> getTypesDossiers() {
		return typesDossiers;
	}

	public void setTypesDossiers(Set<TypeDossier> typesDossiers) {
		this.typesDossiers = typesDossiers;
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
        if (!(object instanceof TypePiece)) {
            return false;
        }
        TypePiece other = (TypePiece) object;
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
