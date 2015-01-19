/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.bl.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Allégoria
 */

public class AdresseOfficeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long id;
   
    private int versioning;
   
    private Date modifieLe;
   
    private String numeroVoie;
   
    private String ordreVoie;
    
    private String nomVoie;
  
    private String boitePostale;
  
    private String gps;
  
    private String residence;
    
    private String lieudit;
   
    private Boolean acheve;
    
    private Date dateAcheve;
    private String batiment;
    private String etage;
    private String escalier;
    private String litteral;
    private String villeCedex;
    private Collection<Long> officeCollection;
    private Long typeVoieFk;
    private Long topadFk;
    private Collection<Long> annexeCollection;

    public AdresseOfficeDTO() {
    }

    public AdresseOfficeDTO(Long id) {
        this.id = id;
    }

    public AdresseOfficeDTO(Long id, int versioning) {
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

    public Date getModifieLe() {
        return modifieLe;
    }

    public void setModifieLe(Date modifieLe) {
        this.modifieLe = modifieLe;
    }

    public String getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(String numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getOrdreVoie() {
        return ordreVoie;
    }

    public void setOrdreVoie(String ordreVoie) {
        this.ordreVoie = ordreVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(String boitePostale) {
        this.boitePostale = boitePostale;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getLieudit() {
        return lieudit;
    }

    public void setLieudit(String lieudit) {
        this.lieudit = lieudit;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public Date getDateAcheve() {
        return dateAcheve;
    }

    public void setDateAcheve(Date dateAcheve) {
        this.dateAcheve = dateAcheve;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getEscalier() {
        return escalier;
    }

    public void setEscalier(String escalier) {
        this.escalier = escalier;
    }

    public String getLitteral() {
        return litteral;
    }

    public void setLitteral(String litteral) {
        this.litteral = litteral;
    }

    public String getVilleCedex() {
        return villeCedex;
    }

    public void setVilleCedex(String villeCedex) {
        this.villeCedex = villeCedex;
    }

 

    public Collection<Long> getOfficeCollection() {
		return officeCollection;
	}

	public void setOfficeCollection(Collection<Long> officeCollection) {
		this.officeCollection = officeCollection;
	}

	public Long getTypeVoieFk() {
		return typeVoieFk;
	}

	public void setTypeVoieFk(Long typeVoieFk) {
		this.typeVoieFk = typeVoieFk;
	}

	public Long getTopadFk() {
		return topadFk;
	}

	public void setTopadFk(Long topadFk) {
		this.topadFk = topadFk;
	}

	public Collection<Long> getAnnexeCollection() {
		return annexeCollection;
	}

	public void setAnnexeCollection(Collection<Long> annexeCollection) {
		this.annexeCollection = annexeCollection;
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
        if (!(object instanceof AdresseOfficeDTO)) {
            return false;
        }
        AdresseOfficeDTO other = (AdresseOfficeDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"").append(id).append("\",\"versioning\":\"")
				.append(versioning).append("\",\"modifieLe\":\"")
				.append(modifieLe).append("\",\"numeroVoie\":\"")
				.append(numeroVoie).append("\",\"ordreVoie\":\"")
				.append(ordreVoie).append("\",\"nomVoie\":\"").append(nomVoie)
				.append("\",\"boitePostale\":\"").append(boitePostale)
				.append("\",\"gps\":\"").append(gps)
				.append("\",\"residence\":\"").append(residence)
				.append("\",\"lieudit\":\"").append(lieudit)
				.append("\",\"acheve\":\"").append(acheve)
				.append("\",\"dateAcheve\":\"").append(dateAcheve)
				.append("\",\"batiment\":\"").append(batiment)
				.append("\",\"etage\":\"").append(etage)
				.append("\",\"escalier\":\"").append(escalier)
				.append("\",\"litteral\":\"").append(litteral)
				.append("\",\"villeCedex\":\"").append(villeCedex)
				.append("\",\"officeCollection\":\"").append(officeCollection)
				.append("\",\"typeVoieFk\":\"").append(typeVoieFk)
				.append("\",\"topadFk\":\"").append(topadFk).append("\"}");
		return builder.toString();
	}

	

    
    
}
