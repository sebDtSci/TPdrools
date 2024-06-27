package com.adis.questionnaire.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CodePathologique {
    DH("DH"),
    CP("CP"),
    BM("BM"),
    CS("CS"),
    BO("BO"),
    HA("HA"),
    AE("AE"),
    BI("BI"),
    CM("CM"),
    CO("CO"),
    PG("PG"),
    CN("CN"),
    CW("CW"),
    TT("TT"),
    DK("DK"),
    DM("DM"),
    AB("AB"),
    DL("DL"),
    CD("CD"),
    HE("HE"),
    BL("BL"),
    BF("BF"),
    AD("AD"),
    AY("AY"),
    IN("IN"),
    CB("CB"),
    BC("BC"),
    AA("AA"),
    BJ("BJ"),
    CR("CR"),
    AO("AO"),
    AN("AN"),
    AF("AF"),
    VM("VM"),
    BZ("BZ"),
    XX("XX"),
    DEFAUT("")
    ;

    @JsonCreator
	public static CodePathologique fromValues(String type) {
		for (CodePathologique t: CodePathologique.values()) {
			if (String.valueOf(t.value).equals(type)) {
				return t;
			}
		}
		return null;
	}
	
	private String value;

	private CodePathologique(String value) {
		this.value = value;
	}
	
	@Override
	@JsonValue
	public String toString() {
		return value;
	}
}
