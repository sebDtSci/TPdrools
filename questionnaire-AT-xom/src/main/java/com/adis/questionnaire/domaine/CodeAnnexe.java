package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CodeAnnexe {
	AN_EXCLUSION("Exclusion"),
	AN_SPORT("Sport"),
	DEFAUT("");
	
	private String value;
	
	private CodeAnnexe(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static CodeAnnexe fromValues(String type) {
		for (CodeAnnexe t: CodeAnnexe.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
