package com.adis.questionnaire.mdl;


import com.adis.questionnaire.domaine.CodePathologique;

public class MemoireInterne {

	private boolean bloquant = false;
	private String origineArretDeTravail = "";
	private CodePathologique codePatho = CodePathologique.DEFAUT;
	private int dureeITTSansPM = 0;
	private boolean regleAllegee = false;
	private int cumulNbClassesIPR;
	private int cumulNbClassesRFP;
	private int dureeHospi;
	private boolean hospitalisation = false;
	private boolean dossierDirecteurSet = false;


	public boolean isBloquant() {
		return bloquant;
	}

	public void setBloquant(boolean bloquant) {
		this.bloquant = bloquant;
	}

	public String getOrigineArretDeTravail() {
		return origineArretDeTravail;
	}
	
	public void setOrigineArretDeTravail(String origineArretDeTravail) {
		this.origineArretDeTravail = origineArretDeTravail;
	}

	public CodePathologique getCodePatho() {
		return codePatho;
	}

	public void setCodePatho(CodePathologique codePatho) {
		this.codePatho = codePatho;
	}

	public int getDureeITTSansPM() {
		return dureeITTSansPM;
	}

	public void setDureeITTSansPM(int dureeITTSansPM) {
		this.dureeITTSansPM = dureeITTSansPM;
	}

	public int getCumulNbClassesIPR() {
		return cumulNbClassesIPR;
	}

	public void setCumulNbClassesIPR(int cumulNbClassesIPR) {
		this.cumulNbClassesIPR = cumulNbClassesIPR;
	}

	public int getCumulNbClassesRFP() {
		return cumulNbClassesRFP;
	}

	public void setCumulNbClassesRFP(int cumulNbClassesRFP) {
		this.cumulNbClassesRFP = cumulNbClassesRFP;
	}
	public int getDureeHospi() {
		return dureeHospi;
	}
	
	public void setDureeHospi(int dureeHospi) {
		this.dureeHospi = dureeHospi;
	}

	public boolean isHospitalisation() {
		return hospitalisation;
	}

	public void setHospitalisation(boolean hospitalisation) {
		this.hospitalisation = hospitalisation;
	}

	public boolean isRegleAllegee() {
		return regleAllegee;
	}

	public void setRegleAllegee(boolean regleAllegee) {
		this.regleAllegee = regleAllegee;
	}

	public boolean isDossierDirecteurSet() {
		return dossierDirecteurSet;
	}

	public void setDossierDirecteurSet(boolean dossierDirecteurSet) {
		this.dossierDirecteurSet = dossierDirecteurSet;
	}

}