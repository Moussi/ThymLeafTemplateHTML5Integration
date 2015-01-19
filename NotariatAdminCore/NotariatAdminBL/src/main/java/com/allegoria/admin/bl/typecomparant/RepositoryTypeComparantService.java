package com.allegoria.admin.bl.typecomparant;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typeacte.TypeComparantRepository;
import com.allegoria.admin.dom.typeacte.TypeComparant;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeComparantService implements TypeComparantService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeComparantService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeComparantRepository typeComparantRepository;
   
	public TypeComparant create(TypeComparant created) {
		
		typeComparantRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		typeComparantRepository.delete(Id);
		 
	}

	public List<TypeComparant> findAll() {
		// TODO Auto-generated method stub
		return typeComparantRepository.findAll();
	}

	public TypeComparant findById(Long id) {
		// TODO Auto-generated method stub
		return typeComparantRepository.findOne(id);
	}

	public TypeComparant update(TypeComparant updated)
			throws NotFoundException {
		TypeComparant typeComparant = typeComparantRepository.findOne(updated.getId());
		if(typeComparant!=null)
		{
		typeComparantRepository.save(typeComparant);
		}
		return updated;
	}
	
    
    
}
