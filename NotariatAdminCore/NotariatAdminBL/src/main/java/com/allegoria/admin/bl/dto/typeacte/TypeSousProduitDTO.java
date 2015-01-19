/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.bl.dto.typeacte;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.typeacte.TypeActe;
import com.allegoria.admin.dom.typeacte.TypeSousProduit;

/**
 *
 * @author Allégoria
 */
public class TypeSousProduitDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private int versioning;
    private String nom;
    private BigInteger varianteId;
    private Boolean acheve;
    private Boolean pourDepot;
    private Boolean autoGenere;
    private String famille;
    private String signaturePlanete;
    private String entete;
    private String occurrence;
    private String emplacement;
    private String genre;
    private String varianteCode;
    private Boolean copieActe;
    private Boolean avecMarge;
    private Boolean avecStyle;
    private Long typeActeFk;

    public TypeSousProduitDTO() {
    }

    public TypeSousProduitDTO(Long id) {
        this.id = id;
    }

    public TypeSousProduitDTO(Long id, int versioning) {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigInteger getVarianteId() {
        return varianteId;
    }

    public void setVarianteId(BigInteger varianteId) {
        this.varianteId = varianteId;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public Boolean getPourDepot() {
        return pourDepot;
    }

    public void setPourDepot(Boolean pourDepot) {
        this.pourDepot = pourDepot;
    }

    public Boolean getAutoGenere() {
        return autoGenere;
    }

    public void setAutoGenere(Boolean autoGenere) {
        this.autoGenere = autoGenere;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getSignaturePlanete() {
        return signaturePlanete;
    }

    public void setSignaturePlanete(String signaturePlanete) {
        this.signaturePlanete = signaturePlanete;
    }

    public String getEntete() {
        return entete;
    }

    public void setEntete(String entete) {
        this.entete = entete;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
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

    public String getVarianteCode() {
        return varianteCode;
    }

    public void setVarianteCode(String varianteCode) {
        this.varianteCode = varianteCode;
    }

    

    public Boolean getCopieActe() {
		return copieActe;
	}

	public void setCopieActe(Boolean copieActe) {
		this.copieActe = copieActe;
	}

	public Boolean getAvecMarge() {
		return avecMarge;
	}

	public void setAvecMarge(Boolean avecMarge) {
		this.avecMarge = avecMarge;
	}

	public Boolean getAvecStyle() {
		return avecStyle;
	}

	public void setAvecStyle(Boolean avecStyle) {
		this.avecStyle = avecStyle;
	}

	
    public Long getTypeActeFk() {
		return typeActeFk;
	}

	public void setTypeActeFk(Long typeActeFk) {
		this.typeActeFk = typeActeFk;
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
        if (!(object instanceof TypeSousProduitDTO)) {
            return false;
        }
        TypeSousProduitDTO other = (TypeSousProduitDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"").append(id).append("\",\"versioning\":\"")
				.append(versioning).append("\",\"nom\":\"").append(nom)
				.append("\",\"varianteId\":\"").append(varianteId)
				.append("\",\"acheve\":\"").append(acheve)
				.append("\",\"pourDepot\":\"").append(pourDepot)
				.append("\",\"autoGenere\":\"").append(autoGenere)
				.append("\",\"famille\":\"").append(famille)
				.append("\",\"signaturePlanete\":\"").append(signaturePlanete)
				.append("\",\"entete\":\"").append(entete)
				.append("\",\"occurrence\":\"").append(occurrence)
				.append("\",\"emplacement\":\"").append(emplacement)
				.append("\",\"genre\":\"").append(genre)
				.append("\",\"varianteCode\":\"").append(varianteCode)
				.append("\",\"copieActe\":\"").append(copieActe)
				.append("\",\"avecMarge\":\"").append(avecMarge)
				.append("\",\"avecStyle\":\"").append(avecStyle)
				.append("\",\"typeActeFk\":\"").append(typeActeFk)
				.append("\"}");
		return builder.toString();
	}

   
    
}
