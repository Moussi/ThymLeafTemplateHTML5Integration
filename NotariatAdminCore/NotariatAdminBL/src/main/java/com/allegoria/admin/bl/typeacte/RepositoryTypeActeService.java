package com.allegoria.admin.bl.typeacte;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dal.repositories.typeacte.TypeActeRepository;
import com.allegoria.admin.dom.typeacte.TypeActe;






/**
 * This implementation of the TypeActe interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeActeService implements TypeActeService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeActeService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeActeRepository typeActeRepository;

    
    
    public TypeActe create(TypeActe created) {
        LOGGER.debug("Creating a new typeActe with information: " + created);
        
        typeActeRepository.save(created);
        
        return created;
    }

   

    @Transactional(rollbackFor = NotFoundException.class)
    public TypeActe delete(Long typeActeId) throws NotFoundException {
        LOGGER.debug("Deleting typeActe with id: " + typeActeId);
        
        TypeActe deleted = typeActeRepository.findOne(typeActeId);
        
        if (deleted == null) {
            LOGGER.debug("No typeActe found with id: " + typeActeId);
            throw new NotFoundException();
        }
        
        typeActeRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public List<TypeActe> findAll() {
        LOGGER.debug("Finding all typeActes");
        return typeActeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TypeActe findById(Long id) {
        LOGGER.debug("Finding typeActe by id: " + id);
        return typeActeRepository.findOne(id);
    }

   

    
    public TypeActe update(TypeActe updated) throws NotFoundException {
        LOGGER.debug("Updating typeActe with information: " + updated);
        
        TypeActe typeActe=typeActeRepository.findOne(updated.getId());
        if (typeActe == null) {
            LOGGER.debug("No typeActe found with id: " + updated.getId());
            throw new NotFoundException();
        }
      
        typeActeRepository.save(updated);
        
        
        
        
        return updated;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param typeActeRepository
     */
    protected void setTypeActeRepository(TypeActeRepository typeActeRepository) {
        this.typeActeRepository = typeActeRepository;
    }
}
