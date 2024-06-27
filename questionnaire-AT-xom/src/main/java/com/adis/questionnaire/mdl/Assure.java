package com.adis.questionnaire.mdl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.adis.questionnaire.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Assure {

	private int ageAnniversaire;
	private int ageMillesime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private boolean bonificationDisponible = false;
	public Assure() {
	}

	public int getAgeAnniversaire() {
		return ageAnniversaire;
	}

	public void setAgeAnniversaire(int ageAnniversaire) {
		this.ageAnniversaire = ageAnniversaire;
	}

	public int getAgeMillesime() {
		return ageMillesime;
	}

	public void setAgeMillesime(int ageMillesime) {
		this.ageMillesime = ageMillesime;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean getBonificationDisponible() {
		return bonificationDisponible;
	}

	public void setBonificationDisponible(boolean bonificationDisponible) {
		this.bonificationDisponible = bonificationDisponible;
	}

	public String getAnneeDeAge(int age){
		Date dateAAge = DateUtils.decaleDate(dateNaissance, age, DateUtils.YEAR);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateAAge);
		int year = calendar.get(Calendar.YEAR);
		return String.valueOf(year);
	} 
	
}
