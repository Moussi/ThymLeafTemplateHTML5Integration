package com.allegoria.admin.controllers.person;

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

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.clerc.ClercService;
import com.allegoria.admin.bl.dto.utilisateur.ClercDTO;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dom.office.Clerc;


/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/clerc")
public class ClercController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ClercController.class);
	protected static final String Clerc_ADD_FORM_VIEW = "clerc/newclerc.html";
	protected static final String Clerc_LIST_VIEW = "clerc/listeclerc.html";
	protected static final String Clerc_LIST = "/clerc/listeclerc.html";
	protected static final String Clerc_Edit_FORM_VIEW = "clerc/editclerc.html";
	protected static final String MODEL_ATTIRUTE_Clerc = "clerc";
	protected static final String MODEL_ATTIRUTE_LIST_Clerc = "clercs";
	
	
	protected static final String FEEDBACK_MESSAGE_KEY_Clerc_CREATED = "feedback.message.clerc.created";

	@Autowired
	ClercService clercService;
	
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	

	/**
	 * Create Office View
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateOfficeForm(Model model) {
		LOGGER.debug("Rendering create clerc form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_Clerc, new ClercDTO());

		
		

		return Clerc_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create clerc form.
	 * 
	 * @param created
	 *            The information of the created clercs.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_Clerc) ClercDTO clerc,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ clerc);

		System.out.println(bindingResult.toString());
		System.out.println(clerc);
		
		if (bindingResult.hasErrors()) {
			
			return Clerc_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// clerc.getNom());
		clercService.create(clerc);

		return createRedirectViewPath(Clerc_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_Clerc) Clerc clerc,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ clerc);

		System.out.println(clerc);
		if (bindingResult.hasErrors()) {
			
			return Clerc_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// clerc.getNom());
		clercService.update(clerc);

		return createRedirectViewPath(Clerc_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit clerc form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_Clerc,
				clercService.findById(id));
		
		
		
		return Clerc_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listeclerc", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_Clerc,
				clercService.findAll());
		return Clerc_LIST_VIEW;

	}
}
