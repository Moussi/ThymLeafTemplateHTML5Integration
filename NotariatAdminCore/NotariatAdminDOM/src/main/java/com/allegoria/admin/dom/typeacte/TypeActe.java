/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.typeacte;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_acte")
@NamedQueries({ @NamedQuery(name = "TypeActe.findAll", query = "SELECT t FROM TypeActe t") })
public class TypeActe implements Serializable {
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
	@Column(name = "TELEACTABLE")
	private Boolean teleactable;
	@Basic(optional = false)
	@NotNull
	@Column(name = "HYPOTHEQUE")
	private Boolean hypotheque;
	@Column(name = "SUR_ETAT")
	private Boolean surEtat;
	@Column(name = "ENREGISTREMENT")
	private Boolean enregistrement;
	@Column(name = "GREFFE")
	private Boolean greffe;
	@Column(name = "LIVRE_FONCIER")
	private Boolean livreFoncier;
	@Size(max = 255)
	@Column(name = "STATISTIQUE")
	private String statistique;
	@Size(max = 255)
	@Column(name = "POINT_DIFFICULTE")
	private String pointDifficulte;
	@Size(max = 255)
	@Column(name = "NATURE_MUTATION")
	private String natureMutation;
	@Column(name = "MODELE_UN_OBLIGATOIRE")
	private Boolean modeleUnObligatoire;
	@OneToMany(mappedBy = "typeActeFk", fetch = FetchType.EAGER)
	private Collection<TypeSousProduit> typeSousProduitCollection;
	@JoinColumn(name = "TYPE_EFFET_FK", referencedColumnName = "ID")
	@ManyToOne
	private TypeEffetRelatif typeEffetFk;
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "TYPES_ACTE2TYPES_COMPARANT", joinColumns = { @JoinColumn(name = "TYPES_ACTE_FK", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "TYPES_COMPARANT_FK", nullable = false, updatable = false) })
	private Set<TypeComparant> typeComparants = new HashSet<TypeComparant>();
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "TYPES_ACTE2TYPES_RELATION", joinColumns = { @JoinColumn(name = "TYPES_ACTE_FK", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "TYPES_RELATION_FK", nullable = false, updatable = false) })
	private Set<TypeRelationComparution> typeRelationComparution = new HashSet<TypeRelationComparution>();

	public TypeActe() {
	}

	public TypeActe(Long id) {
		this.id = id;
	}

	public TypeActe(Long id, int versioning, boolean hypotheque) {
		this.id = id;
		this.versioning = versioning;
		this.hypotheque = hypotheque;
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

	public Boolean getTeleactable() {
		return teleactable;
	}

	public void setTeleactable(Boolean teleactable) {
		this.teleactable = teleactable;
	}

	public Boolean getHypotheque() {
		return hypotheque;
	}

	public Boolean getGreffe() {
		return greffe;
	}

	public void setGreffe(Boolean greffe) {
		this.greffe = greffe;
	}

	public Boolean getLivreFoncier() {
		return livreFoncier;
	}

	public void setLivreFoncier(Boolean livreFoncier) {
		this.livreFoncier = livreFoncier;
	}

	public String getStatistique() {
		return statistique;
	}

	public void setStatistique(String statistique) {
		this.statistique = statistique;
	}

	public String getPointDifficulte() {
		return pointDifficulte;
	}

	public void setPointDifficulte(String pointDifficulte) {
		this.pointDifficulte = pointDifficulte;
	}

	public String getNatureMutation() {
		return natureMutation;
	}

	public void setNatureMutation(String natureMutation) {
		this.natureMutation = natureMutation;
	}

	public Boolean getSurEtat() {
		return surEtat;
	}

	public void setSurEtat(Boolean surEtat) {
		this.surEtat = surEtat;
	}

	public Boolean getEnregistrement() {
		return enregistrement;
	}

	public void setEnregistrement(Boolean enregistrement) {
		this.enregistrement = enregistrement;
	}

	public Boolean getModeleUnObligatoire() {
		return modeleUnObligatoire;
	}

	public void setModeleUnObligatoire(Boolean modeleUnObligatoire) {
		this.modeleUnObligatoire = modeleUnObligatoire;
	}

	public void setHypotheque(Boolean hypotheque) {
		this.hypotheque = hypotheque;
	}

	public Collection<TypeSousProduit> getTypeSousProduitCollection() {
		return typeSousProduitCollection;
	}

	public void setTypeSousProduitCollection(
			Collection<TypeSousProduit> typeSousProduitCollection) {
		this.typeSousProduitCollection = typeSousProduitCollection;
	}

	public TypeEffetRelatif getTypeEffetFk() {
		return typeEffetFk;
	}

	public void setTypeEffetFk(TypeEffetRelatif typeEffetFk) {
		this.typeEffetFk = typeEffetFk;
	}

	public Set<TypeComparant> getTypeComparants() {
		return typeComparants;
	}

	public void setTypeComparants(Set<TypeComparant> typeComparants) {
		this.typeComparants = typeComparants;
	}

	public Set<TypeRelationComparution> getTypeRelationComparution() {
		return typeRelationComparution;
	}

	public void setTypeRelationComparution(
			Set<TypeRelationComparution> typeRelationComparution) {
		this.typeRelationComparution = typeRelationComparution;
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
		if (!(object instanceof TypeActe)) {
			return false;
		}
		TypeActe other = (TypeActe) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return id + "";
	}

}
