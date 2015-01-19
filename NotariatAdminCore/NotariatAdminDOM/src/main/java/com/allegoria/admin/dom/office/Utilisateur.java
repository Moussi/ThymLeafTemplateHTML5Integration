/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.office;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * 
 * @author user
 */
@Entity
@Table(name = "utilisateur")
@NamedQueries({ @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u") })
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "generator", strategy = "foreign",
			parameters = @Parameter(name = "property", value = "notaire"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "VERSIONING")
	private int versioning;
	@Size(max = 255)
	@Column(name = "CODE")
	private String code;
	@Size(max = 255)
	@Column(name = "LOGIN")
	private String login;
	@Size(max = 255)
	@Column(name = "TITRE")
	private String titre;
	@Size(max = 255)
	@Column(name = "TITRE_ABREGE")
	private String titreAbrege;
	@Size(max = 255)
	@Column(name = "NOM")
	private String nom;
	@Size(max = 255)
	@Column(name = "PRENOM")
	private String prenom;
	@Size(max = 255)
	@Column(name = "SERVICE")
	private String service;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider
	// using this annotation to enforce field validation
	@Size(max = 255)
	@Column(name = "EMAIL")
	private String email;
	@Size(max = 255)
	@Column(name = "TELEPHONE_PORTABLE")
	private String telephonePortable;
	@Size(max = 255)
	@Column(name = "LIGNE_DIRECTE")
	private String ligneDirecte;
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the
	// field contains phone or fax number consider using this annotation to
	// enforce field validation
	@Size(max = 255)
	@Column(name = "FAX")
	private String fax;
	@Column(name = "ACHEVE")
	private Boolean acheve;
	@Column(name = "INFO_MEL")
	private Boolean infoMel;
	@Column(name = "OFFICIEL")
	private Boolean officiel;
	@Size(max = 255)
	@Column(name = "IDENTIFIANT_ELECTRONIQUE")
	private String identifiantElectronique;
	@Size(max = 255)
	@Column(name = "SMTP_SERVER_URL")
	private String smtpServerUrl;
	@Size(max = 255)
	@Column(name = "POP_SERVER_URL")
	private String popServerUrl;
	@Size(max = 255)
	@Column(name = "MAIL_SERVERS_LOGIN")
	private String mailServersLogin;
	@Size(max = 255)
	@Column(name = "MAIL_SERVERS_PASSWORD")
	private String mailServersPassword;
	@Size(max = 255)
	@Column(name = "MAIL_REPLY_TO")
	private String mailReplyTo;
	@Column(name = "ACCES_EXTERIEUR_AUTORISE")
	private Boolean accesExterieurAutorise;
	@Size(max = 10)
	@Column(name = "MOT_PASSE_GENERE")
	private String motPasseGenere;
	@Column(name = "DATE_GENERATION_MOT_PASSE")
	@Temporal(TemporalType.DATE)
	private Date dateGenerationMotPasse;
	@Size(max = 255)
	@Column(name = "NUMERO_I_M_E_I")
	private String numeroIMEI;
	@Lob
	@Size(max = 65535)
	@Column(name = "SIGNATURE_TEXTE")
	private String signatureTexte;
	@Column(name = "ACCES_SMART_AUTORISE")
	private Boolean accesSmartAutorise;
	@Size(max = 255)
	@Column(name = "SIGNATURE")
	private String signature;
	@Size(max = 255)
	@Column(name = "LOGIN_COMPTA_VISU")
	private String loginComptaVisu;
	@Size(max = 255)
	@Column(name = "MDP_COMPTA_VISU")
	private String mdpComptaVisu;
	@Size(max = 255)
	@Column(name = "LOGIN_COMPTA_PRETAXE")
	private String loginComptaPretaxe;
	@Size(max = 255)
	@Column(name = "MDP_COMPTA_PRETAXE")
	private String mdpComptaPretaxe;
	@Size(max = 255)
	@Column(name = "ID_TRANSFERT")
	private String idTransfert;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="utilisateur")
	@PrimaryKeyJoinColumn
	private Notaire notaire;
	@JoinColumn(name = "ANNEXE_FK", referencedColumnName = "ID")
	@ManyToOne
	private Annexe annexeFk;

	public Utilisateur() {
	}

	public Utilisateur(Long id) {
		this.id = id;
	}

	public Utilisateur(Long id, int versioning) {
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

	public Notaire getNotaire() {
		return notaire;
	}

	public void setNotaire(Notaire notaire) {
		this.notaire = notaire;
	}

	public Annexe getAnnexeFk() {
		return annexeFk;
	}

	public void setAnnexeFk(Annexe annexeFk) {
		this.annexeFk = annexeFk;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Utilisateur)) {
			return false;
		}
		Utilisateur other = (Utilisateur) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.allegoria.admin.dom.typelocalfondpage.Utilisateur[ id="
				+ id + " ]";
	}

}
