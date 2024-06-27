package com.adis.questionnaire.mdl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.adis.questionnaire.domaine.Alerte;
import com.adis.questionnaire.domaine.CodePathologique;
import com.adis.questionnaire.domaine.TypeArretTravail;
import com.adis.questionnaire.domaine.TypeMotifOrientation;
import com.adis.questionnaire.domaine.TypeOrientation;
import com.adis.questionnaire.domaine.TypeSortie;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EvaluationDemande {

	private TypeSortie sortie = TypeSortie.NON_CONNUE;
	private TypeOrientation orientation = TypeOrientation.DEFAUT;
	private List<TypeMotifOrientation> motifsOrientation = new LinkedList<TypeMotifOrientation>();
	private List<Alerte> alertes = new LinkedList<Alerte>();

	private CodePathologique codePathologique;
	private TypeArretTravail typeAT = TypeArretTravail.DEFAUT;
	
	private Integer dureeAT;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date dateDebutAT;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "UTC")
	private Date dateFinAT;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date datePresumeeAccouchement;
	private Integer dureeITTSansPM;

	@JsonIgnore
	private boolean regleAllegee = false;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateCalculeeAccouchement;
	@JsonIgnore
	private Date dateAccouchement;

	private Integer dureeHospitalisation;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateDebutHospi;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFinHospi;

	private int cumulNbClassesIPR;
	private int cumulNbClassesRFP;
	private EvenementMedical evenementMedical;
	private List<DossierDePrestation> dossiersDePrestation = new LinkedList<>();

	public EvaluationDemande() {
	}

	public TypeSortie getSortie() {
		return sortie;
	}

	public void setSortie(TypeSortie sortie) {
		this.sortie = sortie;
	}

	public List<DossierDePrestation> getDossiersDePrestation() {
		return dossiersDePrestation;
	}

	public void setDossiersDePrestation(List<DossierDePrestation> dossiersDePrestation) {
		this.dossiersDePrestation = dossiersDePrestation;
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
	
	public CodePathologique getCodePathologique() {
		return codePathologique;
	}

	public void setCodePathologique(CodePathologique codePathologique) {
		this.codePathologique = codePathologique;
	}

	public TypeArretTravail getTypeAT() {
		return typeAT;
	}

	public void setTypeAT(TypeArretTravail typeAT) {
		this.typeAT = typeAT;
	}

	public Integer getDureeAT() {
		return dureeAT;
	}

	public void setDureeAT(Integer dureeAT) {
		this.dureeAT = dureeAT;
	}

	public Date getDateDebutAT() {
		return dateDebutAT;
	}

	public void setDateDebutAT(Date dateDebutAT) {
		this.dateDebutAT = dateDebutAT;
	}

	public Date getDateFinAT() {
		return dateFinAT;
	}

	public void setDateFinAT(Date dateFinAT) {
		this.dateFinAT = dateFinAT;
	}

	public Date getDatePresumeeAccouchement() {
		return datePresumeeAccouchement;
	}

	public void setDatePresumeeAccouchement(Date datePresumeeAccouchement) {
		this.datePresumeeAccouchement = datePresumeeAccouchement;
	}

	public Integer getDureeITTSansPM() {
		return dureeITTSansPM;
	}

	public void setDureeITTSansPM(Integer dureeITTSansPM) {
		this.dureeITTSansPM = dureeITTSansPM;
	}

	public boolean getRegleAllegee() {
		return regleAllegee;
	}

	public void setRegleAllegee(boolean regleAllegee) {
		this.regleAllegee = regleAllegee;
	}

	public Integer getDureeHospitalisation() {
		return dureeHospitalisation;
	}

	public void setDureeHospitalisation(Integer dureeHospitalisation) {
		this.dureeHospitalisation = dureeHospitalisation;
	}

	public Date getDateDebutHospi() {
		return dateDebutHospi;
	}

	public void setDateDebutHospi(Date dateDebutHospi) {
		this.dateDebutHospi = dateDebutHospi;
	}

	public Date getDateFinHospi() {
		return dateFinHospi;
	}

	public void setDateFinHospi(Date dateFinHospi) {
		this.dateFinHospi = dateFinHospi;
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

	public EvenementMedical getEvenementMedical() {
		return evenementMedical;
	}

	public void setEvenementMedical(EvenementMedical evenementMedical) {
		this.evenementMedical = evenementMedical;
	}

	public Date getDateCalculeeAccouchement() {
		return dateCalculeeAccouchement;
	}

	public void setDateCalculeeAccouchement(Date dateCalculeeAccouchement) {
		this.dateCalculeeAccouchement = dateCalculeeAccouchement;
	}

	public Date getDateAccouchement() {
		return dateAccouchement;
	}

	public void setDateAccouchement(Date dateAccouchement) {
		this.dateAccouchement = dateAccouchement;
	}
}
