package com.allegoria.admin.bl.clerc;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.dto.utilisateur.ClercDTO;
import com.allegoria.admin.dal.repositories.office.ClercRepository;
import com.allegoria.admin.dal.repositories.utilisateur.UtilisateurRepository;
import com.allegoria.admin.dom.office.Clerc;
import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.office.Utilisateur;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryClercService implements ClercService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryClercService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private ClercRepository clercRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
   
	public ClercDTO create(ClercDTO created) {
		Clerc clerc = new Clerc();
		 
		clerc.setHabilite(created.getHabilite());
		clerc.setDateHabilitation(created.getDateGenerationMotPasse());
		
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setAccesExterieurAutorise(created.getAccesExterieurAutorise());
		utilisateur.setAccesSmartAutorise(created.getAccesSmartAutorise());
		utilisateur.setAcheve(created.getAcheve());
		utilisateur.setCode(created.getCode());
		utilisateur.setDateGenerationMotPasse(created.getDateGenerationMotPasse());
		utilisateur.setEmail(created.getEmail());
		utilisateur.setFax(created.getFax());
		utilisateur.setIdentifiantElectronique(created.getIdentifiantElectronique());
		utilisateur.setIdTransfert(created.getIdTransfert());
		utilisateur.setInfoMel(created.getInfoMel());
		utilisateur.setLigneDirecte(created.getLigneDirecte());
		utilisateur.setLogin(created.getLogin());
		utilisateur.setLoginComptaPretaxe(created.getLoginComptaPretaxe());
		utilisateur.setLoginComptaVisu(created.getLoginComptaVisu());
		utilisateur.setMotPasseGenere(created.getMotPasseGenere());
		utilisateur.setMailReplyTo(created.getMailReplyTo());
		utilisateur.setMailServersLogin(created.getMailServersLogin());
		utilisateur.setMailServersPassword(created.getMailServersPassword());
		utilisateur.setMdpComptaPretaxe(created.getMdpComptaPretaxe());
		utilisateur.setMdpComptaVisu(created.getMdpComptaVisu());
		utilisateur.setNom(created.getNom());
		utilisateur.setNumeroIMEI(created.getNumeroIMEI());
		utilisateur.setOfficiel(created.getOfficiel());
		utilisateur.setPopServerUrl(created.getPopServerUrl());
		utilisateur.setPrenom(created.getPrenom());
		utilisateur.setService(created.getService());
		utilisateur.setSignature(created.getSignature());
		utilisateur.setSignatureTexte(created.getSignatureTexte());
		utilisateur.setSmtpServerUrl(created.getSmtpServerUrl());
		utilisateur.setTelephonePortable(created.getTelephonePortable());
		utilisateur.setTitre(created.getTitre());
		utilisateur.setTitreAbrege(created.getTitreAbrege());
		clerc.setUtilisateur(utilisateur);
		
		//notaireRepository.save(notaire);
		utilisateurRepository.save(utilisateur);
		clercRepository.save(clerc);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		clercRepository.delete(Id);
		 
	}

	public List<Clerc> findAll() {
		// TODO Auto-generated method stub
		return clercRepository.findAll();
	}

	public Clerc findById(Long id) {
		// TODO Auto-generated method stub
		return clercRepository.findOne(id);
	}

	public Clerc update(Clerc updated)
			throws NotFoundException {
		Clerc clerc = clercRepository.findOne(updated.getId());
		if(clerc!=null)
		{
		clercRepository.save(clerc);
		}
		return updated;
	}
	
    
    
}
