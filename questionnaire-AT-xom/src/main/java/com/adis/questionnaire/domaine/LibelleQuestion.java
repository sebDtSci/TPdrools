package com.adis.questionnaire.domaine;

public class LibelleQuestion {


	public static class Administratif {
		public static String REASSURANCE = "Est-ce que les garanties IC sont réassurées ?";
		public static String BONIFICATION = "Le client souhaite-t'il utiliser la bonification ?";
		public static String EST_SALARIE = "Est ce que l'assuré est salarié ?";
		public static String ECHEANCE_CONSTANTE = "Echéance constante ?";
	}

	public static class ArretDeTravail {
		public static String TYPE_AT = "Type de l'arrêt de travail";
		public static String ORIGINE = "Origine de l'arrêt de travail";
		public static String DATE_DEBUT = "Date de début de l'arrêt de travail";
		public static String DATE_FIN = "Date de fin de l'arrêt de travail";
		public static String AT_SUCCESSIFS = "Les arrêts de travail se suivent-ils ?";
		public static String MI_TEMP_THERA = "Mi-temps thérapeutique";
		public static String INFO_DATE = "A-t'on les informations sur les dates de l'arrêt de travail?";
	}

	public static class Hospitalisation {
		public static String INFO_DATE = "A-t'on les informations sur les dates de l'hospitalisations?";
		public static String DATE_DEBUT = "Date de début de l'hospitalisation";
		public static String DATE_FIN = "Date de fin de l'hospitalisation";
		public static String PLS_HOSPI = "Y-a-t-il plusieurs hospitalisations non continues ?";
	}

	public static class Etude {
		public static String DATE_DEBUT_GROSSESSE = "Date de début de grossesse";
		public static String DATE_ACCOUCHEMENT = "Date prévue de l'accouchement";
		public static String OP_ALD = "Y-a-t'il une opération ou des soins ALD ?";
		public static String MULT_AFFECTIONS = "Y-a-t'il plusieurs affections ?";
		// Accident
		public static String DATE = "Date de l'accident";
		public static String LIEU = "Lieu de l'accident";
		public static String TYPE_ACCIDENT = "L'accident est-il lié à un sport ?";
		public static String SPORT = "Quel sport ?";

		public static String REEDUCATION = "Hospitalisation en centre de rééducation ?";
	}


	
	public static class LocalisationPathologie {
		public static String LOCALISATION = "Localisation de la pathologie";

		public static String LOCALISATION_MEMBRES_INFERIEURS = "Membres inférieurs";
		public static String LOCALISATION_MEMBRES_SUPERIEURS = "Membres supérieurs";
		public static String LOCALISATION_TETE = "Tête";
		public static String LOCALISATION_RACHIS = "Rachis";
		public static String LOCALISATION_AFFECTION_RENALE = "Affection rénale";
		public static String LOCALISATION_GASTROENTEROLOGIE = "Gastroentérologie";
		public static String LOCALISATION_AFFECTION_PSY = "Affection psychologique";
		public static String LOCALISATION_AUTRE = "Autre";

		public static String PIED = "Pied";
		public static String ORTEIL = "Orteil";
		public static String CHEVILLE = "Cheville";
		public static String GENOU = "Genou";
		public static String TIBIA_PERONE_FEMUR = "Tibia / Peroné / Fémur";
		public static String HANCHE = "Hanche";
		public static String BASSIN = "Bassin";
		public static String EPAULE = "Epaule";
		public static String BRAS = "Bras";
		public static String COUDE = "Coude";
		public static String POIGNET = "Poignet";
		public static String MAIN = "Main";
		public static String CERVICAL = "Cervical";
		public static String DORSAL = "Dorsal";
		public static String LOMBAIRE = "Lombaire";
		public static String SACRUM_COCCYX = "Sacrum / Coccyx";
	}

	public static class Sport {
		public static String ATHLETISME = "Précisez le sport d'athlétisme";
		public static String ARTS_MARTIAUX = "Précisez l'art martial";
		public static String CYCLISME = "Précisez le type de cyclisme";
		public static String EQUITATION = "Précisez le type d'équitation";
		public static String GYMNASTIQUE = "Précisez le type de gymnastique";
		public static String SPORT_COLLECTIF = "Précisez le sport collectif";
		public static String SPORT_NAUTIQUE = "Précisez le sport nautique";
		public static String SPORT_DE_SALLE_OU_FITNESS = "Précisez le sport de salle";
		public static String AUTRE = "Précisez";

	}

	public static class Adresse {
		public static String CHOIX = "Quelle est l'adresse de correspondance ?";
		public static String AUTRE = "Saisir l'adresse de correspondance";
	}
	

}
