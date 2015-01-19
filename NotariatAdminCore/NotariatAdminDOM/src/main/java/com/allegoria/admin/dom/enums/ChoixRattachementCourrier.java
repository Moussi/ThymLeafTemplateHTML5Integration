package com.allegoria.admin.dom.enums;


/**
 * 
 */
public enum ChoixRattachementCourrier
    implements java.io.Serializable
{
    DESTINATAIRE, //
    CONCERNE, //
    VENDEUR, //
    ACQUEREUR, //
    PRETEUR, //
    EMPRUNTEUR, //
    CAUTION, //
    DONATEUR, //
    DONATAIRE, //
    DEFUNT, //
    CONJOINT_SURVIVANT, //
    HERITIER, //
    LEGATAIRE, //
    BAILLEUR, //
    PRENEUR, //
    CEDANT, //
    CESSIONNAIRE, //
    ACTIONNAIRES, //
    CO_ECHANGISTES, //
    TIERS, //
    AUTRE; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixRattachementCourrier()
    {
    }


	/**
     * Retrieves an instance of ChoixRattachementCourrier from <code>its name</code>.
     *
     * @param name the name to create the ChoixRattachementCourrier from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixRattachementCourrier fromString(String name)
    {
		return ChoixRattachementCourrier.valueOf(name);
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
