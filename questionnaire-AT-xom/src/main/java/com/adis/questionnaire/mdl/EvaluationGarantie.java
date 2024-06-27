package com.adis.questionnaire.mdl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.adis.questionnaire.domaine.Alerte;
import com.adis.questionnaire.domaine.TypeGarantie;
import com.adis.questionnaire.domaine.TypeMotifOrientation;
import com.adis.questionnaire.domaine.TypeOrientation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EvaluationGarantie {

	private TypeOrientation orientation = TypeOrientation.DEFAUT;
	private List<TypeMotifOrientation> motifsOrientation = new LinkedList<TypeMotifOrientation>();
	private List<Alerte> alertes = new LinkedList<Alerte>();

	// franchise
	private int nombreJoursFranchiseAccident;
	private int nombreJoursFranchiseHospitalisation;
	private int nombreJoursFranchiseMaladie;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDebutPaiementAT;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFinPaiementAT;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDebutPaiementHospi;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFinPaiementHospi;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateLimitePaiement;

	@JsonIgnore
	private Garantie garantieEvaluee;
	private String labelGarantie = "";
	private String codeGarantie = "";
	private TypeGarantie typeGarantie = TypeGarantie.DEFAUT;

	// AT/Hospi
	private String choix = "";

	private Integer nombreJoursFranchiseAAppliquerHospi;
	@JsonIgnore
	private boolean franchiseHospiApplicable = false;

	private int nombreJoursFranchiseAAppliquerHorsHospi;

	public EvaluationGarantie(Garantie garantieEvaluee) {
		this.garantieEvaluee = garantieEvaluee;
	}

	public EvaluationGarantie() {
	}

	public TypeOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(TypeOrientation orientation) {
		this.orientation = orientation;
	}

	public List<TypeMotifOrientation> getMotifsOrientation() {
		return motifsOrientation;
	}

	public void setMotifsOrientation(List<TypeMotifOrientation> motifsOrientation) {
		this.motifsOrientation = motifsOrientation;
	}

	public void ajouterMotifOrientation(TypeMotifOrientation motif) {
		this.motifsOrientation.add(motif);
	}

	public List<Alerte> getAlertes() {
		return alertes;
	}

	public void setAlertes(List<Alerte> alertes) {
		this.alertes = alertes;
	}

	public void addAlerte(Alerte alerte){
		this.alertes.add(alerte);
	}

	public int getNombreJoursFranchiseAccident() {
		return nombreJoursFranchiseAccident;
	}

	public void setNombreJoursFranchiseAccident(int nombreJoursFranchiseAccident) {
		this.nombreJoursFranchiseAccident = nombreJoursFranchiseAccident;
	}

	public int getNombreJoursFranchiseHospitalisation() {
		return nombreJoursFranchiseHospitalisation;
	}

	public void setNombreJoursFranchiseHospitalisation(int nombreJoursFranchiseHospitalisation) {
		this.nombreJoursFranchiseHospitalisation = nombreJoursFranchiseHospitalisation;
	}

	public int getNombreJoursFranchiseMaladie() {
		return nombreJoursFranchiseMaladie;
	}

	public void setNombreJoursFranchiseMaladie(int nombreJoursFranchiseMaladie) {
		this.nombreJoursFranchiseMaladie = nombreJoursFranchiseMaladie;
	}

	public Date getDateDebutPaiementAT() {
		return dateDebutPaiementAT;
	}

	public void setDateDebutPaiementAT(Date dateDebutPaiementAT) {
		this.dateDebutPaiementAT = dateDebutPaiementAT;
	}

	public Date getDateFinPaiementAT() {
		return dateFinPaiementAT;
	}

	public void setDateFinPaiementAT(Date dateFinPaiementAT) {
		this.dateFinPaiementAT = dateFinPaiementAT;
	}

	public Date getDateDebutPaiementHospi() {
		return dateDebutPaiementHospi;
	}

	public void setDateDebutPaiementHospi(Date dateDebutPaiementHospi) {
		this.dateDebutPaiementHospi = dateDebutPaiementHospi;
	}

	public Date getDateFinPaiementHospi() {
		return dateFinPaiementHospi;
	}

	public void setDateFinPaiementHospi(Date dateFinPaiementHospi) {
		this.dateFinPaiementHospi = dateFinPaiementHospi;
	}

	public Date getDateLimitePaiement() {
		return dateLimitePaiement;
	}

	public void setDateLimitePaiement(Date dateLimitePaiement) {
		this.dateLimitePaiement = dateLimitePaiement;
	}

	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public Integer getNombreJoursFranchiseAAppliquerHospi() {
		return nombreJoursFranchiseAAppliquerHospi;
	}

	public void setNombreJoursFranchiseAAppliquerHospi(Integer nombreJoursFranchiseAAppliquerHospi) {
		this.nombreJoursFranchiseAAppliquerHospi = nombreJoursFranchiseAAppliquerHospi;
	}

	public int getNombreJoursFranchiseAAppliquerHorsHospi() {
		return nombreJoursFranchiseAAppliquerHorsHospi;
	}

	public void setNombreJoursFranchiseAAppliquerHorsHospi(int nombreJoursFranchiseAAppliquerHorsHospi) {
		this.nombreJoursFranchiseAAppliquerHorsHospi = nombreJoursFranchiseAAppliquerHorsHospi;
	}

	public String getLabelGarantie() {
		return labelGarantie;
	}

	public void setLabelGarantie(String labelGarantie) {
		this.labelGarantie = labelGarantie;
	}

	public String getCodeGarantie() {
		return codeGarantie;
	}

	public void setCodeGarantie(String codeGarantie) {
		this.codeGarantie = codeGarantie;
	}

	public TypeGarantie getTypeGarantie() {
		return typeGarantie;
	}

	public void setTypeGarantie(TypeGarantie typeGarantie) {
		this.typeGarantie = typeGarantie;
	}

	public Garantie getGarantieEvaluee() {
		return garantieEvaluee;
	}

	public void setGarantieEvaluee(Garantie garantie) {
		this.garantieEvaluee = garantie;
		setCodeGarantie(garantie.getCode());
		setTypeGarantie(garantie.getType());
		// TODO labelGarantie
	}

	
	public boolean isFranchiseHospiApplicable() {
		return franchiseHospiApplicable;
	}

	public void setFranchiseHospiApplicable(boolean franchiseHospiApplicable) {
		this.franchiseHospiApplicable = franchiseHospiApplicable;
	}
}
