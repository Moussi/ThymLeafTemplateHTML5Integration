package com.allegoria.admin.controllers.typecomparutioncourrier;

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

import com.allegoria.admin.bl.typecomparutioncourrrier.TypeComparutionCourrierNotFoundException;
import com.allegoria.admin.bl.typecomparutioncourrrier.TypeComparutionCourrierService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeCourrierRepository;
import com.allegoria.admin.dom.enums.ChoixRattachementCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeComparutionCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeComparutionCourrier")
public class TypeComparutionCourrierController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeComparutionCourrierController.class);
	protected static final String TypeComparutionCourrier_ADD_FORM_VIEW = "typeComparutionCourrier/newtypeComparutionCourrier.html";
	protected static final String TypeComparutionCourrier_LIST_VIEW = "typeComparutionCourrier/listetypeComparutionCourrier.html";
	protected static final String TypeComparutionCourrier_LIST = "/typeComparutionCourrier/listetypeComparutionCourrier.html";
	protected static final String TypeComparutionCourrier_Edit_FORM_VIEW = "typeComparutionCourrier/edittypeComparutionCourrier.html";
	protected static final String MODEL_ATTIRUTE_TypeComparutionCourrier = "typeComparutionCourrier";
	protected static final String MODEL_ATTIRUTE_LIST_TypeComparutionCourrier = "typeComparutionCourriers";
	protected static final String MODEL_ATTIRUTE_LIST_TypeComparution = "typeComparution";
	protected static final String MODEL_ATTIRUTE_LIST_TypeCourrier = "typeCourriers";
	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeComparutionCourrier_CREATED = "feedback.message.typeComparutionCourrier.created";

	@Autowired
	TypeComparutionCourrierService typeComparutionCourrierService;
	@Autowired
	TypeCourrierRepository typeCourrierRepository;
	
	
	
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {

        

        binder.registerCustomEditor(Set.class, "typeCourriers",new CustomCollectionEditor(Set.class){

            @Override
            protected Object convertElement(Object element) {
                TypeCourrier typeCourrier = new TypeCourrier();

                if (element != null) {
                    System.out.println(element.toString());
                	
                    typeCourrier.setId(Long.parseLong(element.toString()));
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
		LOGGER.debug("Rendering create typeComparutionCourrier form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeComparutionCourrier,
				new TypeComparutionCourrier());
		
		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparution, ChoixRattachementCourrier.values());
		if(typeCourrierRepository.findAll()!=null)
			{
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier, typeCourrierRepository.findAll());
			}
		

		return TypeComparutionCourrier_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeComparutionCourrier form.
	 * 
	 * @param created
	 *            The information of the created typeComparutionCourriers.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeComparutionCourrier) TypeComparutionCourrier typeComparutionCourrier,
			BindingResult bindingResult, RedirectAttributes attributes,Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeComparutionCourrier);
		
		System.out.println(bindingResult.toString());
		 System.out.println(typeComparutionCourrier);
		 for(TypeCourrier typeCourrier:typeComparutionCourrier.getTypeCourriers())
		 {
			 System.out.println(typeCourrier);
		 }
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparution, ChoixRattachementCourrier.values());
			if(typeCourrierRepository.findAll()!=null)
			{
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier, typeCourrierRepository.findAll());
			}
			return TypeComparutionCourrier_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeComparutionCourrier.getNom());
		typeComparutionCourrierService.create(typeComparutionCourrier);

		return createRedirectViewPath(TypeComparutionCourrier_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeComparutionCourrier) TypeComparutionCourrier typeComparutionCourrier,
			BindingResult bindingResult, RedirectAttributes attributes, Model model)
			throws TypeComparutionCourrierNotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeComparutionCourrier);
		
		System.out.println(typeComparutionCourrier);
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparution, ChoixRattachementCourrier.values());
			if(typeCourrierRepository.findAll()!=null)
			{
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier, typeCourrierRepository.findAll());
			}
			return TypeComparutionCourrier_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeComparutionCourrier.getNom());
		typeComparutionCourrierService.update(typeComparutionCourrier);

		return createRedirectViewPath(TypeComparutionCourrier_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeComparutionCourrier form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeComparutionCourrier,
				typeComparutionCourrierService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparution, ChoixRattachementCourrier.values());
		if(typeCourrierRepository.findAll()!=null)
		{
		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier, typeCourrierRepository.findAll());
		}
		return TypeComparutionCourrier_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeComparutionCourrier", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparutionCourrier,
				typeComparutionCourrierService.findAll());
		return TypeComparutionCourrier_LIST_VIEW;

	}
}
