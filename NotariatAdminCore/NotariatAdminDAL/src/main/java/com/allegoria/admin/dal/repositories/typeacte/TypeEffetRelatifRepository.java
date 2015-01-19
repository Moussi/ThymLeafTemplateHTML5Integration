package com.allegoria.admin.dal.repositories.typeacte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typeacte.TypeEffetRelatif;

@Repository
public interface TypeEffetRelatifRepository extends
		JpaRepository<TypeEffetRelatif, Long> {

}
