package com.allegoria.admin.dom.enums;



/**
 * 
 */
public enum ChoixCategorieActe
    implements java.io.Serializable
{
    FAMILLE, //
    IMMOBILIER_ACTES_PUBLICS, //
    IMMOBILIER_BAUX, //
    IMMOBILIER_MUTATIONS, //
    SOCIETE_COMMERCE, //
    RURAL, //
    PRET_GARANTIE, //
    MAINLEVEE_QUITTANCE, //
    PROCURATION, //
    AUTRES, //
    HISTORIQUE, //
    SUCCESSION; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixCategorieActe()
    {
    }


	/**
     * Retrieves an instance of ChoixCategorieActe from <code>its name</code>.
     *
     * @param name the name to create the ChoixCategorieActe from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixCategorieActe fromString(String name)
    {
		return ChoixCategorieActe.valueOf(name);
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
