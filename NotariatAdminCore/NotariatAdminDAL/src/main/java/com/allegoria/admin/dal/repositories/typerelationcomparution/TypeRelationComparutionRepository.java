package com.allegoria.admin.dal.repositories.typerelationcomparution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typeacte.TypeRelationComparution;

@Repository
public interface TypeRelationComparutionRepository extends
		JpaRepository<TypeRelationComparution, Long> {

}
