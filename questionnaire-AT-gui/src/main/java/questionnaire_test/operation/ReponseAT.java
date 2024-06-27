package questionnaire_test.operation;

import com.adis.questionnaire.quest.Questionnaire;

import com.adis.questionnaire.mdl.EvaluationDemande;

public class ReponseAT {
    private String id;

    private EvaluationDemande evaluationDemande;
    private Questionnaire questionnaire;

    public EvaluationDemande getEvaluationDemande() {
        return evaluationDemande;
    }

    public void setEvaluationDemande(EvaluationDemande evaluationDemande) {
        this.evaluationDemande = evaluationDemande;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
