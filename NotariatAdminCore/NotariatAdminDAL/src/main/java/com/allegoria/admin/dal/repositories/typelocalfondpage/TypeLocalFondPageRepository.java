package com.allegoria.admin.dal.repositories.typelocalfondpage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.office.TypeLocalFondPage;

@Repository
public interface TypeLocalFondPageRepository extends
		JpaRepository<TypeLocalFondPage, Long> {

}
