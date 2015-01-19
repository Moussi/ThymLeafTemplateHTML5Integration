/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.office;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "rib")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rib.findAll", query = "SELECT r FROM Rib r"),
    @NamedQuery(name = "Rib.findById", query = "SELECT r FROM Rib r WHERE r.id = :id"),
    @NamedQuery(name = "Rib.findByVersioning", query = "SELECT r FROM Rib r WHERE r.versioning = :versioning"),
    @NamedQuery(name = "Rib.findByDomiciliation", query = "SELECT r FROM Rib r WHERE r.domiciliation = :domiciliation"),
    @NamedQuery(name = "Rib.findByBanque", query = "SELECT r FROM Rib r WHERE r.banque = :banque"),
    @NamedQuery(name = "Rib.findByGuichet", query = "SELECT r FROM Rib r WHERE r.guichet = :guichet"),
    @NamedQuery(name = "Rib.findByCompte", query = "SELECT r FROM Rib r WHERE r.compte = :compte"),
    @NamedQuery(name = "Rib.findByCle", query = "SELECT r FROM Rib r WHERE r.cle = :cle"),
    @NamedQuery(name = "Rib.findByPaysIban", query = "SELECT r FROM Rib r WHERE r.paysIban = :paysIban"),
    @NamedQuery(name = "Rib.findByCleIban", query = "SELECT r FROM Rib r WHERE r.cleIban = :cleIban"),
    @NamedQuery(name = "Rib.findByIban", query = "SELECT r FROM Rib r WHERE r.iban = :iban"),
    @NamedQuery(name = "Rib.findByBic", query = "SELECT r FROM Rib r WHERE r.bic = :bic"),
    @NamedQuery(name = "Rib.findByElectronique", query = "SELECT r FROM Rib r WHERE r.electronique = :electronique"),
    @NamedQuery(name = "Rib.findByAcheve", query = "SELECT r FROM Rib r WHERE r.acheve = :acheve"),
    @NamedQuery(name = "Rib.findByDateAcheve", query = "SELECT r FROM Rib r WHERE r.dateAcheve = :dateAcheve"),
    @NamedQuery(name = "Rib.findByTitulaire", query = "SELECT r FROM Rib r WHERE r.titulaire = :titulaire")})
public class Rib implements Serializable {
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
    @Column(name = "DOMICILIATION")
    private String domiciliation;
    @Size(max = 255)
    @Column(name = "BANQUE")
    private String banque;
    @Size(max = 255)
    @Column(name = "GUICHET")
    private String guichet;
    @Size(max = 255)
    @Column(name = "COMPTE")
    private String compte;
    @Column(name = "CLE")
    private Integer cle;
    @Size(max = 255)
    @Column(name = "PAYS_IBAN")
    private String paysIban;
    @Column(name = "CLE_IBAN")
    private Integer cleIban;
    @Size(max = 255)
    @Column(name = "IBAN")
    private String iban;
    @Size(max = 255)
    @Column(name = "BIC")
    private String bic;
    @Column(name = "ELECTRONIQUE")
    private Boolean electronique;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @Column(name = "DATE_ACHEVE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcheve;
    @Size(max = 255)
    @Column(name = "TITULAIRE")
    private String titulaire;
    @JoinColumn(name = "OFFICE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Office officeFk;

    public Rib() {
    }

    public Rib(Long id) {
        this.id = id;
    }

    public Rib(Long id, int versioning) {
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

    public String getDomiciliation() {
        return domiciliation;
    }

    public void setDomiciliation(String domiciliation) {
        this.domiciliation = domiciliation;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getGuichet() {
        return guichet;
    }

    public void setGuichet(String guichet) {
        this.guichet = guichet;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public Integer getCle() {
        return cle;
    }

    public void setCle(Integer cle) {
        this.cle = cle;
    }

    public String getPaysIban() {
        return paysIban;
    }

    public void setPaysIban(String paysIban) {
        this.paysIban = paysIban;
    }

    public Integer getCleIban() {
        return cleIban;
    }

    public void setCleIban(Integer cleIban) {
        this.cleIban = cleIban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Boolean getElectronique() {
        return electronique;
    }

    public void setElectronique(Boolean electronique) {
        this.electronique = electronique;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public Date getDateAcheve() {
        return dateAcheve;
    }

    public void setDateAcheve(Date dateAcheve) {
        this.dateAcheve = dateAcheve;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public Office getOfficeFk() {
        return officeFk;
    }

    public void setOfficeFk(Office officeFk) {
        this.officeFk = officeFk;
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
        if (!(object instanceof Rib)) {
            return false;
        }
        Rib other = (Rib) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
	
    
}
