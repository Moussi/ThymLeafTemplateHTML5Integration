package com.allegoria.admin.dom.enums;



/**
 * 
 */
public enum ChoixEnteteSousProduit
    implements java.io.Serializable
{
    FOND_PAGE_OFFICE, //
    FOND_PAGE_COURRIER, //
    SANS_FOND_PAGE, //
    FOND_PAGE_COPIE_PUBLIE, //
    FOND_PAGE_BORDEREAU, //
    FOND_PAGE_EXTRAIT_ACTE, //
    FOND_PAGE_RENOUVELLEMENT, //
    FOND_PAGE_BORDEREAU_RECTIFICATIF, //
    FOND_PAGE_ATTESTATION_RETIFICATIVE, //
    FOND_PAGE_FOND_DE_COMMERCE, //
    COPIE_EXECUTOIRE, //
    COPIE_AUTHENTIQUE; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixEnteteSousProduit()
    {
    }


	/**
     * Retrieves an instance of ChoixEnteteSousProduit from <code>its name</code>.
     *
     * @param name the name to create the ChoixEnteteSousProduit from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixEnteteSousProduit fromString(String name)
    {
		return ChoixEnteteSousProduit.valueOf(name);
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
