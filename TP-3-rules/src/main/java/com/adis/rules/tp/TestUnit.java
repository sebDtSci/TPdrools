package com.adis.rules.tp;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

import com.adis.questionnaire.quest.Question;
import com.adis.questionnaire.quest.Questionnaire;
import com.adis.questionnaire.quest.Rubrique;

import com.adis.questionnaire.mdl.Contexte;
import com.adis.questionnaire.mdl.MemoireInterne;

public class TestUnit implements RuleUnitData {

    private SingletonStore<Contexte> contexte;
    private SingletonStore<MemoireInterne> variables;

    private SingletonStore<Questionnaire> questionnaire;
    
    private DataStore<Rubrique> rubriques;
    private DataStore<Question> questions;
    
    protected TestUnit(SingletonStore<Contexte> contexte, SingletonStore<MemoireInterne> variables,
            SingletonStore<Questionnaire> questionnaire,
            DataStore<Rubrique> rubriques, DataStore<Question> questions) {
        this.contexte = contexte;
        this.variables = variables;
        this.questionnaire = questionnaire;
        this.rubriques = rubriques;
        this.questions = questions;
    }

    public TestUnit() {
    	this(DataSource.createSingleton(), DataSource.createSingleton(), DataSource.createSingleton(),
    			DataSource.createStore(), DataSource.createStore());
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

    public SingletonStore<Questionnaire> getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(SingletonStore<Questionnaire> questionnaire) {
        this.questionnaire = questionnaire;
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
