package com.allegoria.admin.controllers.courrier;

import java.beans.PropertyEditorSupport;
import java.util.Collection;
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
import com.allegoria.admin.bl.typecourrier.TypeCourrierService;
import com.allegoria.admin.bl.typecritereautogeneration.TypeCritereAutoGenerationService;
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleCourrierService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typecritereautogeneration.TypeCritereAutoGenerationRepository;
import com.allegoria.admin.dom.enums.ChoixDocumentOffice;
import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleCourrier;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeFamilleCourrier")
public class TypeFamilleCourrierController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeFamilleCourrierController.class);
	protected static final String TypeFamilleCourrier_ADD_FORM_VIEW = "typeFamilleCourrier/newtypeFamilleCourrier.html";
	protected static final String TypeFamilleCourrier_LIST_VIEW = "typeFamilleCourrier/listetypeFamilleCourrier.html";
	protected static final String TypeFamilleCourrier_LIST = "/typeFamilleCourrier/listetypeFamilleCourrier.html";
	protected static final String TypeFamilleCourrier_Edit_FORM_VIEW = "typeFamilleCourrier/edittypeFamilleCourrier.html";
	protected static final String MODEL_ATTIRUTE_TypeFamilleCourrier = "typeFamilleCourrier";
	protected static final String MODEL_ATTIRUTE_LIST_TypeFamilleCourrier = "typeFamilleCourriers";
	protected static final String MODEL_ATTIRUTE_LIST_TypeCourrier = "typeCourriers";

	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeFamilleCourrier_CREATED = "feedback.message.typeFamilleCourrier.created";

	@Autowired
	TypeFamilleCourrierService typeFamilleCourrierService;
	@Autowired
	TypeCourrierService typeCourrierService;
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

	
		
		binder.registerCustomEditor(Set.class, "typeCourriers",
				new CustomCollectionEditor(Set.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeCourrier typeCourrier = new TypeCourrier();

						if (element != null) {
							System.out.println(element.toString());

							typeCourrier.setId(Long
									.parseLong(element.toString()));
						}
						return typeCourrier;
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
		LOGGER.debug("Rendering create typeFamilleCourrier form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeFamilleCourrier, new TypeFamilleCourrier());

		
		
		if (typeCourrierService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
					typeCourrierService.findAll());
		}
		
		

		return TypeFamilleCourrier_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeFamilleCourrier form.
	 * 
	 * @param created
	 *            The information of the created typeFamilleCourriers.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeFamilleCourrier) TypeFamilleCourrier typeFamilleCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeFamilleCourrier);

		System.out.println(bindingResult.toString());
		System.out.println(typeFamilleCourrier);
		for(TypeCourrier typeCourrier:typeFamilleCourrier.getTypeCourriers())
		{
			System.out.println(typeCourrier);
		}
		if (bindingResult.hasErrors()) {

			if (typeCourrierService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
						typeCourrierService.findAll());
			}
			return TypeFamilleCourrier_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeFamilleCourrier.getNom());
		typeFamilleCourrierService.create(typeFamilleCourrier);

		return createRedirectViewPath(TypeFamilleCourrier_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeFamilleCourrier) TypeFamilleCourrier typeFamilleCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeFamilleCourrier);

		System.out.println(typeFamilleCourrier);
		if (bindingResult.hasErrors()) {
			if (typeCourrierService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
						typeCourrierService.findAll());
			}
			return TypeFamilleCourrier_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeFamilleCourrier.getNom());
		typeFamilleCourrierService.update(typeFamilleCourrier);

		return createRedirectViewPath(TypeFamilleCourrier_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeFamilleCourrier form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeFamilleCourrier,
				typeFamilleCourrierService.findById(id));
		if (typeCourrierService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
					typeCourrierService.findAll());
		}
		return TypeFamilleCourrier_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeFamilleCourrier", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleCourrier,
				typeFamilleCourrierService.findAll());
		return TypeFamilleCourrier_LIST_VIEW;

	}
}
