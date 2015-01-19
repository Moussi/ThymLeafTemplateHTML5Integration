package com.allegoria.admin.dom.enums;
/**
 * 
 */
public enum ChoixStatistiqueActe
    implements java.io.Serializable
{
    FIXE_COURANT, //
    FIXE_FAMILLE, //
    FIXE_SUCCESSION, //
    ADJUDICATION_PV, //
    ADJUDICATION_VENTE, //
    ATTESTATION_PROPRIETE, //
    AVANT_CONTRAT, //
    BAIL, //
    BAIL_12_ANS, //
    CESSION_COMMERCIALE, //
    CESSION_PARTS, //
    SERVITUDE, //
    CONVENTION_INDIVISION, //
    CREDIT_BAIL, //
    DIVORCE_PV, //
    DIVORCE_ACTE, //
    DONATION, //
    DONATION_PARTAGE, //
    DECLARATION_SUCCESSION, //
    ECHANGE, //
    EDD_RCP_CDC, //
    MAINLEVEE, //
    PARTAGE, //
    PARTAGE_SUCCESSION, //
    PARTAGE_APRES_DIVORCE, //
    OBLIGATION, //
    STATUT, //
    VENTE; //


    /**
     * The default constructor allowing
     * super classes to access it.
     */
    private ChoixStatistiqueActe()
    {
    }


	/**
     * Retrieves an instance of ChoixStatistiqueActe from <code>its name</code>.
     *
     * @param name the name to create the ChoixStatistiqueActe from.
     * @return The enumeration literal named after the 'name' argument
     */
    public static ChoixStatistiqueActe fromString(String name)
    {
		return ChoixStatistiqueActe.valueOf(name);
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
