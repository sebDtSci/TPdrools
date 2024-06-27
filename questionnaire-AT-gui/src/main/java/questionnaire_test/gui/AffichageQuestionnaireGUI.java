package questionnaire_test.gui;

import java.awt.Color;

import com.adis.questionnaire.quest.Question;
import com.adis.questionnaire.quest.Questionnaire;
import com.adis.questionnaire.quest.Reponse;
import com.adis.questionnaire.quest.Rubrique;
import com.adis.questionnaire.quest.TypeQuestion;

import questionnaire_test.gui.console.Console;
import questionnaire_test.gui.console.Message;

public class AffichageQuestionnaireGUI {

	public static final String ETIQUETTE_RUBRIQUE = "-------";
	public static final String ETIQUETTE_QUESTION = "     ";
	public static final String ETIQUETTE_REPONSE = "        >";
	public static final String ETIQUETTE_REPONSE_SELECTION = "         =>";

	private Questionnaire questionnaire;

	public AffichageQuestionnaireGUI(Questionnaire questionnaire) {
		super();
		this.questionnaire = questionnaire;
	}

	public void display() {
		int niveauRubrique = 1;
		for (Rubrique r : questionnaire.getRubriques()) {
			displayRubrique(r, niveauRubrique);
		}
	}

	private String prefixNiveau(String s, int nb) {
		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < nb * ETIQUETTE_RUBRIQUE.length(); ++k)
			sb.append(" ");
		sb.append(s);
		return sb.toString();
	}

	private void displayRubrique(Rubrique r, int niveauRubrique) {

		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < niveauRubrique; ++k)
			sb.append(ETIQUETTE_RUBRIQUE);

		Console.getInstance().addMessage(Message.buildMessage(sb.toString() + r.getLibelle(), r));

		for (Question q : r.getQuestions()) {
			displayQuestion(q, niveauRubrique);
		}

		// display inner rubriques
		niveauRubrique++;
		for (Rubrique innerRubrique : r.getRubriques()) {
			displayRubrique(innerRubrique, niveauRubrique);
		}
	}

	private void displayQuestion(Question q, int niveau) {
		String additional_info = "";
		if (q.isReponseNeSaisPasPossible()) additional_info = "_NSP";
		String obligatoire = "";
		if (q.isObligatoire()) obligatoire = " *";
		Console.getInstance().addMessage(Message.buildMessage(
				prefixNiveau(ETIQUETTE_QUESTION, niveau) + q.getLibelle() + " [" + q.getType().toString() + additional_info + "]" + obligatoire, q));
		for (Reponse r : q.getReponsesProposees()) {
			Console.getInstance()
					.addMessage(Message.buildMessage(prefixNiveau(ETIQUETTE_REPONSE, niveau) + r.getLibelle(), r));
		}

		if (q.isReponseNeSaisPasPossible()){
			Console.getInstance()
					.addMessage(Message.buildMessage(prefixNiveau(ETIQUETTE_REPONSE, niveau) + "NSP", new Reponse("NSP", TypeQuestion.NeSaisPas.ID)));
		}

		for (Reponse r : q.getReponsesSelections()) {
			Console.getInstance().addMessage(Message
					.buildMessage(prefixNiveau(ETIQUETTE_REPONSE_SELECTION, niveau) + r.getLibelle(), Color.MAGENTA));
		}
	}
}
