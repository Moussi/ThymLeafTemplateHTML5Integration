package com.allegoria.admin.bl.notaire;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.dto.utilisateur.NotaireDTO;
import com.allegoria.admin.dal.repositories.notaire.NotaireRepository;
import com.allegoria.admin.dal.repositories.utilisateur.UtilisateurRepository;
import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.office.Utilisateur;

/**
 * This implementation of the OfficeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Allégoria
 */
@Service
public class RepositoryNotaireService implements NotaireService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryNotaireService.class);

    protected static final int NUMBER_OF_PERSONS_PER_PAGE = 5;

    @Autowired
    private NotaireRepository notaireRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
   
	public NotaireDTO create(NotaireDTO created) {
		Notaire notaire = new Notaire();
		 
		notaire.setAssistant(created.getAssistant());
		notaire.setAssocie(created.getAssocie());
		notaire.setIdNotaireInstrumentaire(created.getIdNotaireInstrumentaire());
		notaire.setSalarie(created.getSalarie());
		
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
		notaire.setUtilisateur(utilisateur);
		utilisateur.setNotaire(notaire);
		
		//notaireRepository.save(notaire);
		utilisateurRepository.save(utilisateur);
		return created;
	}

	public void delete(Long Id)
			throws NotFoundException {
		// TODO Auto-generated method stub
		notaireRepository.delete(Id);
		 
	}

	public List<Notaire> findAll() {
		// TODO Auto-generated method stub
		return notaireRepository.findAll();
	}

	public Notaire findById(Long id) {
		// TODO Auto-generated method stub
		return notaireRepository.findOne(id);
	}

	public Notaire update(Notaire updated)
			throws NotFoundException {
		Notaire notaire = notaireRepository.findOne(updated.getId());
		if(notaire!=null)
		{
		notaireRepository.save(notaire);
		}
		return updated;
	}
	
    
    
}
