package com.allegoria.admin.bl.office;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allegoria.admin.bl.dto.AdresseOfficeDTO;
import com.allegoria.admin.bl.dto.OfficeDTO;
import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.AnnexeRepository;
import com.allegoria.admin.dal.repositories.office.CoordonneeRepository;
import com.allegoria.admin.dal.repositories.office.DocumentFichierRepository;
import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dal.repositories.office.TopadRepository;
import com.allegoria.admin.dal.repositories.office.TypeVoieRepository;
import com.allegoria.admin.dom.office.AdresseOffice;
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
public class RepositoryAdresseOfficeService implements AdresseOfficeService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryAdresseOfficeService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    
    @Autowired
    private AdresseOfficeRepository adresseOfficeRepository;
    @Autowired
    private CoordonneeRepository coordonneeRepository;
    @Autowired
    private RibRepository ribRepository;
    @Autowired
    private TypeVoieRepository typeVoieRepository;
    @Autowired
    private TopadRepository topadRepository;
    
    
    public AdresseOffice create(AdresseOfficeDTO created) {
        LOGGER.debug("Creating a new office with information: " + created);
        AdresseOffice adresseOffice = new AdresseOffice();
        adresseOffice.setBatiment(created.getBatiment());
        adresseOffice.setAcheve(created.getAcheve());
        adresseOffice.setBoitePostale(created.getBoitePostale());
        adresseOffice.setDateAcheve(created.getDateAcheve());
        adresseOffice.setEscalier(created.getEscalier());
        adresseOffice.setEtage(created.getEtage());
        adresseOffice.setGps(created.getGps());
        adresseOffice.setLieudit(created.getLieudit());
        adresseOffice.setLitteral(created.getLitteral());
        adresseOffice.setModifieLe(created.getModifieLe());
        adresseOffice.setNomVoie(created.getNomVoie());
        adresseOffice.setNumeroVoie(created.getNumeroVoie());
        adresseOffice.setOrdreVoie(created.getOrdreVoie());
        adresseOffice.setResidence(created.getResidence());
        if(created.getTopadFk()!=null)
        {
        if(topadRepository.findOne(created.getTopadFk())!=null)
        {
        adresseOffice.setTopadFk(topadRepository.findOne(created.getTopadFk()));
        }
        }
        if(created.getTypeVoieFk()!=null)
        {
        if(typeVoieRepository.findOne(created.getTypeVoieFk())!=null)
        {
        adresseOffice.setTypeVoieFk(typeVoieRepository.findOne(created.getTypeVoieFk()));
        }
        }
        adresseOffice.setVilleCedex(created.getVilleCedex());
        adresseOfficeRepository.save(adresseOffice);
        return adresseOffice;
    }

   

    @Transactional(rollbackFor = AdresseOfficeNotFoundException.class)
    public AdresseOffice delete(Long adresseofficeId) throws AdresseOfficeNotFoundException {
        LOGGER.debug("Deleting office with id: " + adresseofficeId);
        
        	AdresseOffice deleted = adresseOfficeRepository.findOne(adresseofficeId);
        
        if (deleted == null) {
            LOGGER.debug("No adresse office found with id: " + adresseofficeId);
            throw new AdresseOfficeNotFoundException();
        }
        
        adresseOfficeRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public List<AdresseOffice> findAll() {
        LOGGER.debug("Finding all adresse offices");
        return adresseOfficeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AdresseOffice findById(Long id) {
        LOGGER.debug("Finding adresse office by id: " + id);
        return adresseOfficeRepository.findOne(id);
    }

   

   
    public AdresseOffice update(AdresseOfficeDTO updated) throws AdresseOfficeNotFoundException {
    	LOGGER.debug("Creating a new office with information: " + updated);
       
        
        AdresseOffice adresseOffice = adresseOfficeRepository.findOne(updated.getId());
        
        if (adresseOffice == null) {
            LOGGER.debug("No adresse office found with id: " + updated.getId());
            throw new AdresseOfficeNotFoundException();
        }
        
        
        
        adresseOffice.setBatiment(updated.getBatiment());
        adresseOffice.setAcheve(updated.getAcheve());
        adresseOffice.setBoitePostale(updated.getBoitePostale());
        adresseOffice.setDateAcheve(updated.getDateAcheve());
        adresseOffice.setEscalier(updated.getEscalier());
        adresseOffice.setEtage(updated.getEtage());
        adresseOffice.setGps(updated.getGps());
        adresseOffice.setLieudit(updated.getLieudit());
        adresseOffice.setLitteral(updated.getLitteral());
        adresseOffice.setModifieLe(updated.getModifieLe());
        adresseOffice.setNomVoie(updated.getNomVoie());
        adresseOffice.setNumeroVoie(updated.getNumeroVoie());
        adresseOffice.setOrdreVoie(updated.getOrdreVoie());
        adresseOffice.setResidence(updated.getResidence());
        if(updated.getTopadFk()!=null)
        {
        if(topadRepository.findOne(updated.getTopadFk())!=null)
        {
        adresseOffice.setTopadFk(topadRepository.findOne(updated.getTopadFk()));
        }
        }
        if(updated.getTypeVoieFk()!=null)
        {
        if(typeVoieRepository.findOne(updated.getTypeVoieFk())!=null)
        {
        adresseOffice.setTypeVoieFk(typeVoieRepository.findOne(updated.getTypeVoieFk()));
        }
        }
        adresseOffice.setVilleCedex(updated.getVilleCedex());
        adresseOfficeRepository.save(adresseOffice);
        return adresseOffice;
        
    }

    /**
     * This setter method should be used only by unit tests.
     * @param adresseofficeRepository
     */
    protected void setOfficeRepository(AdresseOfficeRepository adresseofficeRepository) {
        this.adresseOfficeRepository = adresseofficeRepository;
    }
}
