package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeProduit {
    EMPRUNTEUR("Emprunteur"),
    DEFAUT("");
    
    private String value;
	
	private TypeProduit(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static TypeProduit fromValues(String type) {
		for (TypeProduit t: TypeProduit.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
