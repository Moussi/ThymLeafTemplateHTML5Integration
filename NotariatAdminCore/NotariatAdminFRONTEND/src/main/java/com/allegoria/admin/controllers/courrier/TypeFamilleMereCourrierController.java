package com.allegoria.admin.controllers.courrier;

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
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleCourrierService;
import com.allegoria.admin.bl.typefamillecourriel.TypeFamilleMereCourrierService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleMereCourrier;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeFamilleMereCourrier")
public class TypeFamilleMereCourrierController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeFamilleMereCourrierController.class);
	protected static final String TypeFamilleMereCourrier_ADD_FORM_VIEW = "typeFamilleMereCourrier/newtypeFamilleMereCourrier.html";
	protected static final String TypeFamilleMereCourrier_LIST_VIEW = "typeFamilleMereCourrier/listetypeFamilleMereCourrier.html";
	protected static final String TypeFamilleMereCourrier_LIST = "/typeFamilleMereCourrier/listetypeFamilleMereCourrier.html";
	protected static final String TypeFamilleMereCourrier_Edit_FORM_VIEW = "typeFamilleMereCourrier/edittypeFamilleMereCourrier.html";
	protected static final String MODEL_ATTIRUTE_TypeFamilleMereCourrier = "typeFamilleMereCourrier";
	protected static final String MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier = "typeFamilleMereCourriers";
	protected static final String MODEL_ATTIRUTE_LIST_TypeFamilleCourrier = "typeFamilleCourriers";

	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeFamilleMereCourrier_CREATED = "feedback.message.typeFamilleMereCourrier.created";

	@Autowired
	TypeFamilleMereCourrierService typeFamilleMereCourrierService;
	@Autowired
	TypeFamilleCourrierService typeFamilleCourrierService;
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

	
		
		binder.registerCustomEditor(Set.class, "typeFamilleCourriers",
				new CustomCollectionEditor(Set.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeFamilleCourrier typeFamilleCourrier = new TypeFamilleCourrier();

						if (element != null) {
							System.out.println(element.toString());

							typeFamilleCourrier.setId(Long
									.parseLong(element.toString()));
						}
						return typeFamilleCourrier;
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
		LOGGER.debug("Rendering create typeFamilleMereCourrier form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeFamilleMereCourrier, new TypeFamilleMereCourrier());

		
		
		if (typeFamilleCourrierService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleCourrier,
					typeFamilleCourrierService.findAll());
		}
		
		

		return TypeFamilleMereCourrier_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeFamilleMereCourrier form.
	 * 
	 * @param created
	 *            The information of the created typeFamilleMereCourriers.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeFamilleMereCourrier) TypeFamilleMereCourrier typeFamilleMereCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeFamilleMereCourrier);

		System.out.println(bindingResult.toString());
		System.out.println(typeFamilleMereCourrier);
		for(TypeFamilleCourrier typeFamilleCourrier:typeFamilleMereCourrier.getTypeFamilleCourriers())
		{
			System.out.println(typeFamilleCourrier);
		}
		if (bindingResult.hasErrors()) {

			if (typeFamilleCourrierService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleCourrier,
						typeFamilleCourrierService.findAll());
			}
			return TypeFamilleMereCourrier_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleMereCourrierLocal_CREATED,
		// typeFamilleMereCourrier.getNom());
		typeFamilleMereCourrierService.create(typeFamilleMereCourrier);

		return createRedirectViewPath(TypeFamilleMereCourrier_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeFamilleMereCourrier) TypeFamilleMereCourrier typeFamilleMereCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeFamilleMereCourrier);

		System.out.println(typeFamilleMereCourrier);
		if (bindingResult.hasErrors()) {
			if (typeFamilleCourrierService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleCourrier,
						typeFamilleCourrierService.findAll());
			}
			return TypeFamilleMereCourrier_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleMereCourrierLocal_CREATED,
		// typeFamilleMereCourrier.getNom());
		typeFamilleMereCourrierService.update(typeFamilleMereCourrier);

		return createRedirectViewPath(TypeFamilleMereCourrier_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeFamilleMereCourrier form");
		// passsage des paramètres
		System.out.println(typeFamilleMereCourrierService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_TypeFamilleMereCourrier,
				typeFamilleMereCourrierService.findById(id));
		for(TypeFamilleCourrier typeFamilleCourrier:typeFamilleMereCourrierService.findById(id).getTypeFamilleCourriers())
		{
			System.out.println(typeFamilleCourrier);
		}
		for(TypeFamilleCourrier typeFamilleCourrier:typeFamilleCourrierService.findAll())
		{
			System.out.println(typeFamilleCourrier);
		}
		if (typeFamilleCourrierService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleCourrier,
					typeFamilleCourrierService.findAll());
		}
		return TypeFamilleMereCourrier_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeFamilleMereCourrier", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier,
				typeFamilleMereCourrierService.findAll());
		return TypeFamilleMereCourrier_LIST_VIEW;

	}
}
