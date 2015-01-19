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
import com.allegoria.admin.bl.dto.utilisateur.SecretaireDTO;
import com.allegoria.admin.bl.secretaire.SecretaireService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dom.office.Secretaire;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/secretaire")
public class SecretaireController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SecretaireController.class);
	protected static final String Secretaire_ADD_FORM_VIEW = "secretaire/newsecretaire.html";
	protected static final String Secretaire_LIST_VIEW = "secretaire/listesecretaire.html";
	protected static final String Secretaire_LIST = "/secretaire/listesecretaire.html";
	protected static final String Secretaire_Edit_FORM_VIEW = "secretaire/editsecretaire.html";
	protected static final String MODEL_ATTIRUTE_Secretaire = "secretaire";
	protected static final String MODEL_ATTIRUTE_LIST_Secretaire = "secretaires";

	protected static final String FEEDBACK_MESSAGE_KEY_Secretaire_CREATED = "feedback.message.secretaire.created";

	@Autowired
	SecretaireService secretaireService;
	

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
		LOGGER.debug("Rendering create secretaire form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_Secretaire, new SecretaireDTO());

		return Secretaire_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create secretaire form.
	 * 
	 * @param created
	 *            The information of the created secretaires.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_Secretaire) SecretaireDTO secretaire,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ secretaire);

		System.out.println(bindingResult.toString());
		System.out.println(secretaire);

		if (bindingResult.hasErrors()) {

			return Secretaire_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// secretaire.getNom());
		secretaireService.create(secretaire);

		return createRedirectViewPath(Secretaire_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_Secretaire) Secretaire secretaire,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ secretaire);

		System.out.println(secretaire);
		if (bindingResult.hasErrors()) {

			return Secretaire_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// secretaire.getNom());
		secretaireService.update(secretaire);

		return createRedirectViewPath(Secretaire_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit secretaire form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_Secretaire,
				secretaireService.findById(id));

		return Secretaire_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listesecretaire", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_Secretaire,
				secretaireService.findAll());
		return Secretaire_LIST_VIEW;

	}
}
