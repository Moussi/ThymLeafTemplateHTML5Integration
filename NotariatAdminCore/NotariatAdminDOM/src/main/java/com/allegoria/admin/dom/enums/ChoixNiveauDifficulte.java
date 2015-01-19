package com.allegoria.admin.dom.enums;




/**
 * 
 */
public enum ChoixNiveauDifficulte
    implements java.io.Serializable
{
    UN, //
    DEUX, //
    TROIS, //
    QUATRE, //
    CINQ, //
    SIX, //
    SEPT; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixNiveauDifficulte()
    {
    }


	/**
     * Retrieves an instance of ChoixNiveauDifficulte from <code>its name</code>.
     *
     * @param name the name to create the ChoixNiveauDifficulte from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixNiveauDifficulte fromString(String name)
    {
		return ChoixNiveauDifficulte.valueOf(name);
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
