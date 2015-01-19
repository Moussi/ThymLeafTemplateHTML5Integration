package com.allegoria.admin.dal.repositories.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.office.Annexe;

@Repository
public interface AnnexeRepository extends JpaRepository<Annexe, Long> {

}
