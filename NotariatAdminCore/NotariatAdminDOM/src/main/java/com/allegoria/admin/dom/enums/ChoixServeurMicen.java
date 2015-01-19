// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: TypeSafeEnumeration.vsl in andromda-java-cartridge.
//
package com.allegoria.admin.dom.enums;

/**
 * 
 */
public enum ChoixServeurMicen
    implements java.io.Serializable
{
    FORMATION, //
    EVALUATION, //
    PRODUCTION; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixServeurMicen()
    {
    }


	/**
     * Retrieves an instance of ChoixServeurMicen from <code>its name</code>.
     *
     * @param name the name to create the ChoixServeurMicen from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixServeurMicen fromString(String name)
    {
		return ChoixServeurMicen.valueOf(name);
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