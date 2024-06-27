package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeGarantie {

	COMPLEMENT_AU_REGIME_PROFESSIONELLE("CRP"),
	INDEMNITES_PERTE_DE_REVENU("IPR"),
	REMBOURSEMENT_FRAIS_PROFESSIONNEL("RFP"),
	GARANTIE_INCAPACITE("GI"),
	DEFAUT("");
	
	private String value;
	
	private TypeGarantie(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static TypeGarantie fromValues(String type) {
		for (TypeGarantie t: TypeGarantie.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
