/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typefamillecourrier;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.IndexColumn;

import com.allegoria.admin.dom.dossier.TypeDossier;
import com.allegoria.admin.dom.typeacte.TypeRelationComparution;
import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_courrier")
@NamedQueries({
    @NamedQuery(name = "TypeCourrier.findAll", query = "SELECT t FROM TypeCourrier t")})
public class TypeCourrier implements Serializable {
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
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "GENRE_ACTE_ID")
    private BigInteger genreActeId;
    @Size(max = 255)
    @Column(name = "GENRE_ACTE_CODE")
    private String genreActeCode;
    @Column(name = "INITIAL")
    private Boolean initial;
    @Column(name = "OBLIGATOIRE")
    private Boolean obligatoire;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @Column(name = "REPONSE_OBLIGATOIRE")
    private Boolean reponseObligatoire;
    @Column(name = "ENTETE")
    private Boolean entete;
    @Column(name = "CORPUS_PERMANENT")
    private Boolean corpusPermanent;
    @Size(max = 255)
    @Column(name = "EMPLACEMENT_GRAPHE")
    private String emplacementGraphe;
    @Lob
    @Size(max = 65535)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @Size(max = 255)
    @Column(name = "DOCUMENT_ETUDE")
    private String documentEtude;
    @JoinColumn(name = "TYPE_DOSSIER_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeDossier typeDossierFk;
    @JoinColumn(name = "FAMILLE_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeFamilleCourrier familleFk;
    @JoinColumn(name = "CRITERE_AUTO_GENERATION_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeCritereAutoGeneration critereAutoGenerationFk;
    
    public TypeCourrier() {
    }

    public TypeCourrier(Long id) {
        this.id = id;
    }

    public TypeCourrier(Long id, int versioning) {
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

    public BigInteger getGenreActeId() {
        return genreActeId;
    }

    public void setGenreActeId(BigInteger genreActeId) {
        this.genreActeId = genreActeId;
    }

    public String getGenreActeCode() {
        return genreActeCode;
    }

    public void setGenreActeCode(String genreActeCode) {
        this.genreActeCode = genreActeCode;
    }

    public Boolean getInitial() {
        return initial;
    }

    public void setInitial(Boolean initial) {
        this.initial = initial;
    }

    public Boolean getObligatoire() {
        return obligatoire;
    }

    public void setObligatoire(Boolean obligatoire) {
        this.obligatoire = obligatoire;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public Boolean getReponseObligatoire() {
        return reponseObligatoire;
    }

    public void setReponseObligatoire(Boolean reponseObligatoire) {
        this.reponseObligatoire = reponseObligatoire;
    }

    public Boolean getEntete() {
        return entete;
    }

    public void setEntete(Boolean entete) {
        this.entete = entete;
    }

   

    public Boolean getCorpusPermanent() {
		return corpusPermanent;
	}

	public void setCorpusPermanent(Boolean corpusPermanent) {
		this.corpusPermanent = corpusPermanent;
	}

	public String getEmplacementGraphe() {
        return emplacementGraphe;
    }

    public void setEmplacementGraphe(String emplacementGraphe) {
        this.emplacementGraphe = emplacementGraphe;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDocumentEtude() {
        return documentEtude;
    }

    public void setDocumentEtude(String documentEtude) {
        this.documentEtude = documentEtude;
    }

    public TypeDossier getTypeDossierFk() {
        return typeDossierFk;
    }

    public void setTypeDossierFk(TypeDossier typeDossierFk) {
        this.typeDossierFk = typeDossierFk;
    }

    public TypeFamilleCourrier getFamilleFk() {
        return familleFk;
    }

    public void setFamilleFk(TypeFamilleCourrier familleFk) {
        this.familleFk = familleFk;
    }

    public TypeCritereAutoGeneration getCritereAutoGenerationFk() {
        return critereAutoGenerationFk;
    }

    public void setCritereAutoGenerationFk(TypeCritereAutoGeneration critereAutoGenerationFk) {
        this.critereAutoGenerationFk = critereAutoGenerationFk;
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
        if (!(object instanceof TypeCourrier)) {
            return false;
        }
        TypeCourrier other = (TypeCourrier) object;
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
