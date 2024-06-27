package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CodeProduit {
    ARC("ARC"),
    CAP("CAP"),
	DEFAUT("");
	
	private String value;
	
	private CodeProduit(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static CodeProduit fromValues(String type) {
		for (CodeProduit t: CodeProduit.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
