package com.allegoria.admin.bl.secretaire;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.dto.utilisateur.SecretaireDTO;
import com.allegoria.admin.dal.repositories.office.SecretaireRepository;
import com.allegoria.admin.dal.repositories.utilisateur.UtilisateurRepository;
import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.office.Secretaire;
import com.allegoria.admin.dom.office.Utilisateur;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositorySecretaireService implements SecretaireService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositorySecretaireService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private SecretaireRepository secretaireRepository;
   @Autowired
   private UtilisateurRepository utilisateurRepository;
	public SecretaireDTO create(SecretaireDTO created) {
		
		Secretaire secretaire = new Secretaire();
		 
		
		
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
		secretaire.setUtilisateur(utilisateur);
		
		
		//notaireRepository.save(notaire);
		utilisateurRepository.save(utilisateur);
		secretaireRepository.save(secretaire);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		secretaireRepository.delete(Id);
		 
	}

	public List<Secretaire> findAll() {
		// TODO Auto-generated method stub
		return secretaireRepository.findAll();
	}

	public Secretaire findById(Long id) {
		// TODO Auto-generated method stub
		return secretaireRepository.findOne(id);
	}

	public Secretaire update(Secretaire updated)
			throws NotFoundException {
		Secretaire notaire = secretaireRepository.findOne(updated.getId());
		if(notaire!=null)
		{
		secretaireRepository.save(notaire);
		}
		return updated;
	}
	
    
    
}
