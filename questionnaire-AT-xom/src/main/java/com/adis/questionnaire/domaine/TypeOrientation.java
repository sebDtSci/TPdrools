package com.adis.questionnaire.domaine;


public class TypeOrientation {
	public static final TypeOrientation SERVICE_REASS = new TypeOrientation("Transmettre l'acte au service réassurance", "SERVICE_REASS");
	public static final TypeOrientation ETUDE_REDAC = new TypeOrientation("Etude rédacteur", "ETUDE_REDAC");
	public static final TypeOrientation DEMANDE_PIECE_COMPLETE = new TypeOrientation("Demande de pièces", "DEMANDE_PIECE_COMPLETE");
	public static final TypeOrientation NN_PRISE_CHARGE = new TypeOrientation("Non prise en charge", "NN_PRISE_CHARGE");
	public static final TypeOrientation PRISE_CHARGE = new TypeOrientation("Prise en charge", "PRISE_CHARGE");
	public static final TypeOrientation PRISE_CHARGE_PART = new TypeOrientation("Prise en charge partielle", "PRISE_CHARGE_PART");
	public static final TypeOrientation DEFAUT = new TypeOrientation("", "DEFAUT");


	private String libelle; // libelle
	private String code; // code

	private TypeOrientation(String value, String key) {
		this.libelle = value;
		this.code = key;
	}

	private TypeOrientation(){

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}