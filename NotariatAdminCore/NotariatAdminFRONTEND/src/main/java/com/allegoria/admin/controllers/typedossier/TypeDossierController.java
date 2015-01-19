package com.allegoria.admin.controllers.typedossier;

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

import com.allegoria.admin.bl.typedossier.TypeDossierNotFoundException;
import com.allegoria.admin.bl.typedossier.TypeDossierService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeComparutionCourrierRepository;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeCourrierLocalRepository;
import com.allegoria.admin.dal.repositories.typecomparutioncourrier.TypeCourrierRepository;
import com.allegoria.admin.dal.repositories.typefamillecourrier.TypeFamilleMereCourrierRepository;
import com.allegoria.admin.dom.dossier.TypeDossier;
import com.allegoria.admin.dom.enums.ChoixRattachementCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeComparutionCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrier;
import com.allegoria.admin.dom.typefamillecourrier.TypeCourrierLocal;
import com.allegoria.admin.dom.typefamillecourrier.TypeFamilleMereCourrier;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeDossier")
public class TypeDossierController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeDossierController.class);
	protected static final String TypeDossier_ADD_FORM_VIEW = "typeDossier/newtypeDossier.html";
	protected static final String TypeDossier_LIST_VIEW = "typeDossier/listetypeDossier.html";
	protected static final String TypeDossier_LIST = "/typeDossier/listetypeDossier.html";
	protected static final String TypeDossier_Edit_FORM_VIEW = "typeDossier/edittypeDossier.html";
	protected static final String MODEL_ATTIRUTE_TypeDossier = "typeDossier";
	protected static final String MODEL_ATTIRUTE_LIST_TypeDossier = "typeDossiers";
	protected static final String MODEL_ATTIRUTE_LIST_GENRE = "genres";
	protected static final String MODEL_ATTIRUTE_LIST_TypeCourrierLocal = "typeCourrierlocaux";
	protected static final String MODEL_ATTIRUTE_LIST_TypeCourrier = "typeCourriers";
	protected static final String MODEL_ATTIRUTE_LIST_TypeComparutionCourrier = "typeComparutionCourriers";
	protected static final String MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier = "typeFamilleMereCourriers";
	protected static final String FEEDBACK_MESSAGE_KEY_TypeDossier_CREATED = "feedback.message.typeDossier.created";

	@Autowired
	TypeDossierService typeDossierService;
	@Autowired
	TypeCourrierRepository typeCourrierRepository;
	@Autowired
	TypeCourrierLocalRepository typeCourrierLocalRepository;
	@Autowired
	TypeFamilleMereCourrierRepository typeFamilleMereCourrierRepository;
	@Autowired
	TypeComparutionCourrierRepository typeComparutionCourrierRepository;

	/**
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

		binder.registerCustomEditor(Set.class, "typeFamilleMereCourriers",
				new CustomCollectionEditor(Set.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeFamilleMereCourrier typeFamilleMereCourrier = new TypeFamilleMereCourrier();

						if (element != null) {
							System.out.println(element.toString());

							typeFamilleMereCourrier.setId(Long
									.parseLong(element.toString()));
						}
						return typeFamilleMereCourrier;
					}
				});
		binder.registerCustomEditor(Set.class, "typeComparutionCourriers",
				new CustomCollectionEditor(Set.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeComparutionCourrier typeComparutionCourrier = new TypeComparutionCourrier();

						if (element != null) {
							System.out.println(element.toString());

							typeComparutionCourrier.setId(Long
									.parseLong(element.toString()));
						}
						return typeComparutionCourrier;
					}
				});
		binder.registerCustomEditor(Collection.class,
				"typeCourrierLocalCollection", new CustomCollectionEditor(
						Collection.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeCourrierLocal typeCourrierLocal = new TypeCourrierLocal();

						if (element != null) {
							System.out.println(element.toString());

							typeCourrierLocal.setId(Long.parseLong(element
									.toString()));
						}
						return typeCourrierLocal;
					}
				});
		binder.registerCustomEditor(Collection.class, "typeCourrierCollection",
				new CustomCollectionEditor(Collection.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeCourrier typeCourrier = new TypeCourrier();

						if (element != null) {
							System.out.println(element.toString());

							typeCourrier.setId(Long.parseLong(element
									.toString()));
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
		LOGGER.debug("Rendering create typeDossier form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeDossier, new TypeDossier());

		model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
				ChoixRattachementCourrier.values());
		if (typeCourrierRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
					typeCourrierRepository.findAll());
		}
		if (typeCourrierLocalRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrierLocal,
					typeCourrierLocalRepository.findAll());
		}
		if (typeFamilleMereCourrierRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier,
					typeFamilleMereCourrierRepository.findAll());
		}
		if (typeComparutionCourrierRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparutionCourrier,
					typeComparutionCourrierRepository.findAll());
		}

		return TypeDossier_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeDossier form.
	 * 
	 * @param created
	 *            The information of the created typeDossiers.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeDossier) TypeDossier typeDossier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeDossier);

		System.out.println(bindingResult.toString());
		System.out.println(typeDossier);
		for (TypeComparutionCourrier typeComparutionCourrier : typeDossier
				.getTypeComparutionCourriers()) {
			System.out.println(typeComparutionCourrier);
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
					ChoixRattachementCourrier.values());
			if (typeCourrierRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
						typeCourrierRepository.findAll());
			}
			if (typeCourrierLocalRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrierLocal,
						typeCourrierLocalRepository.findAll());
			}
			if (typeFamilleMereCourrierRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier,
						typeFamilleMereCourrierRepository.findAll());
			}
			if (typeComparutionCourrierRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparutionCourrier,
						typeComparutionCourrierRepository.findAll());
			}
			return TypeDossier_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeDossier.getNom());
		typeDossierService.create(typeDossier);

		return createRedirectViewPath(TypeDossier_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeDossier) TypeDossier typeDossier,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws TypeDossierNotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeDossier);

		System.out.println(typeDossier);
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
					ChoixRattachementCourrier.values());
			if (typeCourrierRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
						typeCourrierRepository.findAll());
			}
			if (typeCourrierLocalRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrierLocal,
						typeCourrierLocalRepository.findAll());
			}
			if (typeFamilleMereCourrierRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier,
						typeFamilleMereCourrierRepository.findAll());
			}
			if (typeComparutionCourrierRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparutionCourrier,
						typeComparutionCourrierRepository.findAll());
			}
			return TypeDossier_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeDossier.getNom());
		typeDossierService.update(typeDossier);

		return createRedirectViewPath(TypeDossier_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeDossier form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeDossier,
				typeDossierService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_LIST_GENRE,
				ChoixRattachementCourrier.values());
		if (typeCourrierRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrier,
					typeCourrierRepository.findAll());
		}
		if (typeCourrierLocalRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeCourrierLocal,
					typeCourrierLocalRepository.findAll());
		}
		if (typeFamilleMereCourrierRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeFamilleMereCourrier,
					typeFamilleMereCourrierRepository.findAll());
		}
		if (typeComparutionCourrierRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparutionCourrier,
					typeComparutionCourrierRepository.findAll());
		}
		return TypeDossier_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeDossier", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeDossier,
				typeDossierService.findAll());
		return TypeDossier_LIST_VIEW;

	}
}
