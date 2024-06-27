package com.adis.rules.tp;

// import org.kie.kogito.rules.RuleUnitData;
import org.drools.ruleunits.api.RuleUnitData;
import com.adis.questionnaire.mdl.Contexte;
import com.adis.questionnaire.mdl.MemoireInterne;
import com.adis.questionnaire.quest.Question;
import com.adis.questionnaire.quest.Questionnaire;
import com.adis.questionnaire.quest.Rubrique;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.SingletonStore;

public class TestUnit implements RuleUnitData {
    private SingletonStore<Contexte> contexte;
    private SingletonStore<MemoireInterne> variables;
    private SingletonStore<Questionnaire> questionnaire;
    public SingletonStore<Questionnaire> getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(SingletonStore<Questionnaire> questionnaire) {
        this.questionnaire = questionnaire;
    }

    private DataStore<Rubrique> rubriques;
    private DataStore<Question> questions;

    public TestUnit (){
        this.contexte = DataSource.createSingleton();
        this.variables = DataSource.createSingleton();
        this.questionnaire = DataSource.createSingleton();
        this.rubriques = DataSource.createStore();
        this.questions = DataSource.createStore();
    }

    public SingletonStore<Contexte> getContexte() {
        return contexte;
    }

    public void setContexte(SingletonStore<Contexte> contexte) {
        this.contexte = contexte;
    }

    public SingletonStore<MemoireInterne> getVariables() {
        return variables;
    }

    public void setVariables(SingletonStore<MemoireInterne> variables) {
        this.variables = variables;
    }

    public DataStore<Rubrique> getRubriques() {
        return rubriques;
    }

    public void setRubriques(DataStore<Rubrique> rubriques) {
        this.rubriques = rubriques;
    }

    public DataStore<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(DataStore<Question> questions) {
        this.questions = questions;
    }

    
}
