package questionnaire_test.operation;

import com.adis.questionnaire.mdl.Contexte;
import com.adis.questionnaire.quest.Questionnaire;

public class RequeteAt {

    private Contexte contexte;
	private Questionnaire questionnaire;

	
	public Contexte getContexte() {
		return contexte;
	}

	public void setContexte(Contexte contexte) {
		this.contexte = contexte;
	}

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public RequeteAt(Contexte contexte, Questionnaire questionnaire) {
        this.contexte = contexte;
        this.questionnaire = questionnaire;
    }

}
