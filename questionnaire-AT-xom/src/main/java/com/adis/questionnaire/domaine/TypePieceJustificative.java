package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypePieceJustificative {

	ACTE_NAISSANCE("ACTE_NAISSANCE"),
	BULLETIN_HOSPITALISATION("BULLETIN_HOSPITALISATION"),
	BULLETIN_SITUATION("BULLETIN_SITUATION"),
	CERFA_ARRET_TRAVAIL("CERFA_ARRET_TRAVAIL"),
	RIB("RIB"),
	CR_HOSPITALISATION("CR_HOSPITALISATION"),
	DEFAUT("");
	
	private String value;
	
	private TypePieceJustificative(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}
	
	@JsonCreator
	public static TypePieceJustificative fromValues(String type) {
		for (TypePieceJustificative t: TypePieceJustificative.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
}
