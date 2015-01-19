/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allegoria.admin.bl.dto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allégoria
 */

public class TypeFamilleCourrierLocalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private int versioning;
    private String genre;
    private Boolean acheve;

    public TypeFamilleCourrierLocalDTO() {
    }

    public TypeFamilleCourrierLocalDTO(Long id) {
        this.id = id;
    }

    public TypeFamilleCourrierLocalDTO(Long id, int versioning) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getAcheve() {
        return acheve;
    }

    public void setAcheve(Boolean acheve) {
        this.acheve = acheve;
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
        if (!(object instanceof TypeFamilleCourrierLocalDTO)) {
            return false;
        }
        TypeFamilleCourrierLocalDTO other = (TypeFamilleCourrierLocalDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"id\":\"").append(id).append("\",\"versioning\":\"")
				.append(versioning).append("\",\"genre\":\"").append(genre)
				.append("\",\"acheve\":\"").append(acheve).append("\"}");
		return builder.toString();
	}

    
    
}
