package com.adis.drools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class Dt2Drl {
    public static void main(String[] args) {
       
        try (InputStream is = new FileInputStream(new File("TP-3-rules\\src\\main\\resources\\com\\adis\\rules\\tp\\[TD] Question sport.drl.xlsx"))) {  
            SpreadsheetCompiler sc = new SpreadsheetCompiler();
            String rules = sc.compile(is, InputType.XLS);
            System.out.println(rules);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
