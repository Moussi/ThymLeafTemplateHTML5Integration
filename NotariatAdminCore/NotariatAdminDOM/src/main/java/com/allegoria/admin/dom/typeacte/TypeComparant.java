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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.typefamillecourrier.TypePiece;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_comparant")
@NamedQueries({
    @NamedQuery(name = "TypeComparant.findAll", query = "SELECT t FROM TypeComparant t")})
public class TypeComparant implements Serializable {
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
    @Column(name = "NOM")
    private String nom;
    @Size(max = 255)
    @Column(name = "OBJET")
    private String objet;
    @Column(name = "MULTIPLE")
    private Boolean multiple;
    @Column(name = "AUTRE")
    private Boolean autre;
    @Column(name = "PRESENCE_OBLIGATOIRE")
    private Boolean presenceObligatoire;
    @Column(name = "PRESENCE_ADRESSE")
    private Boolean presenceAdresse;
    @Column(name = "PRESENCE_EFFET_RELATIF")
    private Boolean presenceEffetRelatif;
    @ManyToMany(mappedBy="typeComparants",fetch=FetchType.EAGER)
    private Set<TypeActe> typesActe= new  HashSet<TypeActe>();
    @ManyToMany(mappedBy="typeComparants",fetch=FetchType.EAGER)
    private Set<TypeActeLocal> typesActeLocaux= new  HashSet<TypeActeLocal>();
    @ManyToMany(mappedBy="typesComparants",fetch=FetchType.EAGER)
    private Set<TypePiece> typesPieces= new  HashSet<TypePiece>();
    @ManyToMany(mappedBy="typeComparants",fetch=FetchType.EAGER)
    private Set<TypeRelationComparution> typesRelation= new  HashSet<TypeRelationComparution>();
    
    public TypeComparant() {
    }

    public TypeComparant(Long id) {
        this.id = id;
    }

    public TypeComparant(Long id, int versioning) {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public Boolean getAutre() {
        return autre;
    }

    public void setAutre(Boolean autre) {
        this.autre = autre;
    }

    public Boolean getPresenceObligatoire() {
        return presenceObligatoire;
    }

    public void setPresenceObligatoire(Boolean presenceObligatoire) {
        this.presenceObligatoire = presenceObligatoire;
    }

    public Boolean getPresenceAdresse() {
        return presenceAdresse;
    }

    public void setPresenceAdresse(Boolean presenceAdresse) {
        this.presenceAdresse = presenceAdresse;
    }

    public Boolean getPresenceEffetRelatif() {
        return presenceEffetRelatif;
    }

    public void setPresenceEffetRelatif(Boolean presenceEffetRelatif) {
        this.presenceEffetRelatif = presenceEffetRelatif;
    }
    
    
    
    public Set<TypeActe> getTypesActe() {
		return typesActe;
	}

	public void setTypesActe(Set<TypeActe> typesActe) {
		this.typesActe = typesActe;
	}

	public Set<TypeActeLocal> getTypesActeLocaux() {
		return typesActeLocaux;
	}

	public void setTypesActeLocaux(Set<TypeActeLocal> typesActeLocaux) {
		this.typesActeLocaux = typesActeLocaux;
	}

	public Set<TypePiece> getTypesPieces() {
		return typesPieces;
	}

	public void setTypesPieces(Set<TypePiece> typesPieces) {
		this.typesPieces = typesPieces;
	}

	public Set<TypeRelationComparution> getTypesRelation() {
		return typesRelation;
	}

	public void setTypesRelation(Set<TypeRelationComparution> typesRelation) {
		this.typesRelation = typesRelation;
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
        if (!(object instanceof TypeComparant)) {
            return false;
        }
        TypeComparant other = (TypeComparant) object;
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
