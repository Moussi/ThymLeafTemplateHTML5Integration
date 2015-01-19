package com.allegoria.admin.bl.typepiece;



import java.util.List;

import com.allegoria.admin.bl.NotFoundException;
import com.allegoria.admin.dom.typefamillecourrier.TypePiece;



/**
 * Declares methods used to obtain and modify office information.
 * @author Allégoria
 */
public interface TypePieceService {

    /**
     * Creates a new .
     * @param created   The information of the created .
     * @return  The created .
     */
    public TypePiece create(TypePiece created);


   

    /**
     * Deletes a .
     * @param Id  The id of the deleted .
     * @return  The deleted .
     * @throws TypePieceNotFoundException  if no  is found with the given id.
     */
    public void delete(Long Id) throws NotFoundException;

    /**
     * Finds all s.
     * @return  A list of s.
     */
    public List<TypePiece> findAll();

    /**
     * Finds  by id.
     * @param id    The id of the wanted .
     * @return  The found . If no  is found, this method returns null.
     */
    public TypePiece findById(Long id);

    /**
     * Searches s for a given page by using the given search term.
     * @param searchTerm
     * @param pageIndex
     * @return  A list of s whose last name begins with the given search term and who are belonging to the given page.
     *          If no s is found, this method returns an empty list. This search is case insensitive.
     */
//    public List<TypePiece> search(String searchTerm, int pageIndex);

    /**
     * Updates the information of a .
     * @param updated   The information of the updated .
     * @return  The updated .
     * @throws TypePieceNotFoundException  if no  is found with given id.
     */
    public TypePiece update(TypePiece updated) throws NotFoundException;
}
