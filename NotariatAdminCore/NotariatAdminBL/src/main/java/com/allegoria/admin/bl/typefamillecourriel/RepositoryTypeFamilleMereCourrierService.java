package com.allegoria.admin.bl.typefamillecourriel;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typefamillecourrier.TypeFamilleMereCourrierRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleMereCourrier;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeFamilleMereCourrierService implements TypeFamilleMereCourrierService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeFamilleMereCourrierService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeFamilleMereCourrierRepository typeFamilleMereCourrierRepository;
   
	public TypeFamilleMereCourrier create(TypeFamilleMereCourrier created) {
		
		typeFamilleMereCourrierRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		typeFamilleMereCourrierRepository.delete(Id);
		 
	}

	public List<TypeFamilleMereCourrier> findAll() {
		// TODO Auto-generated method stub
		return typeFamilleMereCourrierRepository.findAll();
	}

	public TypeFamilleMereCourrier findById(Long id) {
		// TODO Auto-generated method stub
		return typeFamilleMereCourrierRepository.findOne(id);
	}

	public TypeFamilleMereCourrier update(TypeFamilleMereCourrier updated)
			throws NotFoundException {
		TypeFamilleMereCourrier typeFamilleMereCourrier = typeFamilleMereCourrierRepository.findOne(updated.getId());
		if(typeFamilleMereCourrier!=null)
		{
		typeFamilleMereCourrierRepository.save(typeFamilleMereCourrier);
		}
		return updated;
	}
	
    
    
}
