package com.allegoria.admin.bl.typefamillecourriel;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.bl.dto.OfficeDTO;
import com.allegoria.admin.bl.dto.TypeFamilleCourrierLocalDTO;
import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.AnnexeRepository;
import com.allegoria.admin.dal.repositories.office.CoordonneeRepository;
import com.allegoria.admin.dal.repositories.office.DocumentFichierRepository;
import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dal.repositories.typefamillecourrier.TypeFamilleCourrierLocalRepository;
import com.allegoria.admin.dom.office.Annexe;
import com.allegoria.admin.dom.office.DocumentFichier;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.office.Rib;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleCourrierLocal;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryTypeFamilleCourrierLocalService implements TypeFamilleCourrierLocalService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryTypeFamilleCourrierLocalService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private TypeFamilleCourrierLocalRepository typeFamilleCourrierLocalRepository;
   
	public TypeFamilleCourrierLocal create(TypeFamilleCourrierLocalDTO created) {
		TypeFamilleCourrierLocal typeFamilleCourrierLocal = new TypeFamilleCourrierLocal();
		typeFamilleCourrierLocal.setAcheve(created.getAcheve());
		typeFamilleCourrierLocal.setGenre(created.getGenre());
		typeFamilleCourrierLocal.setVersioning(created.getVersioning());
		typeFamilleCourrierLocalRepository.save(typeFamilleCourrierLocal);
		return typeFamilleCourrierLocal;
	}

	public void delete(Long Id)
			throws TypeFamilleCourrierLocalNotFoundException {
		// TODO Auto-generated method stub
		typeFamilleCourrierLocalRepository.delete(Id);
		 
	}

	public List<TypeFamilleCourrierLocal> findAll() {
		// TODO Auto-generated method stub
		return typeFamilleCourrierLocalRepository.findAll();
	}

	public TypeFamilleCourrierLocal findById(Long id) {
		// TODO Auto-generated method stub
		return typeFamilleCourrierLocalRepository.findOne(id);
	}

	public TypeFamilleCourrierLocal update(TypeFamilleCourrierLocalDTO updated)
			throws TypeFamilleCourrierLocalNotFoundException {
		TypeFamilleCourrierLocal typeFamilleCourrierLocal = typeFamilleCourrierLocalRepository.findOne(updated.getId());
		typeFamilleCourrierLocal.setAcheve(updated.getAcheve());
		typeFamilleCourrierLocal.setGenre(updated.getGenre());
		typeFamilleCourrierLocal.setVersioning(updated.getVersioning());
		typeFamilleCourrierLocalRepository.save(typeFamilleCourrierLocal);
		return typeFamilleCourrierLocal;
	}
	
    
    
}
