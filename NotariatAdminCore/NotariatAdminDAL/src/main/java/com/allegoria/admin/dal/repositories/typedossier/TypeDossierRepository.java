package com.allegoria.admin.dal.repositories.typedossier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.dossier.TypeDossier;

@Repository
public interface TypeDossierRepository extends
		JpaRepository<TypeDossier, Long> {

}
