package com.allegoria.admin.bl.typedossier;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.dal.repositories.typedossier.TypeDossierRepository;
import com.allegoria.admin.dom.dossier.TypeDossier;




/**
 * This implementation of the TypeDossier interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeDossierService implements TypeDossierService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeDossierService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeDossierRepository typeDossierRepository;

    
    
    public TypeDossier create(TypeDossier created) {
        LOGGER.debug("Creating a new typeDossier with information: " + created);
        
        typeDossierRepository.save(created);
        
        return created;
    }

   

    @Transactional(rollbackFor = TypeDossierNotFoundException.class)
    public TypeDossier delete(Long typeDossierId) throws TypeDossierNotFoundException {
        LOGGER.debug("Deleting typeDossier with id: " + typeDossierId);
        
        TypeDossier deleted = typeDossierRepository.findOne(typeDossierId);
        
        if (deleted == null) {
            LOGGER.debug("No typeDossier found with id: " + typeDossierId);
            throw new TypeDossierNotFoundException();
        }
        
        typeDossierRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public List<TypeDossier> findAll() {
        LOGGER.debug("Finding all typeDossiers");
        return typeDossierRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TypeDossier findById(Long id) {
        LOGGER.debug("Finding typeDossier by id: " + id);
        return typeDossierRepository.findOne(id);
    }

   

    
    public TypeDossier update(TypeDossier updated) throws TypeDossierNotFoundException {
        LOGGER.debug("Updating typeDossier with information: " + updated);
        
        TypeDossier typeDossier=typeDossierRepository.findOne(updated.getId());
        if (typeDossier == null) {
            LOGGER.debug("No typeDossier found with id: " + updated.getId());
            throw new TypeDossierNotFoundException();
        }
      
        typeDossierRepository.save(updated);
        
        
        
        
        return updated;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param typeDossierRepository
     */
    protected void setTypeDossierRepository(TypeDossierRepository typeDossierRepository) {
        this.typeDossierRepository = typeDossierRepository;
    }
}
