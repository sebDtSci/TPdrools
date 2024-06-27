package com.adis.questionnaire.quest;

import com.adis.questionnaire.util.GenUID;

public class Reponse {

	private String libelle;
	private String id;

	public Reponse() {
	}

	public Reponse(String libelle) {
		this(libelle, GenUID.getUID(libelle));
	}

	public Reponse(String libelle, String id) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Reponse == false)
			return false;
		Reponse other = (Reponse) o;
		return id.equals(other.getId());
	}
}
