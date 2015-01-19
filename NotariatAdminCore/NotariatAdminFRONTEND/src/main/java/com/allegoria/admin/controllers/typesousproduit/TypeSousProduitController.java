package com.allegoria.admin.controllers.typesousproduit;

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

import com.allegoria.admin.bl.dto.typeacte.TypeSousProduitDTO;
import com.allegoria.admin.bl.office.OfficeNotFoundException;
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleCourrierLocalNotFoundException;
import com.allegoria.admin.bl.typesousproduit.TypeSousProduitService;
import com.allegoria.admin.bl.typesousproduit.TypeTypeSousProduitNotFoundException;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typeacte.TypeActeRepository;
import com.allegoria.admin.dom.enums.ChoixCategorieSousProduit;
import com.allegoria.admin.dom.enums.ChoixDocumentPiece;
import com.allegoria.admin.dom.enums.ChoixEnteteSousProduit;
import com.allegoria.admin.dom.enums.ChoixModeleSignature;
import com.allegoria.admin.dom.enums.ChoixMultipliciteOccurrenceSousProduit;
import com.allegoria.admin.dom.enums.ChoixServeurMicen;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeSousProduit")
public class TypeSousProduitController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeSousProduitController.class);
	protected static final String TypeSousProduit_ADD_FORM_VIEW = "typeSousProduit/newtypeSousProduit.html";
	protected static final String TypeSousProduit_LIST_VIEW = "typeSousProduit/listetypeSousProduit.html";
	protected static final String TypeSousProduit_LIST = "/typeSousProduit/listetypeSousProduit.html";
	protected static final String TypeSousProduit_Edit_FORM_VIEW = "typeSousProduit/edittypeSousProduit.html";
	protected static final String MODEL_ATTIRUTE_TypeSousProduit = "typeSousProduit";
	protected static final String MODEL_ATTIRUTE_LIST_TypeSousProduit = "typeSousProduits";
	protected static final String MODEL_ATTIRUTE_LIST_TYPEACTES = "typeactes";
	protected static final String MODEL_ATTIRUTE_CHOIX_ENTETE = "entetes";
	protected static final String MODEL_ATTIRUTE_CHOIX_FAMILLE = "familles";
	protected static final String MODEL_ATTIRUTE_CHOIX_GENRE = "genres";
	protected static final String MODEL_ATTIRUTE_CHOIX_OCCURRENCE = "occurrences";
	protected static final String MODEL_ATTIRUTE_CHOIX_SIGNATUREPLANETE = "signatures";

	protected static final String FEEDBACK_MESSAGE_KEY_TypeSousProduit_CREATED = "feedback.message.typeSousProduit.created";

	@Autowired
	TypeSousProduitService typeSousProduitService;
	@Autowired
	TypeActeRepository typeActeRepository;
	/**
	 * Create Office View
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateOfficeForm(Model model) {
		LOGGER.debug("Rendering create typeSousProduit form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeSousProduit,
				new TypeSousProduitDTO());
		model.addAttribute(MODEL_ATTIRUTE_LIST_TYPEACTES,
				typeActeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_ENTETE, ChoixEnteteSousProduit.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_FAMILLE, ChoixCategorieSousProduit.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_GENRE, ChoixDocumentPiece.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_OCCURRENCE, ChoixMultipliciteOccurrenceSousProduit.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_SIGNATUREPLANETE, ChoixModeleSignature.values());
		

		return TypeSousProduit_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeSousProduit form.
	 * 
	 * @param created
	 *            The information of the created typeSousProduits.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeSousProduit) TypeSousProduitDTO typeSousProduit,
			BindingResult bindingResult, RedirectAttributes attributes,Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeSousProduit);

		 System.out.println(typeSousProduit);
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TYPEACTES,
					typeActeRepository.findAll());
			model.addAttribute(MODEL_ATTIRUTE_CHOIX_ENTETE, ChoixEnteteSousProduit.values());
			model.addAttribute(MODEL_ATTIRUTE_CHOIX_FAMILLE, ChoixCategorieSousProduit.values());
			model.addAttribute(MODEL_ATTIRUTE_CHOIX_GENRE, ChoixDocumentPiece.values());
			model.addAttribute(MODEL_ATTIRUTE_CHOIX_OCCURRENCE, ChoixMultipliciteOccurrenceSousProduit.values());
			model.addAttribute(MODEL_ATTIRUTE_CHOIX_SIGNATUREPLANETE, ChoixModeleSignature.values());
			return TypeSousProduit_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeSousProduit.getNom());
		typeSousProduitService.create(typeSousProduit);

		return createRedirectViewPath(TypeSousProduit_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeSousProduit) TypeSousProduitDTO typeSousProduit,
			BindingResult bindingResult, RedirectAttributes attributes, Model model)
			throws TypeTypeSousProduitNotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeSousProduit);
		
		System.out.println(typeSousProduit);
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TYPEACTES,
					typeActeRepository.findAll());
			return TypeSousProduit_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeSousProduit.getNom());
		typeSousProduitService.update(typeSousProduit);

		return createRedirectViewPath(TypeSousProduit_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeSousProduit form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeSousProduit,
				typeSousProduitService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_LIST_TYPEACTES,
				typeActeRepository.findAll());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_ENTETE, ChoixEnteteSousProduit.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_FAMILLE, ChoixCategorieSousProduit.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_GENRE, ChoixDocumentPiece.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_OCCURRENCE, ChoixMultipliciteOccurrenceSousProduit.values());
		model.addAttribute(MODEL_ATTIRUTE_CHOIX_SIGNATUREPLANETE, ChoixModeleSignature.values());
		return TypeSousProduit_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeSousProduit", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeSousProduit,
				typeSousProduitService.findAll());
		return TypeSousProduit_LIST_VIEW;

	}
}
