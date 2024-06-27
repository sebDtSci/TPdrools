package com.adis.questionnaire.mdl;

import java.util.Date;

import com.adis.questionnaire.domaine.TypePieceJustificative;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PieceJustificative {

	private TypePieceJustificative type = TypePieceJustificative.DEFAUT;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateTransmission;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDebutValidite;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datefinValidite;

	public TypePieceJustificative getType() {
		return type;
	}

	public void setType(TypePieceJustificative type) {
		this.type = type;
	}

	public Date getDateTransmission() {
		return dateTransmission;
	}

	public void setDateTransmission(Date dateTransmission) {
		this.dateTransmission = dateTransmission;
	}

	public Date getDateDebutValidite() {
		return dateDebutValidite;
	}

	public void setDateDebutValidite(Date dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}

	public Date getDatefinValidite() {
		return datefinValidite;
	}

	public void setDatefinValidite(Date datefinValidite) {
		this.datefinValidite = datefinValidite;
	}
}
