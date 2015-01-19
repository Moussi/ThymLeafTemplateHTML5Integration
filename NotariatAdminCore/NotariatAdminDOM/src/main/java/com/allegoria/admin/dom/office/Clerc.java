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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Entity
@Table(name = "clerc")
@NamedQueries({
    @NamedQuery(name = "Clerc.findAll", query = "SELECT c FROM Clerc c")})
public class Clerc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE_HABILITATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHabilitation;
    @Column(name = "HABILITE")
    private Boolean habilite;
    @OneToMany(mappedBy = "clercFk")
    private Collection<Secretaire> secretaireCollection;
    @JoinColumn(name = "NOTAIRE_FK", referencedColumnName = "ID")
    @ManyToOne
    private Notaire notaireFk;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilisateur utilisateur;

    public Clerc() {
    }

    public Clerc(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateHabilitation() {
        return dateHabilitation;
    }

    public void setDateHabilitation(Date dateHabilitation) {
        this.dateHabilitation = dateHabilitation;
    }

    

    public Boolean getHabilite() {
		return habilite;
	}

	public void setHabilite(Boolean habilite) {
		this.habilite = habilite;
	}

	public Collection<Secretaire> getSecretaireCollection() {
        return secretaireCollection;
    }

    public void setSecretaireCollection(Collection<Secretaire> secretaireCollection) {
        this.secretaireCollection = secretaireCollection;
    }

    public Notaire getNotaireFk() {
        return notaireFk;
    }

    public void setNotaireFk(Notaire notaireFk) {
        this.notaireFk = notaireFk;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        if (!(object instanceof Clerc)) {
            return false;
        }
        Clerc other = (Clerc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allegoria.admin.dom.personne.Clerc[ id=" + id + " ]";
    }
    
}
