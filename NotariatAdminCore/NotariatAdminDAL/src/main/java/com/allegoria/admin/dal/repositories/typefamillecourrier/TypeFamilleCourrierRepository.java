package com.allegoria.admin.dal.repositories.typefamillecourrier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleCourrier;

@Repository
public interface TypeFamilleCourrierRepository extends
		JpaRepository<TypeFamilleCourrier, Long> {

}
