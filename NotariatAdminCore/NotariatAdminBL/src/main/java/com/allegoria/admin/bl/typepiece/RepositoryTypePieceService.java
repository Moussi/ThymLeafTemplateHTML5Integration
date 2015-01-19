package com.allegoria.admin.bl.typepiece;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typepiece.TypePieceRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypePiece;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypePieceService implements TypePieceService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypePieceService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypePieceRepository typePieceRepository;
   
	public TypePiece create(TypePiece created) {
		
		typePieceRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		typePieceRepository.delete(Id);
		 
	}

	public List<TypePiece> findAll() {
		// TODO Auto-generated method stub
		return typePieceRepository.findAll();
	}

	public TypePiece findById(Long id) {
		// TODO Auto-generated method stub
		return typePieceRepository.findOne(id);
	}

	public TypePiece update(TypePiece updated)
			throws NotFoundException {
		TypePiece typePiece = typePieceRepository.findOne(updated.getId());
		if(typePiece!=null)
		{
		typePieceRepository.save(typePiece);
		}
		return updated;
	}
	
    
    
}
