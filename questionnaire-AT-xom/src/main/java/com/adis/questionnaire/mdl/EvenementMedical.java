package com.adis.questionnaire.mdl;

import java.util.Date;

import com.adis.questionnaire.domaine.CodeEvenementMedical;
import com.adis.questionnaire.domaine.CodePathologique;
import com.adis.questionnaire.domaine.TypeArretTravail;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EvenementMedical {

	// AT/Hospitalisation/Hospitalisation avec franchise
	private CodeEvenementMedical code;

	// Initial/Prolongation/Rechute
	private TypeArretTravail type;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFin;

	private CodePathologique codePathologique;

	public CodeEvenementMedical getCode() {
		return code;
	}

	public void setCode(CodeEvenementMedical code) {
		this.code = code;
	}

	public TypeArretTravail getType() {
		return type;
	}

	public void setType(TypeArretTravail type) {
		this.type = type;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public CodePathologique getCodePathologique() {
		return codePathologique;
	}

	public void setCodePathologique(CodePathologique codePathologique) {
		this.codePathologique = codePathologique;
	}

}
