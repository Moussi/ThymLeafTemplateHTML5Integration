package com.allegoria.admin.controllers.typepiece;

import java.util.Set;

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
import com.allegoria.admin.bl.typecomparant.TypeComparantService;
import com.allegoria.admin.bl.typedossier.TypeDossierService;
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleCourrierService;
import com.allegoria.admin.bl.typepiece.TypePieceService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dom.dossier.TypeDossier;
import com.allegoria.admin.dom.enums.ChoixDocumentPiece;
import com.allegoria.admin.dom.typeacte.TypeComparant;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypePiece;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typePiece")
public class TypePieceController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypePieceController.class);
	protected static final String TypePiece_ADD_FORM_VIEW = "typePiece/newtypePiece.html";
	protected static final String TypePiece_LIST_VIEW = "typePiece/listetypePiece.html";
	protected static final String TypePiece_LIST = "/typePiece/listetypePiece.html";
	protected static final String TypePiece_Edit_FORM_VIEW = "typePiece/edittypePiece.html";
	protected static final String MODEL_ATTIRUTE_TypePiece = "typePiece";
	protected static final String MODEL_ATTIRUTE_LIST_TypePiece = "typePieces";
	protected static final String MODEL_ATTIRUTE_LIST_TypesComparants = "typesComparants";
	protected static final String MODEL_ATTIRUTE_LIST_TypesDossiers = "typesDossiers";
	protected static final String MODEL_ATTIRUTE_LIST_GENRE = "genres";

	
	protected static final String FEEDBACK_MESSAGE_KEY_TypePiece_CREATED = "feedback.message.typePiece.created";

	@Autowired
	TypePieceService typePieceService;
	@Autowired
	TypeDossierService typeDossierService;
	@Autowired
	TypeComparantService typeComparantService;
	
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

	
		
		binder.registerCustomEditor(Set.class, "typesDossiers",
				new CustomCollectionEditor(Set.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeDossier typeDossier = new TypeDossier();

						if (element != null) {
							System.out.println(element.toString());

							typeDossier.setId(Long
									.parseLong(element.toString()));
						}
						return typeDossier;
					}
				});
		binder.registerCustomEditor(Set.class, "typesComparants",
				new CustomCollectionEditor(Set.class) {
			
			@Override
			protected Object convertElement(Object element) {
				TypeComparant typeComparant = new TypeComparant();
				
				if (element != null) {
					System.out.println(element.toString());
					
					typeComparant.setId(Long
							.parseLong(element.toString()));
				}
				return typeComparant;
			}
		});
		
	}

	/**
	 * Create Office View
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateOfficeForm(Model model) {
		LOGGER.debug("Rendering create typePiece form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypePiece, new TypePiece());

		
		
		if (typeDossierService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesDossiers,
					typeDossierService.findAll());
		}
		if (typeComparantService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
					typeComparantService.findAll());
		}
		if (typeComparantService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
					ChoixDocumentPiece.values());
		}
		
		

		return TypePiece_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typePiece form.
	 * 
	 * @param created
	 *            The information of the created typePieces.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypePiece) TypePiece typePiece,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create TypePiece form was submitted with information: "
				+ typePiece);

		System.out.println(bindingResult.toString());
		System.out.println(typePiece);
		for(TypeComparant typeComparant:typePiece.getTypesComparants())
		{
			System.out.println(typeComparant);
		}
		if (bindingResult.hasErrors()) {

			if (typeDossierService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesDossiers,
						typeDossierService.findAll());
			}
			if (typeComparantService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
						typeComparantService.findAll());
			}
			if (typeComparantService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
						ChoixDocumentPiece.values());
			}
			return TypePiece_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypePieceLocal_CREATED,
		// typePiece.getNom());
		typePieceService.create(typePiece);

		return createRedirectViewPath(TypePiece_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypePiece) TypePiece typePiece,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typePiece);

		System.out.println(typePiece);
		if (bindingResult.hasErrors()) {
			if (typeDossierService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesDossiers,
						typeDossierService.findAll());
			}
			if (typeComparantService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
						typeComparantService.findAll());
			}
			if (typeComparantService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
						ChoixDocumentPiece.values());
			}
			return TypePiece_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypePieceLocal_CREATED,
		// typePiece.getNom());
		typePieceService.update(typePiece);

		return createRedirectViewPath(TypePiece_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typePiece form");
		// passsage des paramètres
		System.out.println(typePieceService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_TypePiece,
				typePieceService.findById(id));
		
		if (typeDossierService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesDossiers,
					typeDossierService.findAll());
		}
		if (typeComparantService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
					typeComparantService.findAll());
		}
		if (typeComparantService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
					ChoixDocumentPiece.values());
		}
		return TypePiece_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypePiece", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypePiece,
				typePieceService.findAll());
		return TypePiece_LIST_VIEW;

	}
}
