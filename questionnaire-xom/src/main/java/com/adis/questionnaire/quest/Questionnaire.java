package com.adis.questionnaire.quest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Questionnaire {

	private List<Rubrique> rubriques = new LinkedList<>();
	private boolean complet = false;
	private boolean valide = false;


	public static final int DEBUT = 1;
	public static final int FIN = 2;

	public List<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}

	public Rubrique ajouterRubrique(String libelle, int position) {
		Rubrique result = null;
		Optional<Rubrique> findRubrique = findRubrique(new Rubrique(libelle));
		switch (position){
			case DEBUT:
				if (!findRubrique.isPresent()) {
					Rubrique rubrique = new Rubrique(libelle);
					rubriques.add(0, rubrique);
					result = rubrique;
				} else
					result = findRubrique.get();;
				break;
			default:
				if (!findRubrique.isPresent()) {
					Rubrique rubrique = new Rubrique(libelle);
					rubriques.add(rubrique);
					result = rubrique;
				} else
					result = findRubrique.get();
				break;
		}
		
		return result;
	}
	public Rubrique ajouterRubrique(String libelle) {
		return ajouterRubrique(libelle, 0);
	}
	
	public Rubrique ajouterRubriqueApres(String libelle, Rubrique cible) {
		Rubrique result = null;
		Optional<Rubrique> findRubrique = findRubrique(new Rubrique(libelle));
		if (!findRubrique.isPresent()) {
			Rubrique rubrique = new Rubrique(libelle);
			rubriques.add(rubriques.indexOf(cible)+1, rubrique);
			result = rubrique;
		} else
			result = findRubrique.get();
		return result;
	}

	@JsonIgnore
	public boolean evalCompletude() {
		return rubriques.isEmpty() || rubriques.stream().allMatch(r -> r.isComplete());
	}

	private Optional<Rubrique> findRubrique(Rubrique rubrique) {
		return rubriques.stream().filter(r -> r.equals(rubrique)).findFirst();
	}

	public void nettoyer() {
		Iterator<Rubrique> it = rubriques.iterator();
		while (it.hasNext()) {
			Rubrique rubrique = it.next();
			rubrique.nettoyer();
			if (rubrique.isStale() || rubrique.estVide()) {
					it.remove();
			}
		}
	}

	public boolean isComplet() {
		return complet;
	}

	public void setComplet(boolean complet) {
		this.complet = complet;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
}
