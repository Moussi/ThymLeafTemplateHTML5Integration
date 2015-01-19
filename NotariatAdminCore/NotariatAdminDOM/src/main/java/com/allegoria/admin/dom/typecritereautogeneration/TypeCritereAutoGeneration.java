/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typecritereautogeneration;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_critere_auto_generation")
@NamedQueries({
    @NamedQuery(name = "TypeCritereAutoGeneration.findAll", query = "SELECT t FROM TypeCritereAutoGeneration t")})
public class TypeCritereAutoGeneration implements Serializable {
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
    @Lob
    @Size(max = 65535)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "COUPLE_CLASSIQUE")
    private Boolean coupleClassique;
    @Column(name = "COUPLE_SEPARE")
    private Boolean coupleSepare;
    @Column(name = "COUPLE_CHANGEMENT_REGIME")
    private Boolean coupleChangementRegime;
    @Column(name = "PERSONNE_COUPLE")
    private Boolean personneCouple;
    @Column(name = "PERSONNE_CELIBATAIRE")
    private Boolean personneCelibataire;
    @Column(name = "PERSONNE_MARIEE")
    private Boolean personneMariee;
    @Column(name = "PERSONNE_DIVORCEE")
    private Boolean personneDivorcee;
    @Column(name = "PERSONNE_PACSEE")
    private Boolean personnePacsee;
    @Column(name = "PERSONNE_VEUVE")
    private Boolean personneVeuve;
    @Column(name = "PERSONNE_MORALE_IMMAT")
    private Boolean personneMoraleImmat;
    @Column(name = "PERSONNE_MORALE_NON_IMMAT")
    private Boolean personneMoraleNonImmat;
    @Column(name = "TOUTE_PERSONNE_PHYSIQUE")
    private Boolean toutePersonnePhysique;
    @Column(name = "TOUTE_PERSONNE_MORALE")
    private Boolean toutePersonneMorale;
    @Column(name = "TOUTE_PERSONNE")
    private Boolean toutePersonne;
    @OneToMany(mappedBy = "critereAutoGenerationFk",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<TypeCourrier> typeCourrierCollection;

    public TypeCritereAutoGeneration() {
    }

    public TypeCritereAutoGeneration(Long id) {
        this.id = id;
    }

    public TypeCritereAutoGeneration(Long id, int versioning) {
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

    public Boolean getCoupleClassique() {
        return coupleClassique;
    }

    public void setCoupleClassique(Boolean coupleClassique) {
        this.coupleClassique = coupleClassique;
    }

    public Boolean getCoupleSepare() {
        return coupleSepare;
    }

    public void setCoupleSepare(Boolean coupleSepare) {
        this.coupleSepare = coupleSepare;
    }

    public Boolean getCoupleChangementRegime() {
        return coupleChangementRegime;
    }

    public void setCoupleChangementRegime(Boolean coupleChangementRegime) {
        this.coupleChangementRegime = coupleChangementRegime;
    }

    public Boolean getPersonneCouple() {
        return personneCouple;
    }

    public void setPersonneCouple(Boolean personneCouple) {
        this.personneCouple = personneCouple;
    }

    public Boolean getPersonneCelibataire() {
        return personneCelibataire;
    }

    public void setPersonneCelibataire(Boolean personneCelibataire) {
        this.personneCelibataire = personneCelibataire;
    }

    public Boolean getPersonneMariee() {
        return personneMariee;
    }

    public void setPersonneMariee(Boolean personneMariee) {
        this.personneMariee = personneMariee;
    }

    public Boolean getPersonneDivorcee() {
        return personneDivorcee;
    }

    public void setPersonneDivorcee(Boolean personneDivorcee) {
        this.personneDivorcee = personneDivorcee;
    }

    public Boolean getPersonnePacsee() {
        return personnePacsee;
    }

    public void setPersonnePacsee(Boolean personnePacsee) {
        this.personnePacsee = personnePacsee;
    }

    public Boolean getPersonneVeuve() {
        return personneVeuve;
    }

    public void setPersonneVeuve(Boolean personneVeuve) {
        this.personneVeuve = personneVeuve;
    }

    public Boolean getPersonneMoraleImmat() {
        return personneMoraleImmat;
    }

    public void setPersonneMoraleImmat(Boolean personneMoraleImmat) {
        this.personneMoraleImmat = personneMoraleImmat;
    }

    public Boolean getPersonneMoraleNonImmat() {
        return personneMoraleNonImmat;
    }

    public void setPersonneMoraleNonImmat(Boolean personneMoraleNonImmat) {
        this.personneMoraleNonImmat = personneMoraleNonImmat;
    }

    public Boolean getToutePersonnePhysique() {
        return toutePersonnePhysique;
    }

    public void setToutePersonnePhysique(Boolean toutePersonnePhysique) {
        this.toutePersonnePhysique = toutePersonnePhysique;
    }

    public Boolean getToutePersonneMorale() {
        return toutePersonneMorale;
    }

    public void setToutePersonneMorale(Boolean toutePersonneMorale) {
        this.toutePersonneMorale = toutePersonneMorale;
    }

    public Boolean getToutePersonne() {
        return toutePersonne;
    }

    public void setToutePersonne(Boolean toutePersonne) {
        this.toutePersonne = toutePersonne;
    }

    public Collection<TypeCourrier> getTypeCourrierCollection() {
        return typeCourrierCollection;
    }

    public void setTypeCourrierCollection(Collection<TypeCourrier> typeCourrierCollection) {
        this.typeCourrierCollection = typeCourrierCollection;
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
        if (!(object instanceof TypeCritereAutoGeneration)) {
            return false;
        }
        TypeCritereAutoGeneration other = (TypeCritereAutoGeneration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		
		return id+"";
	}

	

    
    
    
}
