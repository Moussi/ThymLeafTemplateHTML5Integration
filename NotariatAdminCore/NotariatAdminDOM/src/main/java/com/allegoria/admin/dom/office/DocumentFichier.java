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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "document_fichier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentFichier.findAll", query = "SELECT d FROM DocumentFichier d"),
    @NamedQuery(name = "DocumentFichier.findById", query = "SELECT d FROM DocumentFichier d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentFichier.findByVersioning", query = "SELECT d FROM DocumentFichier d WHERE d.versioning = :versioning"),
    @NamedQuery(name = "DocumentFichier.findByCreeLe", query = "SELECT d FROM DocumentFichier d WHERE d.creeLe = :creeLe"),
    @NamedQuery(name = "DocumentFichier.findByLibelle", query = "SELECT d FROM DocumentFichier d WHERE d.libelle = :libelle"),
    @NamedQuery(name = "DocumentFichier.findByEmplacement", query = "SELECT d FROM DocumentFichier d WHERE d.emplacement = :emplacement"),
    @NamedQuery(name = "DocumentFichier.findByCode", query = "SELECT d FROM DocumentFichier d WHERE d.code = :code"),
    @NamedQuery(name = "DocumentFichier.findByCodeBarre", query = "SELECT d FROM DocumentFichier d WHERE d.codeBarre = :codeBarre"),
    @NamedQuery(name = "DocumentFichier.findByReprise", query = "SELECT d FROM DocumentFichier d WHERE d.reprise = :reprise"),
    @NamedQuery(name = "DocumentFichier.findByCodeReprise", query = "SELECT d FROM DocumentFichier d WHERE d.codeReprise = :codeReprise"),
    @NamedQuery(name = "DocumentFichier.findByArchive", query = "SELECT d FROM DocumentFichier d WHERE d.archive = :archive"),
    @NamedQuery(name = "DocumentFichier.findByProtege", query = "SELECT d FROM DocumentFichier d WHERE d.protege = :protege"),
    @NamedQuery(name = "DocumentFichier.findBySupprime", query = "SELECT d FROM DocumentFichier d WHERE d.supprime = :supprime"),
    @NamedQuery(name = "DocumentFichier.findByPhoto", query = "SELECT d FROM DocumentFichier d WHERE d.photo = :photo"),
    @NamedQuery(name = "DocumentFichier.findByAnnexeMicen", query = "SELECT d FROM DocumentFichier d WHERE d.annexeMicen = :annexeMicen"),
    @NamedQuery(name = "DocumentFichier.findByAffectationDossier", query = "SELECT d FROM DocumentFichier d WHERE d.affectationDossier = :affectationDossier"),
    @NamedQuery(name = "DocumentFichier.findByNumeroAnnexe", query = "SELECT d FROM DocumentFichier d WHERE d.numeroAnnexe = :numeroAnnexe"),
    @NamedQuery(name = "DocumentFichier.findByLibelleAnnexe", query = "SELECT d FROM DocumentFichier d WHERE d.libelleAnnexe = :libelleAnnexe"),
    @NamedQuery(name = "DocumentFichier.findByEmplacementPDFA", query = "SELECT d FROM DocumentFichier d WHERE d.emplacementPDFA = :emplacementPDFA"),
    @NamedQuery(name = "DocumentFichier.findByDocumentEtude", query = "SELECT d FROM DocumentFichier d WHERE d.documentEtude = :documentEtude")})
public class DocumentFichier implements Serializable {
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
    @Column(name = "CREE_LE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creeLe;
    @Size(max = 255)
    @Column(name = "LIBELLE")
    private String libelle;
    @Size(max = 255)
    @Column(name = "EMPLACEMENT")
    private String emplacement;
    @Size(max = 255)
    @Column(name = "CODE")
    private String code;
    @Size(max = 255)
    @Column(name = "CODE_BARRE")
    private String codeBarre;
    @Column(name = "REPRISE")
    private Boolean reprise;
    @Size(max = 255)
    @Column(name = "CODE_REPRISE")
    private String codeReprise;
    @Column(name = "ARCHIVE")
    private Boolean archive;
    @Column(name = "PROTEGE")
    private Boolean protege;
    @Column(name = "SUPPRIME")
    private Boolean supprime;
    @Column(name = "PHOTO")
    private Boolean photo;
    @Column(name = "ANNEXE_MICEN")
    private Boolean annexeMicen;
    @Size(max = 255)
    @Column(name = "AFFECTATION_DOSSIER")
    private String affectationDossier;
    @Column(name = "NUMERO_ANNEXE")
    private Integer numeroAnnexe;
    @Size(max = 255)
    @Column(name = "LIBELLE_ANNEXE")
    private String libelleAnnexe;
    @Size(max = 255)
    @Column(name = "EMPLACEMENT_P_D_F_A")
    private String emplacementPDFA;
    @Size(max = 255)
    @Column(name = "DOCUMENT_ETUDE")
    private String documentEtude;
    @JoinColumn(name = "UTILISATEUR_FK", referencedColumnName = "ID")
    @ManyToOne
    private Utilisateur utilisateurFk;
    @JoinColumn(name = "OFFICE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Office officeFk;
    @OneToMany(mappedBy = "documentFichierFk")
    private Collection<DocumentFichier> documentFichierCollection;
    @JoinColumn(name = "DOCUMENT_FICHIER_FK", referencedColumnName = "ID")
    @ManyToOne
    private DocumentFichier documentFichierFk;

    public DocumentFichier() {
    }

    public DocumentFichier(Long id) {
        this.id = id;
    }

    public DocumentFichier(Long id, int versioning) {
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

    public Date getCreeLe() {
        return creeLe;
    }

    public void setCreeLe(Date creeLe) {
        this.creeLe = creeLe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Boolean getReprise() {
        return reprise;
    }

    public void setReprise(Boolean reprise) {
        this.reprise = reprise;
    }

    public String getCodeReprise() {
        return codeReprise;
    }

    public void setCodeReprise(String codeReprise) {
        this.codeReprise = codeReprise;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Boolean getProtege() {
        return protege;
    }

    public void setProtege(Boolean protege) {
        this.protege = protege;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public Boolean getPhoto() {
        return photo;
    }

    public void setPhoto(Boolean photo) {
        this.photo = photo;
    }

    public Boolean getAnnexeMicen() {
        return annexeMicen;
    }

    public void setAnnexeMicen(Boolean annexeMicen) {
        this.annexeMicen = annexeMicen;
    }

    public String getAffectationDossier() {
        return affectationDossier;
    }

    public void setAffectationDossier(String affectationDossier) {
        this.affectationDossier = affectationDossier;
    }

    public Integer getNumeroAnnexe() {
        return numeroAnnexe;
    }

    public void setNumeroAnnexe(Integer numeroAnnexe) {
        this.numeroAnnexe = numeroAnnexe;
    }

    public String getLibelleAnnexe() {
        return libelleAnnexe;
    }

    public void setLibelleAnnexe(String libelleAnnexe) {
        this.libelleAnnexe = libelleAnnexe;
    }

    public String getEmplacementPDFA() {
        return emplacementPDFA;
    }

    public void setEmplacementPDFA(String emplacementPDFA) {
        this.emplacementPDFA = emplacementPDFA;
    }

    public String getDocumentEtude() {
        return documentEtude;
    }

    public void setDocumentEtude(String documentEtude) {
        this.documentEtude = documentEtude;
    }

    public Utilisateur getUtilisateurFk() {
        return utilisateurFk;
    }

    public void setUtilisateurFk(Utilisateur utilisateurFk) {
        this.utilisateurFk = utilisateurFk;
    }

    public Office getOfficeFk() {
        return officeFk;
    }

    public void setOfficeFk(Office officeFk) {
        this.officeFk = officeFk;
    }

    @XmlTransient
    public Collection<DocumentFichier> getDocumentFichierCollection() {
        return documentFichierCollection;
    }

    public void setDocumentFichierCollection(Collection<DocumentFichier> documentFichierCollection) {
        this.documentFichierCollection = documentFichierCollection;
    }

    public DocumentFichier getDocumentFichierFk() {
        return documentFichierFk;
    }

    public void setDocumentFichierFk(DocumentFichier documentFichierFk) {
        this.documentFichierFk = documentFichierFk;
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
        if (!(object instanceof DocumentFichier)) {
            return false;
        }
        DocumentFichier other = (DocumentFichier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	

   
    
}
