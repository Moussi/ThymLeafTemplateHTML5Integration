package com.allegoria.admin.controllers.typelocalfondpage;

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
import com.allegoria.admin.bl.notaire.NotaireService;
import com.allegoria.admin.bl.typecritereautogeneration.TypeCritereAutoGenerationService;
import com.allegoria.admin.bl.typelocalfondpage.TypeLocalFondPageService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typecritereautogeneration.TypeCritereAutoGenerationRepository;
import com.allegoria.admin.dom.enums.ChoixDocumentOffice;
import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.office.TypeLocalFondPage;
import com.allegoria.admin.dom.typecritereautogeneration.TypeCritereAutoGeneration;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeLocalFondPage")
public class TypeLocalFondPageController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeLocalFondPageController.class);
	protected static final String TypeLocalFondPage_ADD_FORM_VIEW = "typeLocalFondPage/newtypeLocalFondPage.html";
	protected static final String TypeLocalFondPage_LIST_VIEW = "typeLocalFondPage/listetypeLocalFondPage.html";
	protected static final String TypeLocalFondPage_LIST = "/typeLocalFondPage/listetypeLocalFondPage.html";
	protected static final String TypeLocalFondPage_Edit_FORM_VIEW = "typeLocalFondPage/edittypeLocalFondPage.html";
	protected static final String MODEL_ATTIRUTE_TypeLocalFondPage = "typeLocalFondPage";
	protected static final String MODEL_ATTIRUTE_LIST_TypeLocalFondPage = "typeLocalFondPages";
	protected static final String MODEL_ATTIRUTE_LIST_Notaire = "notaires";
	
	
	protected static final String FEEDBACK_MESSAGE_KEY_TypeLocalFondPage_CREATED = "feedback.message.typeLocalFondPage.created";

	@Autowired
	TypeLocalFondPageService typeLocalFondPageService;
	@Autowired
	NotaireService notaireService;
	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

	
		binder.registerCustomEditor(Notaire.class, "notaireFk", new PropertyEditorSupport() {
		    @Override
		    public void setAsText(String text) {
		    	Notaire ch = notaireService.findById(Long.parseLong(text));
		        setValue(ch);
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
		LOGGER.debug("Rendering create typeLocalFondPage form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeLocalFondPage, new TypeLocalFondPage());

		
		if (notaireService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_Notaire,
					notaireService.findAll());
		}
		
		

		return TypeLocalFondPage_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeLocalFondPage form.
	 * 
	 * @param created
	 *            The information of the created typeLocalFondPages.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeLocalFondPage) TypeLocalFondPage typeLocalFondPage,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeLocalFondPage);

		System.out.println(bindingResult.toString());
		System.out.println(typeLocalFondPage);
		System.out.println(typeLocalFondPage.getNotaireFk());
		if (bindingResult.hasErrors()) {
			if (notaireService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_Notaire,
						notaireService.findAll());
			}
			return TypeLocalFondPage_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeLocalFondPage.getNom());
		typeLocalFondPageService.create(typeLocalFondPage);

		return createRedirectViewPath(TypeLocalFondPage_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeLocalFondPage) TypeLocalFondPage typeLocalFondPage,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeLocalFondPage);

		System.out.println(typeLocalFondPage);
		System.out.println(typeLocalFondPage.getEmplacement()+" "+typeLocalFondPage.getIntitule());
		if (bindingResult.hasErrors()) {
			if (notaireService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_Notaire,
						notaireService.findAll());
			}
			return TypeLocalFondPage_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeLocalFondPage.getNom());
		typeLocalFondPageService.update(typeLocalFondPage);

		return createRedirectViewPath(TypeLocalFondPage_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeLocalFondPage form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeLocalFondPage,
				typeLocalFondPageService.findById(id));
		if (notaireService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_Notaire,
					notaireService.findAll());
		}
		return TypeLocalFondPage_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeLocalFondPage", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeLocalFondPage,
				typeLocalFondPageService.findAll());
		return TypeLocalFondPage_LIST_VIEW;

	}
}
