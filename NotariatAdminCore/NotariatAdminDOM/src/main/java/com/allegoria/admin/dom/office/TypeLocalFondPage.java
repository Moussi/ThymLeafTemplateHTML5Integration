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

/**
 *
 * @author user
 */
@Entity
@Table(name = "type_local_fond_page")
@NamedQueries({
    @NamedQuery(name = "TypeLocalFondPage.findAll", query = "SELECT t FROM TypeLocalFondPage t")})
public class TypeLocalFondPage implements Serializable {
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
    @Column(name = "INTITULE")
    private String intitule;
    @Size(max = 255)
    @Column(name = "EMPLACEMENT")
    private String emplacement;
    @Column(name = "CHANGEMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changement;
    @Column(name = "ACHEVE")
    private Boolean acheve;
    @JoinColumn(name = "NOTAIRE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Notaire notaireFk;

    public TypeLocalFondPage() {
    }

    public TypeLocalFondPage(Long id) {
        this.id = id;
    }

    public TypeLocalFondPage(Long id, int versioning) {
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

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Date getChangement() {
        return changement;
    }

    public void setChangement(Date changement) {
        this.changement = changement;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
    }

    public Notaire getNotaireFk() {
        return notaireFk;
    }

    public void setNotaireFk(Notaire notaireFk) {
        this.notaireFk = notaireFk;
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
        if (!(object instanceof TypeLocalFondPage)) {
            return false;
        }
        TypeLocalFondPage other = (TypeLocalFondPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.typelocalfondpage.TypeLocalFondPage[ id=" + id + " ]";
    }
    
}
