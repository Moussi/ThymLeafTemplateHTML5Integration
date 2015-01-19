package com.allegoria.admin.bl.typesousproduit;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.dto.typeacte.TypeSousProduitDTO;
import com.allegoria.admin.dal.repositories.typeacte.TypeActeRepository;
import com.allegoria.admin.dal.repositories.typeacte.TypeSousProduitRepository;
import com.allegoria.admin.dom.typeacte.TypeSousProduit;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeSousProduitService implements TypeSousProduitService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeSousProduitService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeSousProduitRepository typeSousProduitRepository;
    @Autowired
    private TypeActeRepository typeActeRepository;
   
	public TypeSousProduit create(TypeSousProduitDTO created) {
		TypeSousProduit typeSousProduit = new TypeSousProduit();
		typeSousProduit.setAcheve(created.getAcheve());
		typeSousProduit.setGenre(created.getGenre());
		typeSousProduit.setVersioning(created.getVersioning());
		typeSousProduit.setAutoGenere(created.getAutoGenere());
		typeSousProduit.setAvecMarge(created.getAvecMarge());
		typeSousProduit.setAvecStyle(created.getAvecStyle());
		typeSousProduit.setCopieActe(created.getCopieActe());
		typeSousProduit.setEmplacement(created.getEmplacement());
		typeSousProduit.setEntete(created.getEntete());
		typeSousProduit.setFamille(created.getFamille());
		typeSousProduit.setNom(created.getNom());
		typeSousProduit.setOccurrence(created.getOccurrence());
		typeSousProduit.setPourDepot(created.getPourDepot());
		typeSousProduit.setSignaturePlanete(created.getSignaturePlanete());
		 if(created.getTypeActeFk()!=null)
	        {
	        if(typeActeRepository.findOne(created.getTypeActeFk())!=null)
	        {
		typeSousProduit.setTypeActeFk(typeActeRepository.findOne(created.getTypeActeFk()));
		        }
		 }
		typeSousProduit.setVarianteCode(created.getVarianteCode());
		typeSousProduit.setVarianteId(created.getVarianteId());
		
		typeSousProduitRepository.save(typeSousProduit);
		return typeSousProduit;
	}

	public void delete(Long Id)
			throws TypeTypeSousProduitNotFoundException {
		// TODO Auto-generated method stub
		typeSousProduitRepository.delete(Id);
		 
	}

	public List<TypeSousProduit> findAll() {
		// TODO Auto-generated method stub
		return typeSousProduitRepository.findAll();
	}

	public TypeSousProduit findById(Long id) {
		// TODO Auto-generated method stub
		return typeSousProduitRepository.findOne(id);
	}

	public TypeSousProduit update(TypeSousProduitDTO updated)
			throws TypeTypeSousProduitNotFoundException {
		TypeSousProduit typeSousProduit = typeSousProduitRepository.findOne(updated.getId());
		typeSousProduit.setAcheve(updated.getAcheve());
		typeSousProduit.setGenre(updated.getGenre());
		typeSousProduit.setVersioning(updated.getVersioning());
		typeSousProduit.setAutoGenere(updated.getAutoGenere());
		typeSousProduit.setAvecMarge(updated.getAvecMarge());
		typeSousProduit.setAvecStyle(updated.getAvecStyle());
		typeSousProduit.setCopieActe(updated.getCopieActe());
		typeSousProduit.setEmplacement(updated.getEmplacement());
		typeSousProduit.setEntete(updated.getEntete());
		typeSousProduit.setFamille(updated.getFamille());
		typeSousProduit.setNom(updated.getNom());
		typeSousProduit.setOccurrence(updated.getOccurrence());
		typeSousProduit.setPourDepot(updated.getPourDepot());
		typeSousProduit.setSignaturePlanete(updated.getSignaturePlanete());
		if(updated.getTypeActeFk()!=null)
        {
        if(typeActeRepository.findOne(updated.getTypeActeFk())!=null)
        {
	typeSousProduit.setTypeActeFk(typeActeRepository.findOne(updated.getTypeActeFk()));
	        }
	 }
		typeSousProduit.setVarianteCode(updated.getVarianteCode());
		typeSousProduit.setVarianteId(updated.getVarianteId());
		typeSousProduitRepository.save(typeSousProduit);
		return typeSousProduit;
	}
	
    
    
}
