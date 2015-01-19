package com.allegoria.admin.bl.typelocalfondpage;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typelocalfondpage.TypeLocalFondPageRepository;
import com.allegoria.admin.dom.office.TypeLocalFondPage;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeLocalFondPageService implements TypeLocalFondPageService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeLocalFondPageService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeLocalFondPageRepository typeLocalFondPageRepository;
   
	public TypeLocalFondPage create(TypeLocalFondPage created) {
		
		typeLocalFondPageRepository.save(created);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		typeLocalFondPageRepository.delete(Id);
		 
	}

	public List<TypeLocalFondPage> findAll() {
		// TODO Auto-generated method stub
		return typeLocalFondPageRepository.findAll();
	}

	public TypeLocalFondPage findById(Long id) {
		// TODO Auto-generated method stub
		return typeLocalFondPageRepository.findOne(id);
	}

	public TypeLocalFondPage update(TypeLocalFondPage updated)
			throws NotFoundException {
		TypeLocalFondPage typeLocalFondPage = typeLocalFondPageRepository.findOne(updated.getId());
		if(typeLocalFondPage!=null)
		{
		typeLocalFondPageRepository.save(updated);
		}
		return typeLocalFondPage;
	}
	
    
    
}
