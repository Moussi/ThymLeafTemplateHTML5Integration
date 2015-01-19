package com.allegoria.admin.dom.enums;


/**
 * 
 */
public enum ChoixDocumentPiece
    implements java.io.Serializable
{
    FEUILLE_EXCEL, //
    DOCUMENT_WORD, //
    REDACTION, //
    PDF; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixDocumentPiece()
    {
    }


	/**
     * Retrieves an instance of ChoixDocumentPiece from <code>its name</code>.
     *
     * @param name the name to create the ChoixDocumentPiece from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixDocumentPiece fromString(String name)
    {
		return ChoixDocumentPiece.valueOf(name);
	}
	
	/**
	 * This method is necessary to comply with DaoBase implementation.
	 * @return The name of this literal.
	 */
	public Object getValue()
	{
		return this.name();
	}
}
