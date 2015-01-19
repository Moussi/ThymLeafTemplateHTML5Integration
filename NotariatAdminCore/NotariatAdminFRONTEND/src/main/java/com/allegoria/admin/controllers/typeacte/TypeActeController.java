package com.allegoria.admin.controllers.typeacte;

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

import com.allegoria.admin.bl.DalService;
import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.bl.typeacte.TypeActeService;
import com.allegoria.admin.bl.typerelationcomparution.TypeRelationComparutionService;
import com.allegoria.admin.controllers.AbstractController;
import com.allegoria.admin.dal.repositories.typeacte.TypeComparantRepository;
import com.allegoria.admin.dal.repositories.typeacte.TypeEffetRelatifRepository;
import com.allegoria.admin.dal.repositories.typeacte.TypeSousProduitRepository;
import com.allegoria.admin.dom.enums.ChoixCategorieActe;
import com.allegoria.admin.dom.enums.ChoixNatureMutation;
import com.allegoria.admin.dom.enums.ChoixNiveauDifficulte;
import com.allegoria.admin.dom.enums.ChoixRattachementCourrier;
import com.allegoria.admin.dom.enums.ChoixStatistiqueActe;
import com.allegoria.admin.dom.office.Notaire;
import com.allegoria.admin.dom.typeacte.TypeActe;
import com.allegoria.admin.dom.typeacte.TypeComparant;
import com.allegoria.admin.dom.typeacte.TypeEffetRelatif;
import com.allegoria.admin.dom.typeacte.TypeRelationComparution;
import com.allegoria.admin.dom.typeacte.TypeSousProduit;

/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/typeActe")
public class TypeActeController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeActeController.class);
	protected static final String TypeActe_ADD_FORM_VIEW = "typeActe/newtypeActe.html";
	protected static final String TypeActe_LIST_VIEW = "typeActe/listetypeActe.html";
	protected static final String TypeActe_LIST = "/typeActe/listetypeActe.html";
	protected static final String TypeActe_Edit_FORM_VIEW = "typeActe/edittypeActe.html";
	protected static final String MODEL_ATTIRUTE_TypeActe = "typeActe";
	protected static final String MODEL_ATTIRUTE_LIST_TypeActe = "typeActes";
	protected static final String MODEL_ATTIRUTE_LIST_FAMILLE = "familles";
	protected static final String MODEL_ATTIRUTE_LIST_NatureMutation = "natureMutation";
	protected static final String MODEL_ATTIRUTE_LIST_PointDifficulte = "pointDifficulte";
	protected static final String MODEL_ATTIRUTE_LIST_Statistique = "statistiques";
	protected static final String MODEL_ATTIRUTE_LIST_TYPE_EFFET_RELATIF = "typeeffetrelatifs";

	protected static final String MODEL_ATTIRUTE_LIST_TypeSousProduit = "typeSousProduits";
	protected static final String MODEL_ATTIRUTE_LIST_TypeComparant = "typeComparants";
	protected static final String MODEL_ATTIRUTE_LIST_TypeRelationComparution = "typeRelationComparutions";
	protected static final String FEEDBACK_MESSAGE_KEY_TypeActe_CREATED = "feedback.message.typeActe.created";

	@Autowired
	TypeActeService typeActeService;
	@Autowired
	TypeEffetRelatifRepository typeEffetRelatifRepository;
	@Autowired
	TypeSousProduitRepository typeSousProduitRepository;
	@Autowired
	TypeComparantRepository typeComparantRepository;
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

		binder.registerCustomEditor(Set.class, "typeRelationComparution",
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
		binder.registerCustomEditor(Set.class, "typeComparants",
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
		binder.registerCustomEditor(Collection.class,
				"typeSousProduitCollection", new CustomCollectionEditor(
						Collection.class) {

					@Override
					protected Object convertElement(Object element) {
						TypeSousProduit typeSousProduit = new TypeSousProduit();

						if (element != null) {
							System.out.println(element.toString());

							typeSousProduit.setId(Long.parseLong(element
									.toString()));
						}
						return typeSousProduit;
					}
				});
			binder.registerCustomEditor(TypeEffetRelatif.class, "typeEffetFk", new PropertyEditorSupport() {
		    @Override
		    public void setAsText(String text) {
		    	TypeEffetRelatif ch = typeEffetRelatifRepository.findOne(Long.parseLong(text));
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
		LOGGER.debug("Rendering create typeActe form");
		// passsage des paramètres
		model.addAttribute(MODEL_ATTIRUTE_TypeActe, new TypeActe());

		model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
				ChoixCategorieActe.values());
		model.addAttribute(MODEL_ATTIRUTE_LIST_Statistique,
				ChoixStatistiqueActe.values());
		model.addAttribute(MODEL_ATTIRUTE_LIST_NatureMutation,
				ChoixNatureMutation.values());
		model.addAttribute(MODEL_ATTIRUTE_LIST_PointDifficulte,
				ChoixNiveauDifficulte.values());
		if (typeComparantRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparant,
					typeComparantRepository.findAll());
		}
		if (typeSousProduitRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeSousProduit,
					typeSousProduitRepository.findAll());
		}
		if (typeEffetRelatifRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TYPE_EFFET_RELATIF,
					typeEffetRelatifRepository.findAll());
		}
		if (typeRelationComparutionService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeRelationComparution,
					typeRelationComparutionService.findAll());
		}
		

		return TypeActe_ADD_FORM_VIEW;

	}

	/**
	 * Processes the submissions of create typeActe form.
	 * 
	 * @param created
	 *            The information of the created typeActes.
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String submitCreateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeActe) TypeActe typeActe,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeActe);

		System.out.println(bindingResult.toString());
		System.out.println(typeActe);
		for (TypeComparant typeComparant : typeActe
				.getTypeComparants()) {
			System.out.println(typeComparant);
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
					ChoixRattachementCourrier.values());
			model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
					ChoixRattachementCourrier.values());
			if (typeComparantRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparant,
						typeComparantRepository.findAll());
			}
			if (typeSousProduitRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeSousProduit,
						typeSousProduitRepository.findAll());
			}
			if (typeEffetRelatifRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TYPE_EFFET_RELATIF,
						typeEffetRelatifRepository.findAll());
			}
			if (typeRelationComparutionService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeRelationComparution,
						typeRelationComparutionService.findAll());
			}
			return TypeActe_ADD_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeActe.getNom());
		typeActeService.create(typeActe);

		return createRedirectViewPath(TypeActe_LIST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateOfficeForm(
			@ModelAttribute(MODEL_ATTIRUTE_TypeActe) TypeActe typeActe,
			BindingResult bindingResult, RedirectAttributes attributes,
			Model model) throws NotFoundException {
		LOGGER.debug("Create Office form was submitted with information: "
				+ typeActe);

		System.out.println(typeActe);
		if (bindingResult.hasErrors()) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
					ChoixRattachementCourrier.values());
			model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
					ChoixRattachementCourrier.values());
			if (typeComparantRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparant,
						typeComparantRepository.findAll());
			}
			if (typeSousProduitRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeSousProduit,
						typeSousProduitRepository.findAll());
			}
			if (typeEffetRelatifRepository.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TYPE_EFFET_RELATIF,
						typeEffetRelatifRepository.findAll());
			}
			if (typeRelationComparutionService.findAll() != null) {
				model.addAttribute(MODEL_ATTIRUTE_LIST_TypeRelationComparution,
						typeRelationComparutionService.findAll());
			}
			return TypeActe_Edit_FORM_VIEW;
		}

		// addFeedbackMessage(attributes,
		// FEEDBACK_MESSAGE_KEY_TypeFamilleCourrierLocal_CREATED,
		// typeActe.getNom());
		typeActeService.update(typeActe);

		return createRedirectViewPath(TypeActe_LIST);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditOfficeForm(@PathVariable("id") Long id, Model model) {
		LOGGER.debug("Rendering edit typeActe form");
		// passsage des paramètres

		model.addAttribute(MODEL_ATTIRUTE_TypeActe,
				typeActeService.findById(id));
		model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
				ChoixRattachementCourrier.values());
		model.addAttribute(MODEL_ATTIRUTE_LIST_FAMILLE,
				ChoixRattachementCourrier.values());
		if (typeComparantRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeComparant,
					typeComparantRepository.findAll());
		}
		if (typeSousProduitRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeSousProduit,
					typeSousProduitRepository.findAll());
		}
		if (typeEffetRelatifRepository.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TYPE_EFFET_RELATIF,
					typeEffetRelatifRepository.findAll());
		}
		if (typeRelationComparutionService.findAll() != null) {
			model.addAttribute(MODEL_ATTIRUTE_LIST_TypeRelationComparution,
					typeRelationComparutionService.findAll());
		}
		return TypeActe_Edit_FORM_VIEW;

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listetypeActe", method = RequestMethod.GET)
	public String showListOffice(Model model) {

		model.addAttribute(MODEL_ATTIRUTE_LIST_TypeActe,
				typeActeService.findAll());
		return TypeActe_LIST_VIEW;

	}
}
