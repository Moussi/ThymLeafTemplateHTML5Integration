package com.allegoria.admin.dal.repositories.typecritereautogeneration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;

@Repository
public interface TypeCritereAutoGenerationRepository extends JpaRepository<TypeCritereAutoGeneration, Long> {

	
	
}
