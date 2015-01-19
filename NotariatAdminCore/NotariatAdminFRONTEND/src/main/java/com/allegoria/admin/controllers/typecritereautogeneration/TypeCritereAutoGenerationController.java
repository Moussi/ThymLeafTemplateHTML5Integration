package com.allegoria.admin.controllers.typecritereautogeneration;

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

import com.allegoria.admin.bl.typecritereautogeneration.TypeCritereAutoGenerationNotFoundException;
import com.allegoria.admin.bl.typecritereautogeneration.TypeCritereAutoGenerationService;
import com.allegoria.admin.controllers.AbstractController;

import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeCritereAutoGeneration")
public class TypeCritereAutoGenerationController extends AbstractController{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeCritereAutoGenerationController.class);
	protected static final String ADRESS_TypeCritereAutoGeneration_ADD_FORM_VIEW = "typeCritereAutoGeneration/newtypeCritereAutoGeneration.html";
	protected static final String ADRESS_TypeCritereAutoGeneration_LIST_VIEW = "typeCritereAutoGeneration/listetypeCritereAutoGeneration.html";
	protected static final String ADRESS_TypeCritereAutoGeneration_LIST = "/typeCritereAutoGeneration/listetypeCritereAutoGeneration.html";
	protected static final String ADRESS_TypeCritereAutoGeneration_Edit_FORM_VIEW = "typeCritereAutoGeneration/edittypeCritereAutoGeneration.html";
	protected static final String MODEL_ATTIRUTE_ADRESS_TypeCritereAutoGeneration = "typeCritereAutoGeneration";
	protected static final String MODEL_ATTIRUTE_LIST_ADRESS_TypeCritereAutoGeneration = "typeCritereAutoGenerations";
	protected static final String MODEL_ATTIRUTE_TOPAD_LIST = "topads";
	protected static final String MODEL_ATTIRUTE_TYPEVOIE_LIST = "typeVoies";
	
	 protected static final String FEEDBACK_MESSAGE_KEY_TypeCritereAutoGeneration_CREATED = "feedback.message.typeCritereAutoGeneration.created";
	
	
	@Autowired
	TypeCritereAutoGenerationService typeCritereAutoGenerationService;
	
	/**
	 * Create TypeCritereAutoGeneration View 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String showCreateTypeCritereAutoGenerationForm(Model model) {
		LOGGER.debug("Rendering create typeCritereAutoGeneration form");
		
		//passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_ADRESS_TypeCritereAutoGeneration, new TypeCritereAutoGeneration());
		
		
		return ADRESS_TypeCritereAutoGeneration_ADD_FORM_VIEW;

	}
	
	/**
     * Processes the submissions of create typeCritereAutoGeneration form.
     * @param created   The information of the created typeCritereAutoGenerations.
     * @param bindingResult
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submitCreateTypeCritereAutoGenerationForm(@ModelAttribute(MODEL_ATTIRUTE_ADRESS_TypeCritereAutoGeneration)TypeCritereAutoGeneration typeCritereAutoGeneration,BindingResult bindingResult, RedirectAttributes attributes) {
        LOGGER.debug("Create TypeCritereAutoGeneration form was submitted with information: " + typeCritereAutoGeneration);
        
       
        System.out.println(typeCritereAutoGeneration);
        if (bindingResult.hasErrors()) {
            return ADRESS_TypeCritereAutoGeneration_ADD_FORM_VIEW;
        }
                

       //addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_TypeCritereAutoGeneration_CREATED, typeCritereAutoGeneration.getId());
       typeCritereAutoGenerationService.create(typeCritereAutoGeneration);
        
        return createRedirectViewPath("/typeCritereAutoGeneration/listetypeCritereAutoGeneration.html");
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdateTypeCritereAutoGenerationForm(@ModelAttribute(MODEL_ATTIRUTE_ADRESS_TypeCritereAutoGeneration)TypeCritereAutoGeneration typeCritereAutoGeneration,BindingResult bindingResult, RedirectAttributes attributes,Model model) throws TypeCritereAutoGenerationNotFoundException {
        LOGGER.debug("Create TypeCritereAutoGeneration form was submitted with information: " + typeCritereAutoGeneration);
        
       
        System.out.println(bindingResult.toString());
        if (bindingResult.hasErrors()) {
        	
            return ADRESS_TypeCritereAutoGeneration_Edit_FORM_VIEW;
        }
                

        		//addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_TypeCritereAutoGeneration_CREATED, typeCritereAutoGeneration.getId());
       typeCritereAutoGenerationService.update(typeCritereAutoGeneration);
        
        return createRedirectViewPath(ADRESS_TypeCritereAutoGeneration_LIST);
    }
    /**
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String showEditTypeCritereAutoGenerationForm(@PathVariable("id") Long id,Model model) {
		LOGGER.debug("Rendering edit typeCritereAutoGeneration form");
		//passsage des paramètres
	
		model.addAttribute(MODEL_ATTIRUTE_ADRESS_TypeCritereAutoGeneration, typeCritereAutoGenerationService.findById(id));
		
		
		return ADRESS_TypeCritereAutoGeneration_Edit_FORM_VIEW;

	}
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value="/listetypeCritereAutoGeneration", method = RequestMethod.GET)
	public String showListTypeCritereAutoGeneration(Model model) {
		
    	model.addAttribute(MODEL_ATTIRUTE_LIST_ADRESS_TypeCritereAutoGeneration,typeCritereAutoGenerationService.findAll());
		return ADRESS_TypeCritereAutoGeneration_LIST;

	}
}
