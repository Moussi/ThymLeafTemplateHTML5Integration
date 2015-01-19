package com.allegoria.admin.dom.enums;


/**
 * 
 */
public enum ChoixMultipliciteOccurrenceSousProduit
    implements java.io.Serializable
{
    ZERO, //
    UN, //
    ZERO_OU_PLUS, //
    UN_OU_PLUS; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixMultipliciteOccurrenceSousProduit()
    {
    }


	/**
     * Retrieves an instance of ChoixMultipliciteOccurrenceSousProduit from <code>its name</code>.
     *
     * @param name the name to create the ChoixMultipliciteOccurrenceSousProduit from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixMultipliciteOccurrenceSousProduit fromString(String name)
    {
		return ChoixMultipliciteOccurrenceSousProduit.valueOf(name);
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
