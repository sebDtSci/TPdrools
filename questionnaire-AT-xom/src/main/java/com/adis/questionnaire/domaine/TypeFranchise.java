package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeFranchise {

	ABSOLUE("A"),
	SEMI_RELATIVE("SR"),
	DEFAUT("");
	
	private String value;
	
	private TypeFranchise(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static TypeFranchise fromValues(String type) {
		for (TypeFranchise t: TypeFranchise.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
