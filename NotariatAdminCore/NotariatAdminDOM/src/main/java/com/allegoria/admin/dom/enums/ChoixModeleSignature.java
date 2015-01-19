package com.allegoria.admin.dom.enums;



/**
 * 
 */
public enum ChoixModeleSignature
    implements java.io.Serializable
{
    PUBLICATION_VENTE, //
    INSCRIPTION, //
    RADIATION, //
    AVENANT, //
    CONVENTION_RECHARGEMENT, //
    RADIATION_SIMPLIFIEE, //
    RENOUVELLEMENT, //
    AUTRE; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixModeleSignature()
    {
    }


	/**
     * Retrieves an instance of ChoixModeleSignature from <code>its name</code>.
     *
     * @param name the name to create the ChoixModeleSignature from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixModeleSignature fromString(String name)
    {
		return ChoixModeleSignature.valueOf(name);
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
