package com.allegoria.admin.controllers.courrier;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
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

import com.allegoria.admin.bl.DalService;
import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.typecourrier.TypeCourrierService;
import com.allegoria.admin.bl.typecritereautogeneration.TypeCritereAutoGenerationService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typecritereautogeneration.TypeCritereAutoGenerationRepository;
import com.allegoria.admin.dom.enums.ChoixDocumentOffice;
import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeCourrier")
public class TypeCourrierController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeCourrierController.class);
	protected static final String TypeCourrier_ADD_FORM_VIEW = "typeCourrier/newtypeCourrier.html";
	protected static final String TypeCourrier_LIST_VIEW = "typeCourrier/listetypeCourrier.html";
	protected static final String TypeCourrier_LIST = "/typeCourrier/listetypeCourrier.html";
	protected static final String TypeCourrier_Edit_FORM_VIEW = "typeCourrier/edittypeCourrier.html";
	protected static final String MODEL_ATTIRUTE_TypeCourrier = "typeCourrier";
	protected static final String MODEL_ATTIRUTE_LIST_TypeCourrier = "typeCourriers";
	protected static final String MODEL_ATTIRUTE_LIST_CritereAutoGeneration = "critereAutoGenerations";
	protected static final String MODEL_ATTIRUTE_LIST_DocumentEtude = "documentEtudes";
	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeCourrier_CREATED = "feedback.message.typeCourrier.created";

	@Autowired
	TypeCourrierService typeCourrierService;
	@Autowired
	TypeCritereAutoGenerationRepository typeCritereAutoGenerationRepository;
	@Autowired
	TypeCritereAutoGenerationService typeCritereAutoGenerationService;
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

	
		binder.registerCustomEditor(TypeCritereAutoGeneration.class, "critereAutoGenerationFk", new PropertyEditorSupport() {
		    @Override
		    public void setAsText(String text) {
		    	TypeCritereAutoGeneration ch = typeCritereAutoGenerationService.findById(Long.parseLong(text));
		        setValue(ch);
		    }
		    });
		binder.registerCustomEditor(Collection.class, "critereAutoGenerations",
				new CustomCollectionEditor(Collection.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeCritereAutoGeneration critereAutoGenerationFk = new TypeCritereAutoGeneration();

						if (element != null) {
							System.out.println(element.toString());

							critereAutoGenerationFk.setId(Long
									.parseLong(element.toString()));
						}
						return critereAutoGenerationFk;
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
		LOGGER.debug("Rendering create typeCourrier form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeCourrier, new TypeCourrier());

		model.addAttribute(MODEL_ATTIRUTE_LIST_DocumentEtude,
				ChoixDocumentOffice.values());
		
		if (typeCritereAutoGenerationRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_CritereAutoGeneration,
					typeCritereAutoGenerationRepository.findAll());
		}
		
		

		return TypeCourrier_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeCourrier form.
	 * 
	 * @param created
	 *            The information of the created typeCourriers.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeCourrier) TypeCourrier typeCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeCourrier);

		System.out.println(bindingResult.toString());
		System.out.println(typeCourrier);
		System.out.println(typeCourrier.getCritereAutoGenerationFk());
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_DocumentEtude,
					ChoixDocumentOffice.values());
			
			if (typeCritereAutoGenerationRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_CritereAutoGeneration,
						typeCritereAutoGenerationRepository.findAll());
			}
			return TypeCourrier_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeCourrier.getNom());
		typeCourrierService.create(typeCourrier);

		return createRedirectViewPath(TypeCourrier_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeCourrier) TypeCourrier typeCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeCourrier);

		System.out.println(typeCourrier);
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_DocumentEtude,
					ChoixDocumentOffice.values());
			
			if (typeCritereAutoGenerationRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_CritereAutoGeneration,
						typeCritereAutoGenerationRepository.findAll());
			}
			return TypeCourrier_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeCourrier.getNom());
		typeCourrierService.update(typeCourrier);

		return createRedirectViewPath(TypeCourrier_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeCourrier form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeCourrier,
				typeCourrierService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_LIST_DocumentEtude,
				ChoixDocumentOffice.values());
		
		if (typeCritereAutoGenerationRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_CritereAutoGeneration,
					typeCritereAutoGenerationRepository.findAll());
		}
		return TypeCourrier_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeCourrier", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
				typeCourrierService.findAll());
		return TypeCourrier_LIST_VIEW;

	}
}
