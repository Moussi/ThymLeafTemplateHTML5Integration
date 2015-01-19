package com.allegoria.admin.dal.repositories.typeacte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typeacte.TypeComparant;

@Repository
public interface TypeComparantRepository extends
		JpaRepository<TypeComparant, Long> {

}
