package com.adis.questionnaire.quest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.adis.questionnaire.util.GenUID;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Rubrique {

	private String libelle;
	private String id;

	@JsonIgnore
	private boolean stale = true;

	private List<Question> questions = new LinkedList<>();

	private List<Rubrique> rubriques = new LinkedList<>();

	public Rubrique() {
	}

	public Rubrique(String libelle) {
		this(libelle, GenUID.getUID(libelle));
	}

	public Rubrique(String libelle, String id) {
		super();
		this.libelle = libelle;
		this.id = id;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}

	@JsonIgnore
	public boolean isComplete() {
		return questions.stream().filter(q -> q.isObligatoire() && q.getReponsesSelections().isEmpty() == true)
				.count() == 0 &&
				rubriques.stream().allMatch(r -> r.isComplete());
	}

	public Question ajouterQuestion(String libelle, TypeQuestion type) {
		return ajouterQuestion(libelle, GenUID.getUID(libelle), type);
	}

	public Question ajouterQuestion(String libelle, String id, TypeQuestion type) {
		Question question = new Question(libelle, id, type);
		Optional<Question> findQuestion = findQuestion(question);
		if (!findQuestion.isPresent()) {
			if (question.getType().equals(TypeQuestion.OUI_NON)) {
				question.ajouterReponseProposee(TypeQuestion.OuiNon.LibelleReponse.OUI);
				question.ajouterReponseProposee(TypeQuestion.OuiNon.LibelleReponse.NON);
			}
			questions.add(question);
		} else
			question = findQuestion.get();

		return question;
	}
	
	private Optional<Question> findQuestion(Question question) {
		return questions.stream().filter(q -> q.equals(question)).findFirst();
	}

	public Rubrique ajouterRubrique(String libelle, Position position, String libelleAutreRubrique) {
		Rubrique result = null;
		Optional<Rubrique> findRubrique = findRubrique(new Rubrique(libelle));
		if (!findRubrique.isPresent()) {
			Optional<Rubrique> autreRubrique = findRubrique(new Rubrique(libelleAutreRubrique));
			if (autreRubrique.isPresent()) {
				int indexOf = rubriques.indexOf(autreRubrique.get());
				Rubrique rubrique = new Rubrique(libelle);
				if (position == Position.APRES) {
					indexOf++;
				}
				rubriques.add(indexOf, rubrique);
				result = rubrique;
			} else
				result = ajouterRubrique(libelle);
		} else
			result = findRubrique.get();
		return result;
	}

	public Rubrique ajouterRubrique(String libelle) {
		Rubrique result = null;
		Optional<Rubrique> findRubrique = findRubrique(new Rubrique(libelle));
		if (!findRubrique.isPresent()) {
			Rubrique rubrique = new Rubrique(libelle);
			rubriques.add(rubrique);
			result = rubrique;
		} else
			result = findRubrique.get();
		return result;
	}

	private Optional<Rubrique> findRubrique(Rubrique rubrique) {
		return rubriques.stream().filter(r -> r.equals(rubrique)).findFirst();

	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Rubrique == false)
			return false;
		Rubrique other = (Rubrique) o;
		return id.equals(other.getId());
	}

	public void nettoyer() {
		Iterator<Question> itQuestion = questions.iterator();
		while (itQuestion.hasNext()) {
			Question question = itQuestion.next();
			if (question.isStale()) {
				itQuestion.remove();
			}
		}

		Iterator<Rubrique> itRubrique = rubriques.iterator();
		while (itRubrique.hasNext()) {
			Rubrique rubrique = itRubrique.next();
			rubrique.nettoyer();
			if (rubrique.isStale() || rubrique.estVide()) {
				itRubrique.remove();
			}
		}
	}

	public boolean estVide() {
		return this.questions.isEmpty()&&this.rubriques.isEmpty();
	}
	
	public void deplacerQuestion(Question question, Position position) {
		if (position != Position.AU_DEBUT && position != Position.A_LA_FIN)
				throw new IllegalArgumentException("deplacer question : " + position);
		if (questions.remove(question)) {
			if (position == Position.AU_DEBUT) {
				questions.add(0, question);
			}
			else if (position == Position.A_LA_FIN) {
				questions.add(questions.size(), question);
			}
		}
	}
	public void deplacerQuestion(Question question, Position position, Question cible) {
		if (position != Position.APRES && position != Position.AVANT)
			throw new IllegalArgumentException("deplacer question par rapport cible: " + position);
		if (questions.remove(question)) {
			if (position == Position.APRES) {
				questions.add(questions.indexOf(cible) + 1, question);
			}
			else if (position == Position.AVANT) {
				questions.add(questions.indexOf(cible), question);
			}
		}
	}
}
