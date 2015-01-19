package com.allegoria.admin.bl.typecomparutioncourrrier;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeComparutionCourrierRepository;
import com.allegoria.admin.dom.typefamillecourrier.TypeComparutionCourrier;



/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeComparutionCourrierService implements TypeComparutionCourrierService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeComparutionCourrierService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeComparutionCourrierRepository typeComparutionCourrierRepository;

    
    
    public TypeComparutionCourrier create(TypeComparutionCourrier created) {
        LOGGER.debug("Creating a new typeComparutionCourrier with information: " + created);
        
        typeComparutionCourrierRepository.save(created);
        
        return created;
    }

   

    @Transactional(rollbackFor = TypeComparutionCourrierNotFoundException.class)
    public TypeComparutionCourrier delete(Long typeComparutionCourrierId) throws TypeComparutionCourrierNotFoundException {
        LOGGER.debug("Deleting typeComparutionCourrier with id: " + typeComparutionCourrierId);
        
        TypeComparutionCourrier deleted = typeComparutionCourrierRepository.findOne(typeComparutionCourrierId);
        
        if (deleted == null) {
            LOGGER.debug("No typeComparutionCourrier found with id: " + typeComparutionCourrierId);
            throw new TypeComparutionCourrierNotFoundException();
        }
        
        typeComparutionCourrierRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public List<TypeComparutionCourrier> findAll() {
        LOGGER.debug("Finding all typeComparutionCourriers");
        return typeComparutionCourrierRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TypeComparutionCourrier findById(Long id) {
        LOGGER.debug("Finding typeComparutionCourrier by id: " + id);
        return typeComparutionCourrierRepository.findOne(id);
    }

   

    
    public TypeComparutionCourrier update(TypeComparutionCourrier updated) throws TypeComparutionCourrierNotFoundException {
        LOGGER.debug("Updating typeComparutionCourrier with information: " + updated);
        
        TypeComparutionCourrier typeComparutionCourrier=typeComparutionCourrierRepository.findOne(updated.getId());
        if (typeComparutionCourrier == null) {
            LOGGER.debug("No typeComparutionCourrier found with id: " + updated.getId());
            throw new TypeComparutionCourrierNotFoundException();
        }
      
        typeComparutionCourrierRepository.save(updated);
        
        
        
        
        return updated;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param typeComparutionCourrierRepository
     */
    protected void setTypeComparutionCourrierRepository(TypeComparutionCourrierRepository typeComparutionCourrierRepository) {
        this.typeComparutionCourrierRepository = typeComparutionCourrierRepository;
    }
}
