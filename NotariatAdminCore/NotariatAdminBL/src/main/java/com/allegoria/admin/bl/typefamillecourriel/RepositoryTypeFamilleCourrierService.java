package com.allegoria.admin.bl.typefamillecourriel;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typefamillecourrier.TypeFamilleCourrierRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleCourrier;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeFamilleCourrierService implements TypeFamilleCourrierService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeFamilleCourrierService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeFamilleCourrierRepository typeFamilleCourrierRepository;
   
	public TypeFamilleCourrier create(TypeFamilleCourrier created) {
		
		typeFamilleCourrierRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		typeFamilleCourrierRepository.delete(Id);
		 
	}

	public List<TypeFamilleCourrier> findAll() {
		// TODO Auto-generated method stub
		return typeFamilleCourrierRepository.findAll();
	}

	public TypeFamilleCourrier findById(Long id) {
		// TODO Auto-generated method stub
		return typeFamilleCourrierRepository.findOne(id);
	}

	public TypeFamilleCourrier update(TypeFamilleCourrier updated)
			throws NotFoundException {
		TypeFamilleCourrier typeFamilleCourrier = typeFamilleCourrierRepository.findOne(updated.getId());
		if(typeFamilleCourrier!=null)
		{
		typeFamilleCourrierRepository.save(typeFamilleCourrier);
		}
		return updated;
	}
	
    
    
}
