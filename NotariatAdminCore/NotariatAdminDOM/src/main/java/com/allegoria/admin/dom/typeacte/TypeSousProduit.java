/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typeacte;

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

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_sous_produit")
@NamedQueries({
    @NamedQuery(name = "TypeSousProduit.findAll", query = "SELECT t FROM TypeSousProduit t")})
public class TypeSousProduit implements Serializable {
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
    @Column(name = "NOM")
    private String nom;
    @Column(name = "VARIANTE_ID")
    private BigInteger varianteId;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @Column(name = "POUR_DEPOT")
    private Boolean pourDepot;
    @Column(name = "AUTO_GENERE")
    private Boolean autoGenere;
    @Size(max = 255)
    @Column(name = "FAMILLE")
    private String famille;
    @Size(max = 255)
    @Column(name = "SIGNATURE_PLANETE")
    private String signaturePlanete;
    @Size(max = 255)
    @Column(name = "ENTETE")
    private String entete;
    @Size(max = 255)
    @Column(name = "OCCURRENCE")
    private String occurrence;
    @Size(max = 255)
    @Column(name = "EMPLACEMENT")
    private String emplacement;
    @Size(max = 255)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 255)
    @Column(name = "VARIANTE_CODE")
    private String varianteCode;
    @Column(name = "COPIE_ACTE")
    private Boolean copieActe;
    @Column(name = "AVEC_MARGE")
    private Boolean avecMarge;
    @Column(name = "AVEC_STYLE")
    private Boolean avecStyle;
    @JoinColumn(name = "TYPE_ACTE_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeActe typeActeFk;

    public TypeSousProduit() {
    }

    public TypeSousProduit(Long id) {
        this.id = id;
    }

    public TypeSousProduit(Long id, int versioning) {
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

	public TypeActe getTypeActeFk() {
        return typeActeFk;
    }

    public void setTypeActeFk(TypeActe typeActeFk) {
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
        if (!(object instanceof TypeSousProduit)) {
            return false;
        }
        TypeSousProduit other = (TypeSousProduit) object;
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
