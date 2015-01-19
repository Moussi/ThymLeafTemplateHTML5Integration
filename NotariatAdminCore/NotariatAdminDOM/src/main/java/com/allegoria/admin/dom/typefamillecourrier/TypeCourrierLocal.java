/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typefamillecourrier;

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

import com.allegoria.admin.dom.dossier.TypeDossier;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_courrier_local")
@NamedQueries({
    @NamedQuery(name = "TypeCourrierLocal.findAll", query = "SELECT t FROM TypeCourrierLocal t")})
public class TypeCourrierLocal implements Serializable {
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
    @JoinColumn(name = "TYPE_DOSSIER_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeDossier typeDossierFk;
    @JoinColumn(name = "FAMILLE_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeFamilleCourrierLocal familleFk;

    public TypeCourrierLocal() {
    }

    public TypeCourrierLocal(Long id) {
        this.id = id;
    }

    public TypeCourrierLocal(Long id, int versioning) {
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

    public TypeDossier getTypeDossierFk() {
        return typeDossierFk;
    }

    public void setTypeDossierFk(TypeDossier typeDossierFk) {
        this.typeDossierFk = typeDossierFk;
    }

    public TypeFamilleCourrierLocal getFamilleFk() {
        return familleFk;
    }

    public void setFamilleFk(TypeFamilleCourrierLocal familleFk) {
        this.familleFk = familleFk;
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
        if (!(object instanceof TypeCourrierLocal)) {
            return false;
        }
        TypeCourrierLocal other = (TypeCourrierLocal) object;
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
