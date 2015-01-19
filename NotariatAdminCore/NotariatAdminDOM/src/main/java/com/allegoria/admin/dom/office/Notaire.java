/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.dom.office;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "notaire")
@NamedQueries({
    @NamedQuery(name = "Notaire.findAll", query = "SELECT n FROM Notaire n")})
public class Notaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ASSOCIE")
    private Boolean associe;
    @Column(name = "SALARIE")
    private Boolean salarie;
    @Column(name = "ASSISTANT")
    private Boolean assistant;
    @Size(max = 255)
    @Column(name = "ID_NOTAIRE_INSTRUMENTAIRE")
    private String idNotaireInstrumentaire;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
   
    @OneToOne(fetch = FetchType.LAZY,mappedBy="notaire", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "notaireFk",fetch=FetchType.EAGER)
    private Collection<TypeLocalFondPage> typeLocalFondPageCollection;

    public Notaire() {
    }

    public Notaire(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAssocie() {
        return associe;
    }

    public void setAssocie(Boolean associe) {
        this.associe = associe;
    }

    public Boolean getSalarie() {
        return salarie;
    }

    public void setSalarie(Boolean salarie) {
        this.salarie = salarie;
    }

    public Boolean getAssistant() {
        return assistant;
    }

    public void setAssistant(Boolean assistant) {
        this.assistant = assistant;
    }

    public String getIdNotaireInstrumentaire() {
        return idNotaireInstrumentaire;
    }

    public void setIdNotaireInstrumentaire(String idNotaireInstrumentaire) {
        this.idNotaireInstrumentaire = idNotaireInstrumentaire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Collection<TypeLocalFondPage> getTypeLocalFondPageCollection() {
        return typeLocalFondPageCollection;
    }

    public void setTypeLocalFondPageCollection(Collection<TypeLocalFondPage> typeLocalFondPageCollection) {
        this.typeLocalFondPageCollection = typeLocalFondPageCollection;
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
        if (!(object instanceof Notaire)) {
            return false;
        }
        Notaire other = (Notaire) object;
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
