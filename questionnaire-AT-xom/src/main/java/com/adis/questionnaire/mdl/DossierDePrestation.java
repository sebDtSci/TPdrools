package com.adis.questionnaire.mdl;
import com.adis.questionnaire.domaine.Alerte;
import com.adis.questionnaire.domaine.TypeMotifOrientation;
import com.adis.questionnaire.domaine.TypeOrientation;

import java.util.LinkedList;
import java.util.List;


public class DossierDePrestation {


    private String numeroAdhesion;
    private boolean dossierDirecteur = false;

    private TypeOrientation orientation = TypeOrientation.DEFAUT;
    private List<TypeMotifOrientation> motifsOrientation = new LinkedList<TypeMotifOrientation>();
    private List<Alerte> alertes = new LinkedList<Alerte>();

    private List<EvaluationGarantie> evaluationsGarantie = new LinkedList<EvaluationGarantie>();

    private int nombreJoursFranchiseNotice;
    private int nbJoursBonifies = 0;
    
    public DossierDePrestation() {
    }

    public String getNumeroAdhesion() {
        return numeroAdhesion;
    }

    public void seNumerotAdhesion(String numeroAdhesion) {
        this.numeroAdhesion = numeroAdhesion;
    }

    public boolean getDossierDirecteur() {
        return dossierDirecteur;
    }

    public void setDossierDirecteur(boolean dossierDirecteur) {
        this.dossierDirecteur = dossierDirecteur;
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

    public void setNumeroAdhesion(String numeroAdhesion) {
        this.numeroAdhesion = numeroAdhesion;
    }

    public List<EvaluationGarantie> getEvaluationsGarantie() {
        return evaluationsGarantie;
    }

    public void setEvaluationsGarantie(List<EvaluationGarantie> evaluationsGarantie) {
        this.evaluationsGarantie = evaluationsGarantie;
    }
    
	public int getNombreJoursFranchiseNotice() {
		return nombreJoursFranchiseNotice;
	}

	public void setNombreJoursFranchiseNotice(int nombreJoursFranchiseNotice) {
		this.nombreJoursFranchiseNotice = nombreJoursFranchiseNotice;
	}

    public int getNbJoursBonifies() {
        return nbJoursBonifies;
    }

    public void setNbJoursBonifies(int nbJoursBonifies) {
        this.nbJoursBonifies = nbJoursBonifies;
    }

}
