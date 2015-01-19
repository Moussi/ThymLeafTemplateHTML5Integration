package com.allegoria.admin.dal.repositories.typefamillecourrier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleMereCourrier;

@Repository
public interface TypeFamilleMereCourrierRepository extends
		JpaRepository<TypeFamilleMereCourrier, Long> {

}
