package com.adis.questionnaire.quest;

public enum TypeQuestion {

	CHOIX_MULTIPLE,
	CHOIX_UNIQUE_RADIO,
	CHOIX_UNIQUE_LISTE,
	SAISIR_TEXTE_COURT,
	SAISIR_TEXTE_LONG,
	SAISIR_DATE,
	SAISIR_NOMBRE,
	SAISIR_ADRESSE,
	OUI_NON,
	OUI_NON_JENESAISPAS;

	public static class OuiNon {
		public static class LibelleReponse {
			public static String OUI = "Oui";
			public static String NON = "Non";
		}
	}

	public static class NeSaisPas{
		public static String ID = "NSP";
	}
}
