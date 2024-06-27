package com.adis.questionnaire.domaine;

public class TypeArretTravail {
	public static final TypeArretTravail INITIAL = new TypeArretTravail("I", "INITIAL");
	public static final TypeArretTravail PROLONGATION = new TypeArretTravail("P", "PROLONGATION");
	public static final TypeArretTravail RECHUTE = new TypeArretTravail("R", "RECHUTE");
	public static final TypeArretTravail DEFAUT = new TypeArretTravail("", "DEFAUT");
	
	private String libelle; // libelle
	private String code; // code

	private TypeArretTravail(String value, String key) {
		this.libelle = value;
		this.code = key;
	}

	private TypeArretTravail(){

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
