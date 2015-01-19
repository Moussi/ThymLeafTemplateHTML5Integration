/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typeacte;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.allegoria.admin.dom.typeacte.TypeComparant;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_acte_local")
@NamedQueries({
    @NamedQuery(name = "TypeActeLocal.findAll", query = "SELECT t FROM TypeActeLocal t")})
public class TypeActeLocal implements Serializable {
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
    @Size(max = 255)
    @Column(name = "FAMILLE")
    private String famille;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @Column(name = "REPERTOIRE_VARIANTE_ID")
    private BigInteger repertoireVarianteId;
    @Size(max = 255)
    @Column(name = "REPERTOIRE_VARIANTE_CODE")
    private String repertoireVarianteCode;
    @Column(name = "RECTIFICATIF_VARIANTE_ID")
    private BigInteger rectificatifVarianteId;
    @Size(max = 255)
    @Column(name = "RECTIFICATIF_VARIANTE_CODE")
    private String rectificatifVarianteCode;
    @Column(name = "REDACTION_LIBRE")
    private Boolean redactionLibre;
    @Column(name = "EFFET_RELATIF")
    private Boolean effetRelatif;
    @JoinColumn(name = "TYPE_EFFET_FK", referencedColumnName = "ID")
    @ManyToOne
    private TypeEffetRelatif typeEffetFk;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TYPES_ACTE_LOCAUX2TYPES_COMPARANT",  joinColumns = { 
			@JoinColumn(name = "TYPES_ACTE_LOCAUX_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_COMPARANT_FK", 
					nullable = false, updatable = false) })
    private Set<TypeComparant> typeComparants =new  HashSet<TypeComparant>();
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TYPES_ACTE_LOCAUX2TYPES_RELATION", joinColumns = { 
			@JoinColumn(name = "TYPES_ACTE_LOCAUX_FK", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "TYPES_RELATION_FK", 
					nullable = false, updatable = false) })
    private Set<TypeRelationComparution> typeRelationComparution= new  HashSet<TypeRelationComparution>();
    public TypeActeLocal() {
    }

    public TypeActeLocal(Long id) {
        this.id = id;
    }

    public TypeActeLocal(Long id, int versioning) {
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

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public BigInteger getRepertoireVarianteId() {
        return repertoireVarianteId;
    }

    public void setRepertoireVarianteId(BigInteger repertoireVarianteId) {
        this.repertoireVarianteId = repertoireVarianteId;
    }

    public String getRepertoireVarianteCode() {
        return repertoireVarianteCode;
    }

    public void setRepertoireVarianteCode(String repertoireVarianteCode) {
        this.repertoireVarianteCode = repertoireVarianteCode;
    }

    public BigInteger getRectificatifVarianteId() {
        return rectificatifVarianteId;
    }

    public void setRectificatifVarianteId(BigInteger rectificatifVarianteId) {
        this.rectificatifVarianteId = rectificatifVarianteId;
    }

    public String getRectificatifVarianteCode() {
        return rectificatifVarianteCode;
    }

    public void setRectificatifVarianteCode(String rectificatifVarianteCode) {
        this.rectificatifVarianteCode = rectificatifVarianteCode;
    }

    public Boolean getRedactionLibre() {
        return redactionLibre;
    }

    public void setRedactionLibre(Boolean redactionLibre) {
        this.redactionLibre = redactionLibre;
    }

    public Boolean getEffetRelatif() {
        return effetRelatif;
    }

    public void setEffetRelatif(Boolean effetRelatif) {
        this.effetRelatif = effetRelatif;
    }

    public TypeEffetRelatif getTypeEffetFk() {
        return typeEffetFk;
    }

    public void setTypeEffetFk(TypeEffetRelatif typeEffetFk) {
        this.typeEffetFk = typeEffetFk;
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
        if (!(object instanceof TypeActeLocal)) {
            return false;
        }
        TypeActeLocal other = (TypeActeLocal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.typeacte.TypeActeLocal[ id=" + id + " ]";
    }
    
}
