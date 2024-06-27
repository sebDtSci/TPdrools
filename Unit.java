package com.adis.rules.tp;

import org.drools.ruleunits.api.RuleUnitData;
import com.adis.questionnaire.mdl.Contexte;
import com.adis.questionnaire.mdl.MemoireInterne;
import com.adis.questionnaire.quest.Question;
import com.adis.questionnaire.quest.Questionnaire;
import com.adis.questionnaire.quest.Rubrique;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.SingletonStore;

public class Unit implements RuleUnitData {
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

    public Unit (){
        this.contexte = DataSource.createSingleton();
        this.variables = DataSource.createSingleton();
        this.questionnaire = DataSource.createSingleton();
        this.rubriques = DataSource.createStore();
        this.questions = DataSource.createStore();
    }