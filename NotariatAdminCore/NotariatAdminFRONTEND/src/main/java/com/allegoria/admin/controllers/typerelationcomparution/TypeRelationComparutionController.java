package com.allegoria.admin.controllers.typerelationcomparution;

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
import com.allegoria.admin.dom.typeacte.TypeRelationComparution;
import com.allegoria.admin.dom.typefamillecourrier.TypePiece;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeRelationComparution")
public class TypeRelationComparutionController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeRelationComparutionController.class);
	protected static final String TypeRelationComparution_ADD_FORM_VIEW = "typeRelationComparution/newtypeRelationComparution.html";
	protected static final String TypeRelationComparution_LIST_VIEW = "typeRelationComparution/listetypeRelationComparution.html";
	protected static final String TypeRelationComparution_LIST = "/typeRelationComparution/listetypeRelationComparution.html";
	protected static final String TypeRelationComparution_Edit_FORM_VIEW = "typeRelationComparution/edittypeRelationComparution.html";
	protected static final String MODEL_ATTIRUTE_TypeRelationComparution = "typeRelationComparution";
	protected static final String MODEL_ATTIRUTE_LIST_TypeRelationComparution = "typeRelationComparutions";
	protected static final String MODEL_ATTIRUTE_LIST_TypesActes = "typesActes";
	protected static final String MODEL_ATTIRUTE_LIST_TypesComparants = "typesComparants";

	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeRelationComparution_CREATED = "feedback.message.typeRelationComparution.created";

	@Autowired
	TypeRelationComparutionService typeRelationComparutionService;
	@Autowired
	TypeActeService typeActeService;
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
		LOGGER.debug("Rendering create typeRelationComparution form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeRelationComparution, new TypeRelationComparution());

		
		
		if (typeActeService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
					typeActeService.findAll());
		}
		if (typeComparantService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
					typeComparantService.findAll());
		}
		
		

		return TypeRelationComparution_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeRelationComparution form.
	 * 
	 * @param created
	 *            The information of the created typeRelationComparutions.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeRelationComparution) TypeRelationComparution typeRelationComparution,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create TypeRelationComparution form was submitted with information: "
				+ typeRelationComparution);

		System.out.println(bindingResult.toString());
		System.out.println(typeRelationComparution);
		for(TypeActe typeActe:typeRelationComparution.getTypesActe())
		{
			System.out.println(typeActe);
		}
		if (bindingResult.hasErrors()) {

			if (typeActeService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
						typeActeService.findAll());
			}
			if (typeComparantService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
						typeComparantService.findAll());
			}
			return TypeRelationComparution_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeRelationComparutionLocal_CREATED,
		// typeRelationComparution.getNom());
		typeRelationComparutionService.create(typeRelationComparution);

		return createRedirectViewPath(TypeRelationComparution_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeRelationComparution) TypeRelationComparution typeRelationComparution,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeRelationComparution);

		System.out.println(typeRelationComparution);
		if (bindingResult.hasErrors()) {
			if (typeActeService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
						typeActeService.findAll());
			}
			if (typeComparantService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
						typeComparantService.findAll());
			}
			return TypeRelationComparution_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeRelationComparutionLocal_CREATED,
		// typeRelationComparution.getNom());
		typeRelationComparutionService.update(typeRelationComparution);

		return createRedirectViewPath(TypeRelationComparution_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeRelationComparution form");
		// passsage des paramètres
		System.out.println(typeRelationComparutionService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_TypeRelationComparution,
				typeRelationComparutionService.findById(id));
		
		if (typeActeService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesActes,
					typeActeService.findAll());
		}
		if (typeComparantService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypesComparants,
					typeComparantService.findAll());
		}
		return TypeRelationComparution_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeRelationComparution", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeRelationComparution,
				typeRelationComparutionService.findAll());
		return TypeRelationComparution_LIST_VIEW;

	}
}
