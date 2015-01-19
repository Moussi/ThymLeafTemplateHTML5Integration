package com.allegoria.admin.controllers.typecomparant;

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
import com.allegoria.admin.bl.typeacte.TypeActeService;
import com.allegoria.admin.bl.typecomparant.TypeComparantService;
import com.allegoria.admin.bl.typedossier.TypeDossierService;
import com.allegoria.admin.bl.typepiece.TypePieceService;
import com.allegoria.admin.bl.typerelationcomparution.TypeRelationComparutionService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typerelationcomparution.TypeRelationComparutionRepository;
import com.allegoria.admin.dom.enums.ChoixDocumentPiece;
import com.allegoria.admin.dom.typeacte.TypeActe;
import com.allegoria.admin.dom.typeacte.TypeComparant;
import com.allegoria.admin.dom.typeacte.TypeRelationComparution;
import com.allegoria.admin.dom.typefamillecourrier.TypePiece;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeComparant")
public class TypeComparantController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeComparantController.class);
	protected static final String TypeComparant_ADD_FORM_VIEW = "typeComparant/newtypeComparant.html";
	protected static final String TypeComparant_LIST_VIEW = "typeComparant/listetypeComparant.html";
	protected static final String TypeComparant_LIST = "/typeComparant/listetypeComparant.html";
	protected static final String TypeComparant_Edit_FORM_VIEW = "typeComparant/edittypeComparant.html";
	protected static final String MODEL_ATTIRUTE_TypeComparant = "typeComparant";
	protected static final String MODEL_ATTIRUTE_LIST_TypeComparant = "typeComparants";
	protected static final String MODEL_ATTIRUTE_LIST_TypesPieces = "typesPieces";
	protected static final String MODEL_ATTIRUTE_LIST_TypesActes = "typesActes";
	protected static final String MODEL_ATTIRUTE_LIST_TypesRelations = "typesRelations";

	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeComparant_CREATED = "feedback.message.typeComparant.created";

	@Autowired
	TypeComparantService typeComparantService;
	@Autowired
	TypeDossierService typeDossierService;
	@Autowired
	TypePieceService typePieceService;
	@Autowired
	TypeActeService typeActeService;
	@Autowired
	TypeRelationComparutionService typeRelationComparutionService;
	
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

	
		
		binder.registerCustomEditor(Set.class, "typesActe",
				new CustomCollectionEditor(Set.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeActe typeActe = new TypeActe();

						if (element != null) {
							System.out.println(element.toString());

							typeActe.setId(Long
									.parseLong(element.toString()));
						}
						return typeActe;
					}
				});
		binder.registerCustomEditor(Set.class, "typesPieces",
				new CustomCollectionEditor(Set.class) {
			
			@Override
			protected Object convertElement(Object element) {
				TypePiece typePiece = new TypePiece();
				
				if (element != null) {
					System.out.println(element.toString());
					
					typePiece.setId(Long
							.parseLong(element.toString()));
				}
				return typePiece;
			}
		});
		binder.registerCustomEditor(Set.class, "typesRelation",
				new CustomCollectionEditor(Set.class) {
			
			@Override
			protected Object convertElement(Object element) {
				TypeRelationComparution typeRelationComparution = new TypeRelationComparution();
				
				if (element != null) {
					System.out.println(element.toString());
					
					typeRelationComparution.setId(Long
							.parseLong(element.toString()));
				}
				return typeRelationComparution;
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
		LOGGER.debug("Rendering create typeComparant form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeComparant, new TypeComparant());

		
		
		if (typeActeService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
					typeActeService.findAll());
		}
		if (typePieceService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesPieces,
					typePieceService.findAll());
		}
		if (typeRelationComparutionService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesRelations,
					typeRelationComparutionService.findAll());
		}
		
		

		return TypeComparant_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeComparant form.
	 * 
	 * @param created
	 *            The information of the created typeComparants.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeComparant) TypeComparant typeComparant,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create TypeComparant form was submitted with information: "
				+ typeComparant);

		System.out.println(bindingResult.toString());
		System.out.println(typeComparant);
		for(TypeActe typeActe:typeComparant.getTypesActe())
		{
			System.out.println(typeActe);
		}
		if (bindingResult.hasErrors()) {

			if (typeActeService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
						typeActeService.findAll());
			}
			if (typePieceService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesPieces,
						typePieceService.findAll());
			}
			if (typeRelationComparutionService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesRelations,
						typeRelationComparutionService.findAll());
			}
			return TypeComparant_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeComparantLocal_CREATED,
		// typeComparant.getNom());
		typeComparantService.create(typeComparant);

		return createRedirectViewPath(TypeComparant_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeComparant) TypeComparant typeComparant,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeComparant);

		System.out.println(typeComparant);
		if (bindingResult.hasErrors()) {
			if (typeActeService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
						typeActeService.findAll());
			}
			if (typePieceService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesPieces,
						typePieceService.findAll());
			}
			if (typeRelationComparutionService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesRelations,
						typeRelationComparutionService.findAll());
			}
			return TypeComparant_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeComparantLocal_CREATED,
		// typeComparant.getNom());
		typeComparantService.update(typeComparant);

		return createRedirectViewPath(TypeComparant_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeComparant form");
		// passsage des paramètres
		System.out.println(typeComparantService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_TypeComparant,
				typeComparantService.findById(id));
		
		if (typeActeService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
					typeActeService.findAll());
		}
		if (typePieceService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesPieces,
					typePieceService.findAll());
		}
		if (typeRelationComparutionService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesRelations,
					typeRelationComparutionService.findAll());
		}
		return TypeComparant_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeComparant", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparant,
				typeComparantService.findAll());
		return TypeComparant_LIST_VIEW;

	}
}
