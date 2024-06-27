package com.adis.drools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class Dt2Drl {
    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(args).forEach(arg -> sb.append(arg).append(""));

        try (InputStream is = new FileInputStream(new File("C:\\Users\\ddiochot\\Documents\\Projet\\Adis_drools\\QuestionnaireAdis2\\questionnaire-drools\\questionnaire-AT-rules\\src\\main\\resources\\com\\adis\\rules\\_III_Evaluation\\_4_Calculs_Lies_Aux_Dates\\Calcul date limite de paiement ARC.drl.xlsx"))) {  // filename here (sb.toString())
            SpreadsheetCompiler sc = new SpreadsheetCompiler();
            String rules = sc.compile(is, InputType.XLS);
            System.out.println(rules);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
