/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.bl.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import com.allegoria.admin.dom.office.AdresseOffice;
import com.allegoria.admin.dom.office.Annexe;
import com.allegoria.admin.dom.office.Coordonnee;
import com.allegoria.admin.dom.office.DocumentFichier;
import com.allegoria.admin.dom.office.Rib;

/**
 *
 * @author Allégoria
 */

public class OfficeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long id;
    
    
    private int versioning;
  
    private String statut;
    
    private String numeroCrpcen;
    private String nom;
    private String numeroUrssaf;
    private String codeApe;
    private String numeroSiren;
    private String numeroTva;
    private String codeCsn;
    private String numeroAgree;
    private Boolean numeroArchiveAuto;
    private String dernierNumeroArchive;
    private Integer alerteReponseCourrier;
    private Boolean repertoireNumeroContinu;
    private BigInteger poidMaxMicen;
    private String versionXsdMicen;
    private String versionMetaSpecifiquesMicen;
    private String serveurMicen;
    private BigInteger poidMaxMicenAvecMentions;
    private BigInteger poidMaxMicenAvecMentionsCritique;
    private Long coordonneeFk;
    private Long adresseFk;
    private List<Long> ribCollection;
    private List<Long> documentFichierCollection;
    private List<Long> annexeCollection;
	
    
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
	
	public Long getAdresseFk() {
		return adresseFk;
	}
	public void setAdresseFk(Long adresseFk) {
		this.adresseFk = adresseFk;
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
	public void setPoidMaxMicenAvecMentionsCritique(
			BigInteger poidMaxMicenAvecMentionsCritique) {
		this.poidMaxMicenAvecMentionsCritique = poidMaxMicenAvecMentionsCritique;
	}
	
	
	public Long getCoordonneeFk() {
		return coordonneeFk;
	}
	public void setCoordonneeFk(Long coordonneeFk) {
		this.coordonneeFk = coordonneeFk;
	}
	public List<Long> getRibCollection() {
		return ribCollection;
	}
	public void setRibCollection(List<Long> ribCollection) {
		this.ribCollection = ribCollection;
	}
	public List<Long> getDocumentFichierCollection() {
		return documentFichierCollection;
	}
	public void setDocumentFichierCollection(List<Long> documentFichierCollection) {
		this.documentFichierCollection = documentFichierCollection;
	}
	public List<Long> getAnnexeCollection() {
		return annexeCollection;
	}
	public void setAnnexeCollection(List<Long> annexeCollection) {
		this.annexeCollection = annexeCollection;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OfficeDTO [id=" + id + ", versioning=" + versioning
				+ ", statut=" + statut + ", numeroCrpcen=" + numeroCrpcen
				+ ", nom=" + nom + ", numeroUrssaf=" + numeroUrssaf
				+ ", codeApe=" + codeApe + ", numeroSiren=" + numeroSiren
				+ ", numeroTva=" + numeroTva + ", codeCsn=" + codeCsn
				+ ", numeroAgree=" + numeroAgree + ", numeroArchiveAuto="
				+ numeroArchiveAuto + ", dernierNumeroArchive="
				+ dernierNumeroArchive + ", alerteReponseCourrier="
				+ alerteReponseCourrier + ", repertoireNumeroContinu="
				+ repertoireNumeroContinu + ", poidMaxMicen=" + poidMaxMicen
				+ ", versionXsdMicen=" + versionXsdMicen
				+ ", versionMetaSpecifiquesMicen="
				+ versionMetaSpecifiquesMicen + ", serveurMicen="
				+ serveurMicen + ", poidMaxMicenAvecMentions="
				+ poidMaxMicenAvecMentions
				+ ", poidMaxMicenAvecMentionsCritique="
				+ poidMaxMicenAvecMentionsCritique + ", coordonneeFk="
				+ coordonneeFk + ", adresseFk=" + adresseFk
				+ ", ribCollection=" + ribCollection
				+ ", documentFichierCollection=" + documentFichierCollection
				+ ", annexeCollection=" + annexeCollection + "]";
	}

    
    
}
