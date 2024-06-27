package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeSortie {
	NON_CONNUE("Non connue"),
	DEFINITIVE("Definitive"),
	TEMPORAIRE("Temporaire");
	
	private String value;
	
	private TypeSortie(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static TypeSortie fromValues(String type) {
		for (TypeSortie t: TypeSortie.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return NON_CONNUE;
	}
}
