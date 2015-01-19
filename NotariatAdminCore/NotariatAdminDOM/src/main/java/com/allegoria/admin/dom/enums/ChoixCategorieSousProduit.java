package com.allegoria.admin.dom.enums;


/**
 * 
 */
public enum ChoixCategorieSousProduit
    implements java.io.Serializable
{
    AUTOMATIQUE, //
    LIBRE, //
    CLIENT_OU_TIERS, //
    CERFA; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixCategorieSousProduit()
    {
    }


	/**
     * Retrieves an instance of ChoixCategorieSousProduit from <code>its name</code>.
     *
     * @param name the name to create the ChoixCategorieSousProduit from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixCategorieSousProduit fromString(String name)
    {
		return ChoixCategorieSousProduit.valueOf(name);
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
