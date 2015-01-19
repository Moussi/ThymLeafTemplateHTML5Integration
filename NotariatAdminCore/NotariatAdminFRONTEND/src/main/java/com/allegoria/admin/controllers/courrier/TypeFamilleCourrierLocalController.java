package com.allegoria.admin.controllers.courrier;

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
import com.allegoria.admin.bl.dto.TypeFamilleCourrierLocalDTO;
import com.allegoria.admin.bl.office.OfficeNotFoundException;
import com.allegoria.admin.bl.office.OfficeService;
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleCourrierLocalNotFoundException;
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleCourrierLocalService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.office.AdresseOfficeRepository;
import com.allegoria.admin.dal.repositories.office.AnnexeRepository;
import com.allegoria.admin.dal.repositories.office.CoordonneeRepository;
import com.allegoria.admin.dal.repositories.office.DocumentFichierRepository;
import com.allegoria.admin.dal.repositories.office.RibRepository;
import com.allegoria.admin.dom.enums.ChoixServeurMicen;
import com.allegoria.admin.dom.enums.ChoixStatutOffice;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeFamilleCourrierLocal")
public class TypeFamilleCourrierLocalController extends AbstractController{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeFamilleCourrierLocalController.class);
	protected static final String TypeFamilleCourrierLocal_ADD_FORM_VIEW = "typeFamilleCourrierLocal/newtypeFamilleCourrierLocal.html";
	protected static final String TypeFamilleCourrierLocal_LIST_VIEW = "typeFamilleCourrierLocal/listetypeFamilleCourrierLocal.html";
	protected static final String TypeFamilleCourrierLocal_LIST = "/typeFamilleCourrierLocal/listetypeFamilleCourrierLocal.html";
	protected static final String TypeFamilleCourrierLocal_Edit_FORM_VIEW = "typeFamilleCourrierLocal/edittypeFamilleCourrierLocal.html";
	protected static final String MODEL_ATTIRUTE_TypeFamilleCourrierLocal = "typeFamilleCourrierLocal";
	protected static final String MODEL_ATTIRUTE_LIST_TypeFamilleCourrierLocal = "typeFamilleCourrierLocals";

	 protected static final String FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED = "feedback.message.typeFamilleCourrierLocal.created";
	
	
	
	@Autowired
	TypeFamilleCourrierLocalService typeFamilleCourrierLocalService;
	
	
	/**
	 * Create Office View 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String showCreateOfficeForm(Model model) {
		LOGGER.debug("Rendering create typeFamilleCourrierLocal form");
		//passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeFamilleCourrierLocal, new  TypeFamilleCourrierLocalDTO());
	
		
		return TypeFamilleCourrierLocal_ADD_FORM_VIEW;

	}
	
	/**
     * Processes the submissions of create typeFamilleCourrierLocal form.
     * @param created   The information of the created typeFamilleCourrierLocals.
     * @param bindingResult
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submitCreateOfficeForm(@ModelAttribute(MODEL_ATTIRUTE_TypeFamilleCourrierLocal)TypeFamilleCourrierLocalDTO typeFamilleCourrierLocal,BindingResult bindingResult, RedirectAttributes attributes) {
        LOGGER.debug("Create Office form was submitted with information: " + typeFamilleCourrierLocal);
        
       
        //System.out.println(adressetypeFamilleCourrierLocal);
        if (bindingResult.hasErrors()) {
            return TypeFamilleCourrierLocal_ADD_FORM_VIEW;
        }
                

        		//addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED, typeFamilleCourrierLocal.getNom());
        typeFamilleCourrierLocalService.create(typeFamilleCourrierLocal);
        
        return createRedirectViewPath(TypeFamilleCourrierLocal_LIST);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateOfficeForm(@ModelAttribute(MODEL_ATTIRUTE_TypeFamilleCourrierLocal)TypeFamilleCourrierLocalDTO typeFamilleCourrierLocal,BindingResult bindingResult, RedirectAttributes attributes) throws OfficeNotFoundException, TypeFamilleCourrierLocalNotFoundException {
        LOGGER.debug("Create Office form was submitted with information: " + typeFamilleCourrierLocal);
        
       
        System.out.println(typeFamilleCourrierLocal);
        if (bindingResult.hasErrors()) {
            return TypeFamilleCourrierLocal_Edit_FORM_VIEW;
        }
                

        		//addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED, typeFamilleCourrierLocal.getNom());
        typeFamilleCourrierLocalService.update(typeFamilleCourrierLocal);
        
        return createRedirectViewPath(TypeFamilleCourrierLocal_LIST);
    }
    /**
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id,Model model) {
		LOGGER.debug("Rendering edit typeFamilleCourrierLocal form");
		//passsage des paramètres
	
		model.addAttribute(MODEL_ATTIRUTE_TypeFamilleCourrierLocal, typeFamilleCourrierLocalService.findById(id));
		
		
		return TypeFamilleCourrierLocal_Edit_FORM_VIEW;

	}
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value="/listetypeFamilleCourrierLocal", method = RequestMethod.GET)
	public String showListOffice(Model model) {
		
    	model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleCourrierLocal,typeFamilleCourrierLocalService.findAll());
		return TypeFamilleCourrierLocal_LIST_VIEW;

	}
}
