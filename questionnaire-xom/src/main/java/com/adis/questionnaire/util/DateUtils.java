package com.adis.questionnaire.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class DateUtils {
	public static final int YEAR = 1;	
	public static final int MONTH = 2;
	public static final int DAY = 4;



	public static Date decaleDate(Date date, int value, int field) {
		if (date == null){
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch(field){
			case YEAR: cal.add(Calendar.YEAR, value); break;
			case MONTH: cal.add(Calendar.MONTH, value); break;
			case DAY: cal.add(Calendar.DAY_OF_MONTH, value); break;
		}
		
		return cal.getTime();
	}

	public static int nombreDeJourEntre2Dates(Date debut, Date fin) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(debut);

		LocalDateTime fromDate = LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

		cal.setTime(fin);
		LocalDateTime toDate = LocalDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		long differenceInDays = ChronoUnit.DAYS.between(fromDate, toDate);

		// cas ou date debut <= date fin
		if (differenceInDays >= 0)
			return (int) differenceInDays + 1;
		else
			return (int) differenceInDays - 1;

	}

	public static boolean isAnterior(Date dateA, Date dateB) {
		if (dateA == null || dateB == null){
			return false;
		}
		return dateA.compareTo(dateB) < 0;
	}

	public static Date min(Date ...argsDate) {
		return Arrays.asList(argsDate).stream().filter(Objects::nonNull).min(Date::compareTo).orElse(null);
	}


	public static Date min(Date dateA, Date dateB) {
		if (DateUtils.isAnterior(dateA,dateB)){
			return dateA;
		} else {
			return dateB;
		}
	}

	public static Date max(Date dateA, Date dateB) {
		if (DateUtils.isAnterior(dateA,dateB)){
			return dateB;
		} else {
			return dateA;
		}
	}

	public static Date buildDate(String s) {
		try {
			return getDateFormat().parse(s);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public static String format(Date d) {
		if (d == null) return "nulle";
		return getDateFormat().format(d);
	}

	public static SimpleDateFormat getDateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormat;
	}
}
