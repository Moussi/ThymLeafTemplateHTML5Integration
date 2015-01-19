/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.office;

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


/**
 *
 * @author user
 */
@Entity
@Table(name = "adresse_office")
@NamedQueries({
    @NamedQuery(name = "AdresseOffice.findAll", query = "SELECT a FROM AdresseOffice a")})
public class AdresseOffice implements Serializable {
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
    @Column(name = "MODIFIE_LE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieLe;
    @Size(max = 255)
    @Column(name = "NUMERO_VOIE")
    private String numeroVoie;
    @Size(max = 255)
    @Column(name = "ORDRE_VOIE")
    private String ordreVoie;
    @Size(max = 255)
    @Column(name = "NOM_VOIE")
    private String nomVoie;
    @Size(max = 255)
    @Column(name = "BOITE_POSTALE")
    private String boitePostale;
    @Size(max = 255)
    @Column(name = "GPS")
    private String gps;
    @Size(max = 255)
    @Column(name = "RESIDENCE")
    private String residence;
    @Size(max = 255)
    @Column(name = "LIEUDIT")
    private String lieudit;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @Column(name = "DATE_ACHEVE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcheve;
    @Size(max = 255)
    @Column(name = "BATIMENT")
    private String batiment;
    @Size(max = 255)
    @Column(name = "ETAGE")
    private String etage;
    @Size(max = 255)
    @Column(name = "ESCALIER")
    private String escalier;
    @Size(max = 255)
    @Column(name = "LITTERAL")
    private String litteral;
    @Size(max = 255)
    @Column(name = "VILLE_CEDEX")
    private String villeCedex;
    @OneToMany(mappedBy = "adresseFk")
    private Collection<Office> officeCollection;
    @JoinColumn(name = "TYPE_VOIE_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeVoie typeVoieFk;
    @JoinColumn(name = "TOPAD_FK", referencedColumnName = "ID")
    @ManyToOne
    private Topad topadFk;
    @OneToMany(mappedBy = "adresseFk")
    private Collection<Annexe> annexeCollection;

    public AdresseOffice() {
    }

    public AdresseOffice(Long id) {
        this.id = id;
    }

    public AdresseOffice(Long id, int versioning) {
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

    public Collection<Office> getOfficeCollection() {
        return officeCollection;
    }

    public void setOfficeCollection(Collection<Office> officeCollection) {
        this.officeCollection = officeCollection;
    }

    public TypeVoie getTypeVoieFk() {
        return typeVoieFk;
    }

    public void setTypeVoieFk(TypeVoie typeVoieFk) {
        this.typeVoieFk = typeVoieFk;
    }

    public Topad getTopadFk() {
        return topadFk;
    }

    public void setTopadFk(Topad topadFk) {
        this.topadFk = topadFk;
    }

    public Collection<Annexe> getAnnexeCollection() {
        return annexeCollection;
    }

    public void setAnnexeCollection(Collection<Annexe> annexeCollection) {
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
        if (!(object instanceof AdresseOffice)) {
            return false;
        }
        AdresseOffice other = (AdresseOffice) object;
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
				.append("\",\"typeVoieFk\":\"").append(typeVoieFk)
				.append("\",\"topadFk\":\"").append(topadFk)
				.append("\"}");
		return builder.toString();
	}

   
    
}
