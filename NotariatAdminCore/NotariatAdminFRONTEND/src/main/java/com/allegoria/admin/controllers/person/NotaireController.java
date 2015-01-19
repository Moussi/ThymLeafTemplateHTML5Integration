package com.allegoria.admin.controllers.person;

import java.beans.PropertyEditorSupport;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.dto.utilisateur.NotaireDTO;
import com.allegoria.admin.bl.notaire.NotaireService;
import com.allegoria.admin.bl.typecritereautogeneration.TypeCritereAutoGenerationService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typecritereautogeneration.TypeCritereAutoGenerationRepository;
import com.allegoria.admin.dom.enums.ChoixDocumentOffice;
import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;


/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/notaire")
public class NotaireController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NotaireController.class);
	protected static final String Notaire_ADD_FORM_VIEW = "notaire/newnotaire.html";
	protected static final String Notaire_LIST_VIEW = "notaire/listenotaire.html";
	protected static final String Notaire_LIST = "/notaire/listenotaire.html";
	protected static final String Notaire_Edit_FORM_VIEW = "notaire/editnotaire.html";
	protected static final String MODEL_ATTIRUTE_Notaire = "notaire";
	protected static final String MODEL_ATTIRUTE_LIST_Notaire = "notaires";
	
	
	protected static final String FEEDBACK_MESSAGE_KEY_Notaire_CREATED = "feedback.message.notaire.created";

	@Autowired
	NotaireService notaireService;
	
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
		LOGGER.debug("Rendering create notaire form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_Notaire, new NotaireDTO());

		
		

		return Notaire_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create notaire form.
	 * 
	 * @param created
	 *            The information of the created notaires.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_Notaire) NotaireDTO notaire,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ notaire);

		System.out.println(bindingResult.toString());
		System.out.println(notaire);
		
		if (bindingResult.hasErrors()) {
			
			return Notaire_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// notaire.getNom());
		notaireService.create(notaire);

		return createRedirectViewPath(Notaire_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_Notaire) Notaire notaire,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ notaire);

		System.out.println(notaire);
		if (bindingResult.hasErrors()) {
			
			return Notaire_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// notaire.getNom());
		notaireService.update(notaire);

		return createRedirectViewPath(Notaire_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit notaire form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_Notaire,
				notaireService.findById(id));
		
		
		
		return Notaire_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listenotaire", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_Notaire,
				notaireService.findAll());
		return Notaire_LIST_VIEW;

	}
}
