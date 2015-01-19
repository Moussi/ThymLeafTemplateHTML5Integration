package com.allegoria.admin.dal.repositories.typeacte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typeacte.TypeActe;
import com.allegoria.admin.dom.typeacte.TypeSousProduit;

@Repository
public interface TypeActeRepository extends JpaRepository<TypeActe, Long> {

}
