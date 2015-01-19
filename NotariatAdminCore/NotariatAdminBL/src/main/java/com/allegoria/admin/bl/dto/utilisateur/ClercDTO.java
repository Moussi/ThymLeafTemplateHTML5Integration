package com.allegoria.admin.bl.dto.utilisateur;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.office.Utilisateur;

public class ClercDTO {

    private String code;
    private String login;
    private String titre;
    private String titreAbrege;
    private String nom;
    private String prenom;
    private String service;
    private String email;
    private String telephonePortable;
    private String ligneDirecte;
    private String fax;
    private Boolean acheve;
    private Boolean infoMel;
    private Boolean officiel;
    private String identifiantElectronique;
    private String smtpServerUrl;
    private String popServerUrl;
    private String mailServersLogin;
    private String mailServersPassword;
    private String mailReplyTo;
    private Boolean accesExterieurAutorise;
    private String motPasseGenere;
    private Date dateGenerationMotPasse;
    private String numeroIMEI;
    private String signatureTexte;
    private Boolean accesSmartAutorise;
    private String signature;
    private String loginComptaVisu;
    private String mdpComptaVisu;
    private String loginComptaPretaxe;
    private String mdpComptaPretaxe;
    private String idTransfert;
    private Date dateHabilitation;
    private Boolean habilite;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTitreAbrege() {
		return titreAbrege;
	}
	public void setTitreAbrege(String titreAbrege) {
		this.titreAbrege = titreAbrege;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephonePortable() {
		return telephonePortable;
	}
	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}
	public String getLigneDirecte() {
		return ligneDirecte;
	}
	public void setLigneDirecte(String ligneDirecte) {
		this.ligneDirecte = ligneDirecte;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Boolean getAcheve() {
		return acheve;
	}
	public void setAcheve(Boolean acheve) {
		this.acheve = acheve;
	}
	public Boolean getInfoMel() {
		return infoMel;
	}
	public void setInfoMel(Boolean infoMel) {
		this.infoMel = infoMel;
	}
	public Boolean getOfficiel() {
		return officiel;
	}
	public void setOfficiel(Boolean officiel) {
		this.officiel = officiel;
	}
	public String getIdentifiantElectronique() {
		return identifiantElectronique;
	}
	public void setIdentifiantElectronique(String identifiantElectronique) {
		this.identifiantElectronique = identifiantElectronique;
	}
	public String getSmtpServerUrl() {
		return smtpServerUrl;
	}
	public void setSmtpServerUrl(String smtpServerUrl) {
		this.smtpServerUrl = smtpServerUrl;
	}
	public String getPopServerUrl() {
		return popServerUrl;
	}
	public void setPopServerUrl(String popServerUrl) {
		this.popServerUrl = popServerUrl;
	}
	public String getMailServersLogin() {
		return mailServersLogin;
	}
	
	public Boolean getHabilite() {
		return habilite;
	}
	public void setHabilite(Boolean habilite) {
		this.habilite = habilite;
	}
	public void setMailServersLogin(String mailServersLogin) {
		this.mailServersLogin = mailServersLogin;
	}
	public String getMailServersPassword() {
		return mailServersPassword;
	}
	public void setMailServersPassword(String mailServersPassword) {
		this.mailServersPassword = mailServersPassword;
	}
	public String getMailReplyTo() {
		return mailReplyTo;
	}
	public void setMailReplyTo(String mailReplyTo) {
		this.mailReplyTo = mailReplyTo;
	}
	public Boolean getAccesExterieurAutorise() {
		return accesExterieurAutorise;
	}
	public void setAccesExterieurAutorise(Boolean accesExterieurAutorise) {
		this.accesExterieurAutorise = accesExterieurAutorise;
	}
	public String getMotPasseGenere() {
		return motPasseGenere;
	}
	public void setMotPasseGenere(String motPasseGenere) {
		this.motPasseGenere = motPasseGenere;
	}
	public Date getDateGenerationMotPasse() {
		return dateGenerationMotPasse;
	}
	public void setDateGenerationMotPasse(Date dateGenerationMotPasse) {
		this.dateGenerationMotPasse = dateGenerationMotPasse;
	}
	public String getNumeroIMEI() {
		return numeroIMEI;
	}
	public void setNumeroIMEI(String numeroIMEI) {
		this.numeroIMEI = numeroIMEI;
	}
	public String getSignatureTexte() {
		return signatureTexte;
	}
	public void setSignatureTexte(String signatureTexte) {
		this.signatureTexte = signatureTexte;
	}
	public Boolean getAccesSmartAutorise() {
		return accesSmartAutorise;
	}
	public void setAccesSmartAutorise(Boolean accesSmartAutorise) {
		this.accesSmartAutorise = accesSmartAutorise;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getLoginComptaVisu() {
		return loginComptaVisu;
	}
	public void setLoginComptaVisu(String loginComptaVisu) {
		this.loginComptaVisu = loginComptaVisu;
	}
	public String getMdpComptaVisu() {
		return mdpComptaVisu;
	}
	public void setMdpComptaVisu(String mdpComptaVisu) {
		this.mdpComptaVisu = mdpComptaVisu;
	}
	public String getLoginComptaPretaxe() {
		return loginComptaPretaxe;
	}
	public void setLoginComptaPretaxe(String loginComptaPretaxe) {
		this.loginComptaPretaxe = loginComptaPretaxe;
	}
	public String getMdpComptaPretaxe() {
		return mdpComptaPretaxe;
	}
	public void setMdpComptaPretaxe(String mdpComptaPretaxe) {
		this.mdpComptaPretaxe = mdpComptaPretaxe;
	}
	public String getIdTransfert() {
		return idTransfert;
	}
	public void setIdTransfert(String idTransfert) {
		this.idTransfert = idTransfert;
	}
	
	
	
	
	public Date getDateHabilitation() {
		return dateHabilitation;
	}
	public void setDateHabilitation(Date dateHabilitation) {
		this.dateHabilitation = dateHabilitation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"code\":\"").append(code).append("\",\"login\":\"")
				.append(login).append("\",\"titre\":\"").append(titre)
				.append("\",\"titreAbrege\":\"").append(titreAbrege)
				.append("\",\"nom\":\"").append(nom).append("\",\"prenom\":\"")
				.append(prenom).append("\",\"service\":\"").append(service)
				.append("\",\"email\":\"").append(email)
				.append("\",\"telephonePortable\":\"")
				.append(telephonePortable).append("\",\"ligneDirecte\":\"")
				.append(ligneDirecte).append("\",\"fax\":\"").append(fax)
				.append("\",\"acheve\":\"").append(acheve)
				.append("\",\"infoMel\":\"").append(infoMel)
				.append("\",\"officiel\":\"").append(officiel)
				.append("\",\"identifiantElectronique\":\"")
				.append(identifiantElectronique)
				.append("\",\"smtpServerUrl\":\"").append(smtpServerUrl)
				.append("\",\"popServerUrl\":\"").append(popServerUrl)
				.append("\",\"mailServersLogin\":\"").append(mailServersLogin)
				.append("\",\"mailServersPassword\":\"")
				.append(mailServersPassword).append("\",\"mailReplyTo\":\"")
				.append(mailReplyTo).append("\",\"accesExterieurAutorise\":\"")
				.append(accesExterieurAutorise)
				.append("\",\"motPasseGenere\":\"").append(motPasseGenere)
				.append("\",\"dateGenerationMotPasse\":\"")
				.append(dateGenerationMotPasse).append("\",\"numeroIMEI\":\"")
				.append(numeroIMEI).append("\",\"signatureTexte\":\"")
				.append(signatureTexte).append("\",\"accesSmartAutorise\":\"")
				.append(accesSmartAutorise).append("\",\"signature\":\"")
				.append(signature).append("\",\"loginComptaVisu\":\"")
				.append(loginComptaVisu).append("\",\"mdpComptaVisu\":\"")
				.append(mdpComptaVisu).append("\",\"loginComptaPretaxe\":\"")
				.append(loginComptaPretaxe)
				.append("\",\"mdpComptaPretaxe\":\"").append(mdpComptaPretaxe)
				.append("\",\"idTransfert\":\"").append(idTransfert)
				.append("\",\"dateHabilitation\":\"").append(dateHabilitation)
				.append("\"}");
		return builder.toString();
	}
	
	
    	
    
}
