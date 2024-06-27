package com.adis.questionnaire.util;

import java.util.Date;

import com.adis.questionnaire.quest.Reponse;

public class ReponseFormatter {


	public static Date toDate(Reponse reponse) {
		Date result = null;
		result = DateUtils.buildDate(reponse.getLibelle());
		return result;
	}

	public static int toInt(Reponse reponse) {
		return Integer.parseInt(reponse.getLibelle());
	}

	public static double toDouble(Reponse reponse) {
		return Double.parseDouble(reponse.getLibelle());
	}
}
