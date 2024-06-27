package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LibelleAnnexe {
	// TODO: Verifier si il n'y a pas inversion avec CodeAnnexe
    AN_EXCLUSION("Exclusion"),
	AN_SPORT("Sport"),
	DEFAUT("");

    private String value;
	
	private LibelleAnnexe(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static LibelleAnnexe fromValues(String type) {
		for (LibelleAnnexe t: LibelleAnnexe.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
