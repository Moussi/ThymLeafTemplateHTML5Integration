package com.allegoria.admin.dal.repositories.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.office.Office;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

	
	
	
}
