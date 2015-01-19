package com.allegoria.admin.dal.repositories.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.office.Utilisateur;

@Repository
public interface UtilisateurRepository extends
		JpaRepository<Utilisateur, Long> {
		public Utilisateur findOneByLogin(String login);
}
