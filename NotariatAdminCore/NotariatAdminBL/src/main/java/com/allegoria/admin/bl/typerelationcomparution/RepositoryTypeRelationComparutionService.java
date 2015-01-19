package com.allegoria.admin.bl.typerelationcomparution;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typerelationcomparution.TypeRelationComparutionRepository;
import com.allegoria.admin.dom.typeacte.TypeRelationComparution;


/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeRelationComparutionService implements TypeRelationComparutionService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeRelationComparutionService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeRelationComparutionRepository typeRelationComparutionRepository;
   
	public TypeRelationComparution create(TypeRelationComparution created) {
		
		typeRelationComparutionRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		typeRelationComparutionRepository.delete(Id);
		 
	}

	public List<TypeRelationComparution> findAll() {
		// TODO Auto-generated method stub
		return typeRelationComparutionRepository.findAll();
	}

	public TypeRelationComparution findById(Long id) {
		// TODO Auto-generated method stub
		return typeRelationComparutionRepository.findOne(id);
	}

	public TypeRelationComparution update(TypeRelationComparution updated)
			throws NotFoundException {
		TypeRelationComparution typeRelationComparution = typeRelationComparutionRepository.findOne(updated.getId());
		if(typeRelationComparution!=null)
		{
		typeRelationComparutionRepository.save(typeRelationComparution);
		}
		return updated;
	}
	
    
    
}
