package questionnaire_test.gui;

import java.util.Collection;
import java.util.LinkedList;

import com.adis.questionnaire.quest.Questionnaire;
import com.adis.questionnaire.quest.Rubrique;

public class QuestionnaireUtilGui {

	public static Collection<Rubrique> getRubriquesAndInnerRubrique(Questionnaire questionnaire) {
		Collection<Rubrique> result = new LinkedList<>();
		for (Rubrique r : questionnaire.getRubriques()) {
			addRubrique(r, result);
		}
		return result;
	}

	private static void addRubrique(Rubrique rub, Collection<Rubrique> result) {
		result.add(rub);
		rub.getRubriques().forEach(r -> addRubrique(r, result));
	}
}
