package com.allegoria.admin.dal.repositories.typepiece;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allegoria.admin.dom.typefamillecourrier.TypePiece;

@Repository
public interface TypePieceRepository extends
		JpaRepository<TypePiece, Long> {

}
