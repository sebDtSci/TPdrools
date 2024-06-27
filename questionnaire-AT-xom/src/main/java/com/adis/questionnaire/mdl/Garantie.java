package com.adis.questionnaire.mdl;

import java.util.Date;

import com.adis.questionnaire.domaine.TypeFranchise;
import com.adis.questionnaire.domaine.TypeGarantie;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Garantie {

	private TypeGarantie type;
	private String numeroGarantie = "";
	private String code = "";
	private int nombreClasses;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateSouscription;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDerniereAugmentationRisque;

	private int nombreJoursFranchiseMaladieSouscrite;
	private int nombreJoursFranchiseAccidentSouscrite;
	private int nombreJoursFranchiseHospitalisationSouscrite;

	private int nombreJoursFranchiseMaladieBonifies;
	private int nombreJoursFranchiseAccidentBonifies;
	private int nombreJoursFranchiseHospitalisationBonifies;

	private TypeFranchise typeFranchise = TypeFranchise.DEFAUT;
	private boolean presenceCession = false;

	public TypeGarantie getType() {
		return type;
	}

	public void setType(TypeGarantie type) {
		this.type = type;
	}

	public String getNumeroGarantie() {
		return numeroGarantie;
	}

	public void setNumeroGarantie(String numeroGarantie) {
		this.numeroGarantie = numeroGarantie;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getNombreClasses() {
		return nombreClasses;
	}

	public void setNombreClasses(int nombreClasses) {
		this.nombreClasses = nombreClasses;
	}

	public Date getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public Date getDateDerniereAugmentationRisque() {
		return dateDerniereAugmentationRisque;
	}

	public void setDateDerniereAugmentationRisque(Date dateDerniereAugmentationRisque) {
		this.dateDerniereAugmentationRisque = dateDerniereAugmentationRisque;
	}

	public int getNombreJoursFranchiseMaladieSouscrite() {
		return nombreJoursFranchiseMaladieSouscrite;
	}

	public void setNombreJoursFranchiseMaladieSouscrite(int nombreJoursFranchiseMaladieSouscrite) {
		this.nombreJoursFranchiseMaladieSouscrite = nombreJoursFranchiseMaladieSouscrite;
	}

	public int getNombreJoursFranchiseAccidentSouscrite() {
		return nombreJoursFranchiseAccidentSouscrite;
	}

	public void setNombreJoursFranchiseAccidentSouscrite(int nombreJoursFranchiseAccidentSouscrite) {
		this.nombreJoursFranchiseAccidentSouscrite = nombreJoursFranchiseAccidentSouscrite;
	}

	public int getNombreJoursFranchiseHospitalisationSouscrite() {
		return nombreJoursFranchiseHospitalisationSouscrite;
	}

	public void setNombreJoursFranchiseHospitalisationSouscrite(int nombreJoursFranchiseHospitalisationSouscrite) {
		this.nombreJoursFranchiseHospitalisationSouscrite = nombreJoursFranchiseHospitalisationSouscrite;
	}

	public int getNombreJoursFranchiseMaladieBonifies() {
		return nombreJoursFranchiseMaladieBonifies;
	}

	public void setNombreJoursFranchiseMaladieBonifies(int nombreJoursFranchiseMaladieBonifies) {
		this.nombreJoursFranchiseMaladieBonifies = nombreJoursFranchiseMaladieBonifies;
	}

	public int getNombreJoursFranchiseAccidentBonifies() {
		return nombreJoursFranchiseAccidentBonifies;
	}

	public void setNombreJoursFranchiseAccidentBonifies(int nombreJoursFranchiseAccidentBonifies) {
		this.nombreJoursFranchiseAccidentBonifies = nombreJoursFranchiseAccidentBonifies;
	}

	public int getNombreJoursFranchiseHospitalisationBonifies() {
		return nombreJoursFranchiseHospitalisationBonifies;
	}

	public void setNombreJoursFranchiseHospitalisationBonifies(int nombreJoursFranchiseHospitalisationBonifies) {
		this.nombreJoursFranchiseHospitalisationBonifies = nombreJoursFranchiseHospitalisationBonifies;
	}
	

	public TypeFranchise getTypeFranchise() {
		return typeFranchise;
	}

	public void setTypeFranchise(TypeFranchise typeFranchise) {
		this.typeFranchise = typeFranchise;
	}

	public boolean isPresenceCession() {
		return presenceCession;
	}

	public void setPresenceCession(boolean presenceCession) {
		this.presenceCession = presenceCession;
	}
}
