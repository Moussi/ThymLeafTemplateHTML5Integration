package com.allegoria.admin.bl.office;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.bl.dto.OfficeDTO;
import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.AnnexeRepository;
import com.allegoria.admin.dal.repositories.office.CoordonneeRepository;
import com.allegoria.admin.dal.repositories.office.DocumentFichierRepository;
import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dom.office.Annexe;
import com.allegoria.admin.dom.office.DocumentFichier;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.office.Rib;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryOfficeService implements OfficeService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryOfficeService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private AdresseOfficeRepository adresseOfficeRepository;
    @Autowired
    private CoordonneeRepository coordonneeRepository;
    @Autowired
    private RibRepository ribRepository;
    @Autowired
    private DocumentFichierRepository documentFichierRepository;
    @Autowired
    private AnnexeRepository annexeRepository;
    
    
    public Office create(OfficeDTO created) {
        LOGGER.debug("Creating a new office with information: " + created);
        
        Office office = new Office();
        //office.setId(created.getId());
        if(created.getAdresseFk()!=null)
        {
        office.setAdresseFk(adresseOfficeRepository.findOne(created.getAdresseFk()));
        }
        office.setAlerteReponseCourrier(created.getAlerteReponseCourrier());
        office.setCodeApe(created.getCodeApe());
        office.setCodeCsn(created.getCodeCsn());
        office.setDernierNumeroArchive(created.getDernierNumeroArchive());
        office.setNom(created.getNom());
        office.setNumeroAgree(created.getNumeroAgree());
        office.setNumeroArchiveAuto(created.getNumeroArchiveAuto());
        office.setNumeroCrpcen(created.getNumeroCrpcen());
        office.setNumeroSiren(created.getNumeroSiren());
        office.setNumeroTva(created.getNumeroTva());
        office.setNumeroUrssaf(created.getNumeroUrssaf());
        office.setPoidMaxMicen(created.getPoidMaxMicen());
        office.setPoidMaxMicenAvecMentions(created.getPoidMaxMicenAvecMentions());
        office.setPoidMaxMicenAvecMentionsCritique(created.getPoidMaxMicenAvecMentionsCritique());
        office.setRepertoireNumeroContinu(created.getRepertoireNumeroContinu());
        office.setServeurMicen(created.getServeurMicen());
        office.setStatut(created.getStatut());
        office.setVersionMetaSpecifiquesMicen(created.getVersionMetaSpecifiquesMicen());
        office.setVersionXsdMicen(created.getVersionXsdMicen());
        if(created.getAdresseFk()!=null)
        {
        office.setAdresseFk(adresseOfficeRepository.findOne(created.getAdresseFk()));
        }
        if(created.getCoordonneeFk()!=null)
        {
        office.setCoordonneeFk(coordonneeRepository.findOne(created.getCoordonneeFk()));
        }
        officeRepository.save(office);
        // Entregistrer la liste des ribs , des annexes et des documents fichiers de nouveau office
        
        Rib rib = new Rib();
        Annexe annexe = new Annexe();
        DocumentFichier document= new DocumentFichier();
        if(created.getRibCollection()!=null)
        {
        for(Long ribId:created.getRibCollection())
        {
        	rib = ribRepository.findOne(ribId);
        	rib.setOfficeFk(office);
    		ribRepository.save(rib);
        }
        }
        
        if(created.getAnnexeCollection()!=null)
        {
        for(Long annexeId:created.getAnnexeCollection())
        {
        	annexe = annexeRepository.findOne(annexeId);
        	annexe.setOfficeFk(office);
    		annexeRepository.save(annexe);
        }
        }
        
        if(created.getDocumentFichierCollection()!=null)
        {
        for(Long docId:created.getDocumentFichierCollection())
        {
        	document = documentFichierRepository.findOne(docId);
        	document.setOfficeFk(office);
    		documentFichierRepository.save(document);
        }
        }
        return office;
    }

   

    @Transactional(rollbackFor = OfficeNotFoundException.class)
    public Office delete(Long officeId) throws OfficeNotFoundException {
        LOGGER.debug("Deleting office with id: " + officeId);
        
        Office deleted = officeRepository.findOne(officeId);
        
        if (deleted == null) {
            LOGGER.debug("No office found with id: " + officeId);
            throw new OfficeNotFoundException();
        }
        
        officeRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public List<Office> findAll() {
        LOGGER.debug("Finding all offices");
        return officeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Office findById(Long id) {
        LOGGER.debug("Finding office by id: " + id);
        return officeRepository.findOne(id);
    }

   

    
    public Office update(OfficeDTO updated) throws OfficeNotFoundException {
        LOGGER.debug("Updating office with information: " + updated);
        
        Office office = officeRepository.findOne(updated.getId());
        
        if (office == null) {
            LOGGER.debug("No office found with id: " + updated.getId());
            throw new OfficeNotFoundException();
        }
        
        
        office.setAlerteReponseCourrier(updated.getAlerteReponseCourrier());
        office.setCodeApe(updated.getCodeApe());
        office.setCodeCsn(updated.getCodeCsn());
        office.setDernierNumeroArchive(updated.getDernierNumeroArchive());
        office.setNom(updated.getNom());
        office.setNumeroAgree(updated.getNumeroAgree());
        office.setNumeroArchiveAuto(updated.getNumeroArchiveAuto());
        office.setNumeroCrpcen(updated.getNumeroCrpcen());
        office.setNumeroSiren(updated.getNumeroSiren());
        office.setNumeroTva(updated.getNumeroTva());
        office.setNumeroUrssaf(updated.getNumeroUrssaf());
        office.setPoidMaxMicen(updated.getPoidMaxMicen());
        office.setPoidMaxMicenAvecMentions(updated.getPoidMaxMicenAvecMentions());
        office.setPoidMaxMicenAvecMentionsCritique(updated.getPoidMaxMicenAvecMentionsCritique());
        office.setRepertoireNumeroContinu(updated.getRepertoireNumeroContinu());
        office.setServeurMicen(updated.getServeurMicen());
        office.setStatut(updated.getStatut());
        office.setVersionMetaSpecifiquesMicen(updated.getVersionMetaSpecifiquesMicen());
        office.setVersionXsdMicen(updated.getVersionXsdMicen());
        if(updated.getAdresseFk()!=null)
        {
        office.setAdresseFk(adresseOfficeRepository.findOne(updated.getAdresseFk()));
        }
        if(updated.getCoordonneeFk()!=null)
        {
        office.setCoordonneeFk(coordonneeRepository.findOne(updated.getCoordonneeFk()));
        }        officeRepository.save(office);
        Rib rib = new Rib();
        Annexe annexe = new Annexe();
        DocumentFichier document= new DocumentFichier();
        if(updated.getRibCollection()!=null)
        {
        for(Long ribId:updated.getRibCollection())
        {
        	rib = ribRepository.findOne(ribId);
        	rib.setOfficeFk(office);
    		ribRepository.save(rib);
        }
        }
        
        if(updated.getAnnexeCollection()!=null)
        {
        for(Long annexeId:updated.getAnnexeCollection())
        {
        	annexe = annexeRepository.findOne(annexeId);
        	annexe.setOfficeFk(office);
    		annexeRepository.save(annexe);
        }
        }
        
        if(updated.getDocumentFichierCollection()!=null)
        {
        for(Long docId:updated.getDocumentFichierCollection())
        {
        	document = documentFichierRepository.findOne(docId);
        	document.setOfficeFk(office);
    		documentFichierRepository.save(document);
        }
        }
        return office;
    }

    /**
     * This setter method should be used only by unit tests.
     * @param officeRepository
     */
    protected void setOfficeRepository(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }
}
