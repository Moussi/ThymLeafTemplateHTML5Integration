package com.allegoria.admin.dom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POST")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	Integer idpost;
	
	@Column(name="POSTE_NOM")
	String nom;
	@Column(name="DATE")
	Date date;
	public Integer getIdpost() {
		return idpost;
	}
	public void setIdpost(Integer idpost) {
		this.idpost = idpost;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}