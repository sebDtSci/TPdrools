package com.adis.questionnaire.mdl;

public class Adresse {
	private String libelle;
	private String id;
	
	public Adresse(String libelle, String id) {
		this.setLibelle(libelle);
		this.setId(id);
	}
	public Adresse() {
		this("", "");
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
