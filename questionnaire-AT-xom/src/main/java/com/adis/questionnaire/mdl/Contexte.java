package com.adis.questionnaire.mdl;

import java.util.LinkedList;
import java.util.List;

public class Contexte {

	private DemandeDePrestation demandeDePrestation;
	private Assure assure;
	private List<Adhesion> adhesions = new LinkedList<>();

	public Contexte() {
	}
	public Assure getAssure() {
		return assure;
	}

	public void setAssure(Assure assure) {
		this.assure = assure;
	}

	public DemandeDePrestation getDemandeDePrestation() {
		return demandeDePrestation;
	}

	public void setDemandeDePrestation(DemandeDePrestation demandeDePrestation) {
		this.demandeDePrestation = demandeDePrestation;
	}

	public List<Adhesion> getAdhesions() {
		return adhesions;
	}

	public void setAdhesions(List<Adhesion> adhesions) {
		this.adhesions = adhesions;
	}

}
