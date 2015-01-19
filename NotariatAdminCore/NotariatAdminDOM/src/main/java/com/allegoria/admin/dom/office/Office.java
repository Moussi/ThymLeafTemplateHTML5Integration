/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.office;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "office")
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o")})
public class Office implements Serializable {
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
    @Column(name = "STATUT")
    private String statut;
    @Size(max = 255)
    @Column(name = "NUMERO_CRPCEN")
    private String numeroCrpcen;
    @Size(max = 255)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 255)
    @Column(name = "NUMERO_URSSAF")
    private String numeroUrssaf;
    @Size(max = 255)
    @Column(name = "CODE_APE")
    private String codeApe;
    @Size(max = 255)
    @Column(name = "NUMERO_SIREN")
    private String numeroSiren;
    @Size(max = 255)
    @Column(name = "NUMERO_TVA")
    private String numeroTva;
    @Size(max = 255)
    @Column(name = "CODE_CSN")
    private String codeCsn;
    @Size(max = 255)
    @Column(name = "NUMERO_AGREE")
    private String numeroAgree;
    @Column(name = "NUMERO_ARCHIVE_AUTO")
    private Boolean numeroArchiveAuto;
    @Size(max = 255)
    @Column(name = "DERNIER_NUMERO_ARCHIVE")
    private String dernierNumeroArchive;
    @Column(name = "ALERTE_REPONSE_COURRIER")
    private Integer alerteReponseCourrier;
    @Column(name = "REPERTOIRE_NUMERO_CONTINU")
    private Boolean repertoireNumeroContinu;
    @Column(name = "POID_MAX_MICEN")
    private BigInteger poidMaxMicen;
    @Size(max = 255)
    @Column(name = "VERSION_XSD_MICEN")
    private String versionXsdMicen;
    @Size(max = 255)
    @Column(name = "VERSION_META_SPECIFIQUES_MICEN")
    private String versionMetaSpecifiquesMicen;
    @Size(max = 255)
    @Column(name = "SERVEUR_MICEN")
    private String serveurMicen;
    @Column(name = "POID_MAX_MICEN_AVEC_MENTIONS")
    private BigInteger poidMaxMicenAvecMentions;
    @Column(name = "POID_MAX_MICEN_AVEC_MENTIONS_CRITIQUE")
    private BigInteger poidMaxMicenAvecMentionsCritique;
    @JoinColumn(name = "COORDONNEE_FK", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Coordonnee coordonneeFk;
    @JoinColumn(name = "ADRESSE_FK", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private AdresseOffice adresseFk;
    @OneToMany(mappedBy = "officeFk",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Annexe> annexeCollection;
    @OneToMany(mappedBy = "officeFk",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Rib> ribCollection;
    @OneToMany(mappedBy = "officeFk",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<DocumentFichier> documentFichierCollection;
    
    public Office() {
    }

    public Office(Long id) {
        this.id = id;
    }

    public Office(Long id, int versioning) {
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNumeroCrpcen() {
        return numeroCrpcen;
    }

    public void setNumeroCrpcen(String numeroCrpcen) {
        this.numeroCrpcen = numeroCrpcen;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroUrssaf() {
        return numeroUrssaf;
    }

    public void setNumeroUrssaf(String numeroUrssaf) {
        this.numeroUrssaf = numeroUrssaf;
    }

    public String getCodeApe() {
        return codeApe;
    }

    public void setCodeApe(String codeApe) {
        this.codeApe = codeApe;
    }

    public String getNumeroSiren() {
        return numeroSiren;
    }

    public void setNumeroSiren(String numeroSiren) {
        this.numeroSiren = numeroSiren;
    }

    public String getNumeroTva() {
        return numeroTva;
    }

    public void setNumeroTva(String numeroTva) {
        this.numeroTva = numeroTva;
    }

    public String getCodeCsn() {
        return codeCsn;
    }

    public void setCodeCsn(String codeCsn) {
        this.codeCsn = codeCsn;
    }

    public String getNumeroAgree() {
        return numeroAgree;
    }

    public void setNumeroAgree(String numeroAgree) {
        this.numeroAgree = numeroAgree;
    }

    public Boolean getNumeroArchiveAuto() {
        return numeroArchiveAuto;
    }

    public void setNumeroArchiveAuto(Boolean numeroArchiveAuto) {
        this.numeroArchiveAuto = numeroArchiveAuto;
    }

    public String getDernierNumeroArchive() {
        return dernierNumeroArchive;
    }

    public void setDernierNumeroArchive(String dernierNumeroArchive) {
        this.dernierNumeroArchive = dernierNumeroArchive;
    }

    public Integer getAlerteReponseCourrier() {
        return alerteReponseCourrier;
    }

    public void setAlerteReponseCourrier(Integer alerteReponseCourrier) {
        this.alerteReponseCourrier = alerteReponseCourrier;
    }

    public Boolean getRepertoireNumeroContinu() {
        return repertoireNumeroContinu;
    }

    public void setRepertoireNumeroContinu(Boolean repertoireNumeroContinu) {
        this.repertoireNumeroContinu = repertoireNumeroContinu;
    }

    public BigInteger getPoidMaxMicen() {
        return poidMaxMicen;
    }

    public void setPoidMaxMicen(BigInteger poidMaxMicen) {
        this.poidMaxMicen = poidMaxMicen;
    }

    public String getVersionXsdMicen() {
        return versionXsdMicen;
    }

    public void setVersionXsdMicen(String versionXsdMicen) {
        this.versionXsdMicen = versionXsdMicen;
    }

    public String getVersionMetaSpecifiquesMicen() {
        return versionMetaSpecifiquesMicen;
    }

    public void setVersionMetaSpecifiquesMicen(String versionMetaSpecifiquesMicen) {
        this.versionMetaSpecifiquesMicen = versionMetaSpecifiquesMicen;
    }

    public String getServeurMicen() {
        return serveurMicen;
    }

    public void setServeurMicen(String serveurMicen) {
        this.serveurMicen = serveurMicen;
    }

    public BigInteger getPoidMaxMicenAvecMentions() {
        return poidMaxMicenAvecMentions;
    }

    public void setPoidMaxMicenAvecMentions(BigInteger poidMaxMicenAvecMentions) {
        this.poidMaxMicenAvecMentions = poidMaxMicenAvecMentions;
    }

    public BigInteger getPoidMaxMicenAvecMentionsCritique() {
        return poidMaxMicenAvecMentionsCritique;
    }

    public void setPoidMaxMicenAvecMentionsCritique(BigInteger poidMaxMicenAvecMentionsCritique) {
        this.poidMaxMicenAvecMentionsCritique = poidMaxMicenAvecMentionsCritique;
    }

    public Coordonnee getCoordonneeFk() {
        return coordonneeFk;
    }

    public void setCoordonneeFk(Coordonnee coordonneeFk) {
        this.coordonneeFk = coordonneeFk;
    }

    public AdresseOffice getAdresseFk() {
        return adresseFk;
    }

    public void setAdresseFk(AdresseOffice adresseFk) {
        this.adresseFk = adresseFk;
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
    
    

    public Collection<Rib> getRibCollection() {
		return ribCollection;
	}

	public void setRibCollection(Collection<Rib> ribCollection) {
		this.ribCollection = ribCollection;
	}

	public Collection<DocumentFichier> getDocumentFichierCollection() {
		return documentFichierCollection;
	}

	public void setDocumentFichierCollection(
			Collection<DocumentFichier> documentFichierCollection) {
		this.documentFichierCollection = documentFichierCollection;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"").append(id).append("\",\"versioning\":\"")
				.append(versioning).append("\",\"statut\":\"").append(statut)
				.append("\",\"numeroCrpcen\":\"").append(numeroCrpcen)
				.append("\",\"nom\":\"").append(nom)
				.append("\",\"numeroUrssaf\":\"").append(numeroUrssaf)
				.append("\",\"codeApe\":\"").append(codeApe)
				.append("\",\"numeroSiren\":\"").append(numeroSiren)
				.append("\",\"numeroTva\":\"").append(numeroTva)
				.append("\",\"codeCsn\":\"").append(codeCsn)
				.append("\",\"numeroAgree\":\"").append(numeroAgree)
				.append("\",\"numeroArchiveAuto\":\"")
				.append(numeroArchiveAuto)
				.append("\",\"dernierNumeroArchive\":\"")
				.append(dernierNumeroArchive)
				.append("\",\"alerteReponseCourrier\":\"")
				.append(alerteReponseCourrier)
				.append("\",\"repertoireNumeroContinu\":\"")
				.append(repertoireNumeroContinu)
				.append("\",\"poidMaxMicen\":\"").append(poidMaxMicen)
				.append("\",\"versionXsdMicen\":\"").append(versionXsdMicen)
				.append("\",\"versionMetaSpecifiquesMicen\":\"")
				.append(versionMetaSpecifiquesMicen)
				.append("\",\"serveurMicen\":\"").append(serveurMicen)
				.append("\",\"poidMaxMicenAvecMentions\":\"")
				.append(poidMaxMicenAvecMentions)
				.append("\",\"poidMaxMicenAvecMentionsCritique\":\"")
				.append(poidMaxMicenAvecMentionsCritique)
				.append("\",\"coordonneeFk\":\"").append(coordonneeFk)
				.append("\",\"adresseFk\":\"").append(adresseFk)
				.append("\",\"annexeCollection\":\"").append(annexeCollection)
				.append("\",\"ribCollection\":\"").append(ribCollection)
				.append("\",\"documentFichierCollection\":\"")
				.append(documentFichierCollection).append("\"}");
		return builder.toString();
	}

    
    
}
