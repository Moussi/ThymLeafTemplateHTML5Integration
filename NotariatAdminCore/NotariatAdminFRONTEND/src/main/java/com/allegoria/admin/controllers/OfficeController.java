package com.allegoria.admin.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.allegoria.admin.bl.dto.OfficeDTO;
import com.allegoria.admin.bl.office.OfficeNotFoundException;
import com.allegoria.admin.bl.office.OfficeService;
import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.AnnexeRepository;
import com.allegoria.admin.dal.repositories.office.CoordonneeRepository;
import com.allegoria.admin.dal.repositories.office.DocumentFichierRepository;
import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dom.enums.ChoixServeurMicen;
import com.allegoria.admin.dom.enums.ChoixStatutOffice;
import com.allegoria.admin.dom.office.AdresseOffice;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.office.Rib;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/office")
public class OfficeController extends AbstractController{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OfficeController.class);
	protected static final String OFFICE_ADD_FORM_VIEW = "office/newoffice.html";
	protected static final String OFFICE_LIST_VIEW = "office/listeoffice.html";
	protected static final String OFFICE_LIST = "/office/listeoffice.html";
	protected static final String OFFICE_Edit_FORM_VIEW = "office/editoffice.html";
	protected static final String MODEL_ATTIRUTE_OFFICE = "office";
	protected static final String MODEL_ATTIRUTE_LIST_OFFICE = "offices";
	protected static final String MODEL_ATTIRUTE_RIBS = "ribs";
	protected static final String MODEL_ATTIRUTE_DOCUMENTS = "documents";
	protected static final String MODEL_ATTIRUTE_ANNEXES = "annexes";
	protected static final String MODEL_ATTIRUTE_ADRESSE = "adresses";
	protected static final String MODEL_ATTIRUTE_COORDONNEE = "coordonnees";
	protected static final String MODEL_ATTIRUTE_CHOIX_SERVEUR_MICEN = "serveursmicen";
	protected static final String MODEL_ATTIRUTE_CHOIX_STATUT = "statuts";
	 protected static final String FEEDBACK_MESSAGE_KEY_OFFICE_CREATED = "feedback.message.office.created";
	
	
	@Autowired
	RibRepository ribRepository;
	@Autowired
	AnnexeRepository annexeRepository;
	@Autowired
	DocumentFichierRepository documentFichierRepository;
	@Autowired
	AdresseOfficeRepository adresseOfficeRepository;
	@Autowired
	CoordonneeRepository coordonneeRepository;
	@Autowired
	OfficeService officeService;
	
	
	/**
	 * Create Office View 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String showCreateOfficeForm(Model model) {
		LOGGER.debug("Rendering create office form");
		//passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_OFFICE, new OfficeDTO());
		model.addAttribute(MODEL_ATTIRUTE_RIBS, ribRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_DOCUMENTS, documentFichierRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_ANNEXES, annexeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_ADRESSE, adresseOfficeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_COORDONNEE, coordonneeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_SERVEUR_MICEN, ChoixServeurMicen.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_STATUT, ChoixStatutOffice.values());
		
		return OFFICE_ADD_FORM_VIEW;

	}
	
	/**
     * Processes the submissions of create office form.
     * @param created   The information of the created offices.
     * @param bindingResult
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submitCreateOfficeForm(@ModelAttribute(MODEL_ATTIRUTE_OFFICE)OfficeDTO office,BindingResult bindingResult, RedirectAttributes attributes) {
        LOGGER.debug("Create Office form was submitted with information: " + office);
        
       
        //System.out.println(adresseoffice);
        if (bindingResult.hasErrors()) {
            return OFFICE_ADD_FORM_VIEW;
        }
                

        		addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_OFFICE_CREATED, office.getNom());
        officeService.create(office);
        
        return createRedirectViewPath(OFFICE_LIST);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateOfficeForm(@ModelAttribute(MODEL_ATTIRUTE_OFFICE)OfficeDTO office,BindingResult bindingResult, RedirectAttributes attributes) throws OfficeNotFoundException {
        LOGGER.debug("Create Office form was submitted with information: " + office);
        
       
        System.out.println(office);
        if (bindingResult.hasErrors()) {
            return OFFICE_Edit_FORM_VIEW;
        }
                

        		addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_OFFICE_CREATED, office.getNom());
        officeService.update(office);
        
        return createRedirectViewPath(OFFICE_LIST);
    }
    /**
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id,Model model) {
		LOGGER.debug("Rendering edit office form");
		//passsage des paramètres
	
		model.addAttribute(MODEL_ATTIRUTE_OFFICE, officeService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_RIBS, ribRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_DOCUMENTS, documentFichierRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_ANNEXES, annexeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_ADRESSE, adresseOfficeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_COORDONNEE, coordonneeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_SERVEUR_MICEN, ChoixServeurMicen.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_STATUT, ChoixStatutOffice.values());
		
		return OFFICE_Edit_FORM_VIEW;

	}
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value="/listeoffice", method = RequestMethod.GET)
	public String showListOffice(Model model) {
		
    	model.addAttribute(MODEL_ATTIRUTE_LIST_OFFICE,officeService.findAll());
		return OFFICE_LIST_VIEW;

	}
}
