package com.allegoria.admin.bl.typecourrier;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeCourrierRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;






/**
 * This implementation of the TypeActe interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeCourrierService implements TypeCourrierService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeCourrierService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeCourrierRepository typeCourrierRepository;

    
    
    public TypeCourrier create(TypeCourrier created) {
        LOGGER.debug("Creating a new typeCourrier with information: " + created);
        
        typeCourrierRepository.save(created);
        
        return created;
    }

   

    @Transactional(rollbackFor = NotFoundException.class)
    public TypeCourrier delete(Long typeCourrierId) throws NotFoundException {
        LOGGER.debug("Deleting typeCourrier with id: " + typeCourrierId);
        
        TypeCourrier deleted = typeCourrierRepository.findOne(typeCourrierId);
        
        if (deleted == null) {
            LOGGER.debug("No typeCourrier found with id: " + typeCourrierId);
            throw new NotFoundException();
        }
        
        typeCourrierRepository.delete(deleted);
        return deleted;
    }

    
    public List<TypeCourrier> findAll() {
        LOGGER.debug("Finding all typeCourriers");
        return typeCourrierRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TypeCourrier findById(Long id) {
        LOGGER.debug("Finding typeCourrier by id: " + id);
        return typeCourrierRepository.findOne(id);
    }

   

    
    public TypeCourrier update(TypeCourrier updated) throws NotFoundException {
        LOGGER.debug("Updating typeCourrier with information: " + updated);
        
        TypeCourrier typeCourrier=typeCourrierRepository.findOne(updated.getId());
        if (typeCourrier == null) {
            LOGGER.debug("No typeCourrier found with id: " + updated.getId());
            throw new NotFoundException();
        }
      
        typeCourrierRepository.save(updated);
        
        
        
        
        return updated;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param typeCourrierRepository
     */
    protected void setTypeCourrierRepository(TypeCourrierRepository typeCourrierRepository) {
        this.typeCourrierRepository = typeCourrierRepository;
    }
}
