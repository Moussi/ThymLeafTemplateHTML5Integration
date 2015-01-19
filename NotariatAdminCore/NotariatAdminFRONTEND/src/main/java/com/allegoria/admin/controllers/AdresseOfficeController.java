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

import com.allegoria.admin.bl.dto.AdresseOfficeDTO;
import com.allegoria.admin.bl.dto.OfficeDTO;
import com.allegoria.admin.bl.office.AdresseOfficeNotFoundException;
import com.allegoria.admin.bl.office.AdresseOfficeService;
import com.allegoria.admin.bl.office.OfficeService;
import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.AnnexeRepository;
import com.allegoria.admin.dal.repositories.office.CoordonneeRepository;
import com.allegoria.admin.dal.repositories.office.DocumentFichierRepository;
import com.allegoria.admin.dal.repositories.office.OfficeRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dal.repositories.office.TopadRepository;
import com.allegoria.admin.dal.repositories.office.TypeVoieRepository;
import com.allegoria.admin.dom.enums.ChoixServeurMicen;
import com.allegoria.admin.dom.enums.ChoixStatutOffice;
import com.allegoria.admin.dom.office.AdresseOffice;
import com.allegoria.admin.dom.office.Office;
import com.allegoria.admin.dom.office.Rib;
import com.allegoria.admin.dom.office.Topad;
import com.allegoria.admin.dom.office.TypeVoie;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/adresseoffice")
public class AdresseOfficeController extends AbstractController{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdresseOfficeController.class);
	protected static final String ADRESS_OFFICE_ADD_FORM_VIEW = "adresseoffice/newadresseoffice.html";
	protected static final String ADRESS_OFFICE_LIST_VIEW = "adresseoffice/listeadresseoffice.html";
	protected static final String ADRESS_OFFICE_LIST = "/adresseoffice/listeadresseoffice.html";
	protected static final String ADRESS_OFFICE_Edit_FORM_VIEW = "adresseoffice/editadresseoffice.html";
	protected static final String MODEL_ATTIRUTE_ADRESS_OFFICE = "adresseoffice";
	protected static final String MODEL_ATTIRUTE_LIST_ADRESS_OFFICE = "adresseoffices";
	protected static final String MODEL_ATTIRUTE_TOPAD_LIST = "topads";
	protected static final String MODEL_ATTIRUTE_TYPEVOIE_LIST = "typeVoies";
	
	 protected static final String FEEDBACK_MESSAGE_KEY_OFFICE_CREATED = "feedback.message.adresseoffice.created";
	
	
	@Autowired
	AdresseOfficeService adresseofficeService;
	@Autowired
	TopadRepository topadRepository;
	@Autowired
	TypeVoieRepository typeVoieRepository;
	/**
	 * Create Office View 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String showCreateOfficeForm(Model model) {
		LOGGER.debug("Rendering create adresseoffice form");
		
		//passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_ADRESS_OFFICE, new AdresseOfficeDTO());
		if(topadRepository.findAll()!=null)
		{
		model.addAttribute(MODEL_ATTIRUTE_TOPAD_LIST, topadRepository.findAll());
		}
		if(typeVoieRepository.findAll()!=null)
		{
		model.addAttribute(MODEL_ATTIRUTE_TYPEVOIE_LIST, typeVoieRepository.findAll());
		}
		
		return ADRESS_OFFICE_ADD_FORM_VIEW;

	}
	
	/**
     * Processes the submissions of create adresseoffice form.
     * @param created   The information of the created adresseoffices.
     * @param bindingResult
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submitCreateOfficeForm(@ModelAttribute(MODEL_ATTIRUTE_ADRESS_OFFICE)AdresseOfficeDTO adresseoffice,BindingResult bindingResult, RedirectAttributes attributes) {
        LOGGER.debug("Create Office form was submitted with information: " + adresseoffice);
        
       
        System.out.println(adresseoffice);
        if (bindingResult.hasErrors()) {
            return ADRESS_OFFICE_ADD_FORM_VIEW;
        }
                

       //addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_OFFICE_CREATED, adresseoffice.getId());
       adresseofficeService.create(adresseoffice);
        
        return createRedirectViewPath("/adresseoffice/listeadresseoffice.html");
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateOfficeForm(@ModelAttribute(MODEL_ATTIRUTE_ADRESS_OFFICE)AdresseOfficeDTO adresseoffice,BindingResult bindingResult, RedirectAttributes attributes,Model model) throws AdresseOfficeNotFoundException {
        LOGGER.debug("Create Office form was submitted with information: " + adresseoffice);
        
       
        System.out.println(bindingResult.toString());
        if (bindingResult.hasErrors()) {
        	if(topadRepository.findAll()!=null)
    		{
    		model.addAttribute(MODEL_ATTIRUTE_TOPAD_LIST, topadRepository.findAll());
    		}
    		if(typeVoieRepository.findAll()!=null)
    		{
    		model.addAttribute(MODEL_ATTIRUTE_TYPEVOIE_LIST, typeVoieRepository.findAll());
    		}
            return ADRESS_OFFICE_Edit_FORM_VIEW;
        }
                

        		//addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_OFFICE_CREATED, adresseoffice.getId());
       adresseofficeService.update(adresseoffice);
        
        return createRedirectViewPath(ADRESS_OFFICE_LIST);
    }
    /**
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id,Model model) {
		LOGGER.debug("Rendering edit adresseoffice form");
		//passsage des paramètres
	
		model.addAttribute(MODEL_ATTIRUTE_ADRESS_OFFICE, adresseofficeService.findById(id));
		if(topadRepository.findAll()!=null)
		{
		model.addAttribute(MODEL_ATTIRUTE_TOPAD_LIST, topadRepository.findAll());
		}
		if(typeVoieRepository.findAll()!=null)
		{
		model.addAttribute(MODEL_ATTIRUTE_TYPEVOIE_LIST, typeVoieRepository.findAll());
		}
		
		return ADRESS_OFFICE_Edit_FORM_VIEW;

	}
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value="/listeadresseoffice", method = RequestMethod.GET)
	public String showListOffice(Model model) {
		
    	model.addAttribute(MODEL_ATTIRUTE_LIST_ADRESS_OFFICE,adresseofficeService.findAll());
		return ADRESS_OFFICE_LIST;

	}
}
