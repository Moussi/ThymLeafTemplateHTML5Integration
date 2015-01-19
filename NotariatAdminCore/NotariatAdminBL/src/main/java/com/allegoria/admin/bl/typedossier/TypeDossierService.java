package com.allegoria.admin.bl.typedossier;



import java.util.List;

import com.allegoria.admin.bl.office.OfficeNotFoundException;
import com.allegoria.admin.dom.dossier.TypeDossier;

/**
 * Declares methods used to obtain and modify office information.
 * @author Allégoria
 */
public interface TypeDossierService {

    /**
     * Creates a new .
     * @param created   The information of the created .
     * @return  The created .
     */
    public TypeDossier create(TypeDossier created);


   

    /**
     * Deletes a .
     * @param Id  The id of the deleted .
     * @return  The deleted .
     * @throws OfficeNotFoundException  if no  is found with the given id.
     */
    public TypeDossier delete(Long Id) throws TypeDossierNotFoundException;

    /**
     * Finds all s.
     * @return  A list of s.
     */
    public List<TypeDossier> findAll();

    /**
     * Finds  by id.
     * @param id    The id of the wanted .
     * @return  The found . If no  is found, this method returns null.
     */
    public TypeDossier findById(Long id);

    /**
     * Searches s for a given page by using the given search term.
     * @param searchTerm
     * @param pageIndex
     * @return  A list of s whose last name begins with the given search term and who are belonging to the given page.
     *          If no s is found, this method returns an empty list. This search is case insensitive.
     */
//    public List<TypeDossier> search(String searchTerm, int pageIndex);

    /**
     * Updates the information of a .
     * @param updated   The information of the updated .
     * @return  The updated .
     * @throws TypeDossierNotFoundException  if no  is found with given id.
     */
    public TypeDossier update(TypeDossier updated) throws TypeDossierNotFoundException;
}
