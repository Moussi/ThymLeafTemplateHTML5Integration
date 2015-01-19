package com.allegoria.admin.bl.typecritereautogeneration;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.dal.repositories.typecritereautogeneration.TypeCritereAutoGenerationRepository;
import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;


/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeCritereAutoGenerationService implements TypeCritereAutoGenerationService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeCritereAutoGenerationService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeCritereAutoGenerationRepository typeCritereAutoGenerationRepository;
    
   
	public TypeCritereAutoGeneration create(TypeCritereAutoGeneration created) {
		typeCritereAutoGenerationRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws TypeCritereAutoGenerationNotFoundException {
		// TODO Auto-generated method stub
		typeCritereAutoGenerationRepository.delete(Id);
		 
	}

	public List<TypeCritereAutoGeneration> findAll() {
		// TODO Auto-generated method stub
		return typeCritereAutoGenerationRepository.findAll();
	}

	public TypeCritereAutoGeneration findById(Long id) {
		// TODO Auto-generated method stub
		return typeCritereAutoGenerationRepository.findOne(id);
	}

	public TypeCritereAutoGeneration update(TypeCritereAutoGeneration updated)
			throws TypeCritereAutoGenerationNotFoundException {
		typeCritereAutoGenerationRepository.save(updated);
		return updated;
	}
	
    
    
}
