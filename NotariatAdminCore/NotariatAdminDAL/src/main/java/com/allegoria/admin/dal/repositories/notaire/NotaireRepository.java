package com.allegoria.admin.dal.repositories.notaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.office.Notaire;

@Repository
public interface NotaireRepository extends
		JpaRepository<Notaire, Long> {

}
