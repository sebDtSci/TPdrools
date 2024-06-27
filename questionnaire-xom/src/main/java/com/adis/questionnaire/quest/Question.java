package com.adis.questionnaire.quest;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.adis.questionnaire.util.GenUID;

public class Question {

	private String libelle;
	private String id;
	private TypeQuestion type;

	private boolean obligatoire = true;
	private boolean reponseNeSaisPasPossible = false;
	private String commentaire;

	@JsonIgnore
	private boolean stale = true;

	private List<Reponse> reponsesProposees = new LinkedList<>();

	private List<Reponse> reponsesSelections = new LinkedList<>();

	public Question() {
	}

	public Question(String libelle, TypeQuestion typeQuestion) {
		this(libelle, GenUID.getUID(libelle), typeQuestion);
	}

	public Question(String libelle, String id, TypeQuestion typeQuestion) {
		super();
		this.libelle = libelle;
		this.id = id;
		this.type = typeQuestion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public TypeQuestion getType() {
		return type;
	}

	public void setType(TypeQuestion type) {
		this.type = type;
	}

	public void setObligatoire(boolean obligatoire) {
		this.obligatoire = obligatoire;
	}

	public boolean isObligatoire() {
		return obligatoire;
	}

	public boolean isReponseNeSaisPasPossible() {
		return reponseNeSaisPasPossible;
	}

	public void setReponseNeSaisPasPossible(boolean value) {
		this.reponseNeSaisPasPossible = value;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public List<Reponse> getReponsesProposees() {
		return reponsesProposees;
	}

	public void setReponsesProposees(List<Reponse> reponsesProposees) {
		this.reponsesProposees = reponsesProposees;
	}

	public List<Reponse> getReponsesSelections() {
		return reponsesSelections;
	}

	public void setReponsesSelections(List<Reponse> reponsesSelections) {
		this.reponsesSelections = reponsesSelections;
	}

	public void ajouterReponseProposee(String[] libelles) {
		for (String libelle : libelles) {
			ajouterReponseProposee(libelle);
		}
	}

	public void ajouterReponseProposee(String libelle) {
		Reponse reponse = new Reponse(libelle);
		if (!reponsesProposees.contains(reponse)) {
			reponsesProposees.add(reponse);
		}
	}
	
	public void ajouterReponseProposee(String libelle, String iD) {
		Reponse reponse = new Reponse(libelle, iD);
		if (!reponsesProposees.contains(reponse)) {
			reponsesProposees.add(reponse);
		}
	}
	
	public void ajouterReponseProposeeApres(String libelle, Reponse cible) {
		Reponse reponse = new Reponse(libelle);
		if (!reponsesProposees.contains(reponse)) {
			reponsesProposees.add(reponsesProposees.indexOf(cible), reponse);
		}
	}

	public void ajouterReponseSelectionnee(Reponse reponse) {
		if (!reponsesSelections.contains(reponse)) {
			reponsesSelections.add(reponse);
		}
	}

	@JsonIgnore
	public Reponse getReponseSelectionnee() {
		if (type.equals(TypeQuestion.CHOIX_MULTIPLE))
			throw new IllegalAccessError("Question [" + libelle + "] est une question à choix multiple");

		return reponsesSelections.stream().findFirst().orElse(null);
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Question == false)
			return false;
		Question other = (Question) o;
		return id.equals(other.getId());
	}
	
	public void supReponses() {
		reponsesProposees.clear();
	}
	
	public void supReponse(String libelle) {
		Reponse reponse = new Reponse(libelle);
		reponsesProposees.remove(reponse);
	}
	
	public void deplaceReponseAFin(String libelle) {
		Reponse reponse = new Reponse(libelle);
		Reponse temp = reponsesProposees.get(reponsesProposees.size()-1);
		int pos = reponsesProposees.indexOf(reponse);
		reponsesProposees.set(reponsesProposees.size()-1, reponse);
		reponsesProposees.set(pos, temp);
	}
}
