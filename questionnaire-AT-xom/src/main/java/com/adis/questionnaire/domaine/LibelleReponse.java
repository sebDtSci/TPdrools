package com.adis.questionnaire.domaine;

public class LibelleReponse {

	public static class ArretDeTravail {

		public static class Type {
			public static String INITIAL = "Initial";
			public static String PROLONGATION = "Prolongation";
			public static String RECHUTE = "Rechute";
			public static String[] LISTE = { INITIAL, PROLONGATION, RECHUTE };
		}

		public static class Origine {
			public static String ACCIDENT = "Accident";
			public static String MALADIE = "Maladie";
			public static String GROSSESSE = "Grossesse";
			public static String[] LISTE = { ACCIDENT, MALADIE, GROSSESSE};
		}
	}

	public static class LocalisationPathologie {

		public static String MEMBRES_INFERIEURS = "Membres inférieurs";
		public static String MEMBRES_SUPERIEURS = "Membres supérieurs";
		public static String TETE = "Tête";
		public static String RACHIS = "Rachis";
		public static String AFFECTION_RENALE = "Affection rénale";
		public static String GASTROENTEROLOGIE = "Gastroentérologie";
		public static String AFFECTION_PSY = "Affections PSY";
		public static String GROSSESSE_PATHO = "Grossesse pathologique";
		public static String AUTRE = "Autre";
		public static String[] LISTE = { MEMBRES_INFERIEURS, MEMBRES_SUPERIEURS, TETE, RACHIS, AFFECTION_RENALE, GASTROENTEROLOGIE, AFFECTION_PSY, GROSSESSE_PATHO, AUTRE};
		
		public static class MembresInferieurs {
			public static String PIED = "Pied (hors orteil)";
			public static String ORTEIL = "Orteil";
			public static String CHEVILLE = "Cheville";
			public static String GENOU = "Genou"; 
			public static String TIBIA_PERONE_FEMUR = "Tibia / Péronné / Fémur";
			public static String HANCHE = "Hanche";
			public static String BASSIN = "Bassin";
			public static String PATHO_VEINEUSE = "patho veineuse (varices, phlébite)";
		}

		public static class MembresSuperieurs {
			public static String EPAULE = "Epaule"; // LibelleReponse.LocalisationPathologie.MembresSuperieurs.EPAULE
			public static String BRAS = "bras (hors coude, épaule, poignet)";
			public static String COUDE = "Coude";
			public static String POIGNET = "Poignet";
			public static String CANAL_CARPIEN = "Canal carpien";
			public static String MAIN = "Main";
		}

		public static class Tete {
			public static String FRACT_NEZ = "Fracture Nez";
			public static String FRACT_ROCHER = "Fracture Rocher / Voute du crâne";
			public static String FRACT_MACHOIRE = "Fracture de la mâchoire";
			public static String AUTRE = "Autre";
		}
		
		public static class Rachis {
			public static String CERVICAL = "Cervical";
			public static String DORSAL = "Dorsal";
			public static String LOMBAIRE = "Lombaire";
			public static String SACRUM_COCCYX = "Sacrum / Coccyx";
		}

		public static class AffectionRenale {
			public static String COLIQS_CALCULS = "Coliques néphrétiques/Calculs rénaux";
			public static String MALADIE_BERGER = "Maladie de Berger avec greffe rénale";
			public static String HERNIE = "Hernie (hors discale) affection rénale";
			public static String CALCUL_RENAL = "Calcul rénal";
			public static String LITHIASE = "Lithiase urinaire";
			public static String PYELONEPHRITE = "Pyélonéphrite";
			public static String AUTRE = "Autre affection rénale";
		}

		public static class Gastroenterologie {
			public static String POLYPES = "Polypes Gastroentérologie";
			public static String ULCERE = "Ulcère Gastroentérologie";
			public static String OESOPHAGITE = "Oesophagite Gastroentérologie";
			public static String CHIR_BARIATRIQUE = "Chirurgie bariatrique";
			public static String APPENDICITE = "Appendicite Gastroentérologie";
			public static String GASTR_GRIPP_INTOX = "Gastroentérite / Grippe intestinale / Intoxication alimentaire";
			public static String AUTRE = "Autre Gastroentérologie";
		}

		public static class AffectionsPSY {
			public static String BURN_OUT = "Burn out";
			public static String DEPRESSION = "Dépression";
			public static String FIBROMYALGIE = "Fibromyalgie";
			public static String AUTRE = "Autres affections psy";
		}

		public static class Autre {
			public static String OPHTALM = "Maladie ophtalmique";
			public static String VERTIGES = "Vertiges";
			public static String ACOUPHENES = "Acouphènes";
			public static String MAL_MENIERE = "Maladie de Ménière";
			public static String OTITE = "Otite";
			public static String SYNDR_GRIP = "Syndrome grippal";
			public static String BRONCHITE = "Bronchite";
			public static String COVID = "Covid";
			public static String AUTRE = "Autre";
		}
		
	}

	public static class Pathologie {
		public static String AUTRE = "Autre";
		public static String FRACTURE = "Fracture";
		public static String ENTORSE = "Entorse";
		public static String GONALGIE = "Gonalgie";
		public static String HYGROMA_OPERE = "Hygroma opéré ou infection";
		public static String LUXATION = "Luxation";
		public static String PROTHESE = "Prothèse";
		public static String RUPTURE_TENDONS_ACHILLE = "Rupture du tendon d'Achille";
		public static String RUPTURE_TENDONS_LIGAMENTS = "Rupture tendons/ligaments";
		public static String SCAPULALGIE = "Scapulalgie";

		public static String INFECTION = "Infection";
		public static String ENTORSE_CERVICALE = "Entorse Cervicale";
		public static String ENTORSE_DOIGT = "Entorse doigt";
		public static String LUXATION_DOIGT = "Luxation doigt";
		public static String NEVRALGIE = "Névralgie Cervico-brachiale";
		public static String CERVICALGIE = "Cervicalgie";
		public static String DORSALGIE = "Dorsalgie";
		public static String HERNIE = "Hernie discale";
		public static String LESION_MENISCALE = "Lésions méniscales";

		public static String SCIATIQUE = "Sciatique lombaire";
		public static String LOMBALGIE = "Lombalgie";
		public static String LUMBAGO = "Lumbago lombaire";
		
		public static String COXARTHROSE = "Coxarthrose";
		public static String PATHOLOGIE_VEINEUSE = "Pathologie veineuse";
	}

	public static class TypeAccident {
		public static String CIRCULATION = "Circulation";
		public static String SPORT = "Lié au sport";
		public static String AUTRE = "Autre";

		public static String[] LISTE = { CIRCULATION, SPORT, AUTRE };
	}

	public static class Sport {
		public static String FOOTBALL_OU_RUGBY = "Football/Rugby en tant que licencié(e)";
		public static String ATHLETISME = "Athlétisme";
		public static String ARTS_MARTIAUX = "Arts Martiaux";
		public static String CYCLISME = "Cyclisme";
		public static String EQUITATION = "Equitation";
		public static String GYMNASTIQUE = "Gymnastique";
		public static String SPORT_COLLECTIF = "Sport collectif";
		public static String SPORT_NAUTIQUE = "Sport nautique";
		public static String SPORT_DE_SALLE_OU_FITNESS = "Sport de salle / fitness";
		public static String AUTRE = "Autre";

		// Sous catégories :

		// Athlétisme
		public static class Athletisme {
			public static String CANICROSS = "Canicross";
			public static String COURSE_A_PIED = "Course à pied";
			public static String JOGGING = "Jogging";
			public static String MARATHON = "Marathon";
			public static String TRAIL = "Trail";
			public static String TRIATHLON = "Triathlon";
			public static String SKIATHLON = "Skiathlon";
		}

		// Arts Martiaux
		public static class ArtsMartiaux {
			public static String AIKIDO_AIKIBUDO = "Aïkido/Aïkibudo";
			public static String AFRIJUTSU = "Afrijutsu";
			public static String BUDO = "Budo";
			public static String BUJINKAN_BUDO_TAIJUTSU = "Bujinkan budo taijutsu";
			public static String CAPOERA = "Capoeira";
			public static String GOSHINDO = "Goshindo";
			public static String JUDO = "Judo";
			public static String JUJITSU = "Jujitsu";
			public static String KAPAP_LOTAR = "Kapap Lotar";
			public static String KARATE = "Karaté";
			public static String KENDO = "Kendo";
			public static String KENPO = "Kenpo";
			public static String KINOMICHI = "Kinomichi";
			public static String KRAV_MAGA = "Krav Maga";
			public static String KUNG_FU_OU_WING_CHUN = "Kung Fu/Wing Chun";
			public static String LAM_SON_VO_DAO = "Lam son vo dao";
			public static String PENCHAK = "Penchak";
			public static String QI_GONG = "Qi-Gong";
			public static String SYSTEMA = "Systema";
			public static String TAE_BO = "Tae bo";
			public static String TAEKWONDO = "Taekwondo";
			public static String TAI_CHI_CHUAN = "Taï-Chi-Chuan";
			public static String VIET_VO_DAO = "Viet-Vo-Dao";
			public static String YOSEIKAN_BUDO = "Yoseikan budo";
		}

		// Cyclisme
		public static class Cyclisme {
			public static String BMX = "BMX";
			public static String CYCLISME_ARTISTIQUE = "Cyclisme artistique";
			public static String CYCLISME_SUR_ROUTE = "Cyclisme sur route";
			public static String CYCLOCROSS = "Cyclocross";
			public static String VTT = "VTT";
		}

		// Equitation
		public static class Equitation {
			public static String ATTELAGE = "Attelage";
			public static String DRESSAGE = "Dressage";
			public static String PROMENADE_OU_RANDONNEE = "Promenade/randonnée";
			public static String RODEO = "Rodéo";
			public static String SKI_JOERING = "Ski joëring";
		}

		// Gymnastique
		public static class Gymnastique {
			public static String AEROBIC = "Aérobic";
			public static String GYMNASTIQUE_ARTISTIQUE = "Gymnastique artistique";
			public static String TWIRLING_BATON = "Twirling Bâton";
		}

		// Sport collectif
		public static class SportCollectif {
			public static String BASE_BALL = "Base-ball";
			public static String BASKET = "Basket";
			public static String BEACH_SOCCER = "Beach soccer/football de plage";
			public static String CRIQUET = "Criquet";
			public static String CURLING = "Curling";
			public static String FIVES = "Fives";
			public static String FOOTBALL_LIC = "Football (licencié)";
			public static String FOOTBALL_NN_LIC = "Football (non licencié)";
			public static String HANDBALL = "Handball";
			public static String HOCKEY = "Hockey";
			public static String HURLING = "Hurling";
			public static String RUGBY_LIC = "Rugby (licencié)";
			public static String RUGBY_NN_LIC = "Rugby (non licencié)";
			public static String TOUCH_RUGBY = "Touch rugby";
			public static String VOLLEY_BALL = "Volley-ball";
		}

		// Sport nautique
		public static class SportNautique {
			public static String AVIRON = "Aviron";
			public static String BAREFOOT = "Barefoot";
			public static String CANOE = "Canoé";
			public static String CHAR_A_VOILE = "Char à voile/cerf volant";
			public static String DERIVEUR = "Dériveur";
			public static String FLYBOARD = "Flyboard";
			public static String FUNBOARD = "Funboard";
			public static String HYDRO_SPEED = "Hydro speed";
			public static String JET_SKI = "Jet ski";
			public static String KAYAK = "Kayak";
			public static String KNEEBOARDING = "Kneeboarding";
			public static String NATATION = "Natation";
			public static String PADDLE = "Paddle";
			public static String PLANCHE_A_VOILE = "Planche à voile";
			public static String RAFTING = "Rafting";
			public static String SKI_NAUTIQUE_ET_APPARENTE = "Ski nautique/Surf/Body surf/Body boarding";
			public static String WAKEBOARD = "Wakeboard";
			public static String WATERPOLO = "Waterpolo";
			public static String WINDSURF = "Windsurf";
		}

		// Sport de salle / fitness
		public static class SportDeSalleOuFitness {
			public static String AQUABIKING = "Aquabiking";
			public static String AQUAFITNESS = "Aquafitness";
			public static String AQUARUNNING = "Aquarunning";
			public static String BODY_BUILDING = "Body-building";
			public static String BOXE_FITNESS = "Boxe fitness";
			public static String CROSSFIT = "Crossfit";
			public static String HALTEROPHILIE = "Haltérophilie";
			public static String MUSCULATION = "Musculation";
			public static String PILATE = "Pilate";
			public static String RPM = "RPM";
			public static String TRX = "TRX";
			public static String YOGA = "Yoga";
			public static String ZUMBA = "Zumba";
		}

		// Autre
		public static class Autre {
			public static String BADMINGTON = "Badmington";
			public static String BALL_TRAP = "Ball Trap";
			// public static String BALLTRAP = "Ball";
			public static String BAT_AND_TRAP = "Bat-and-trap";
			public static String BIATHLON = "Biathlon";
			public static String BILLARD = "Billard";
			public static String BOWLING = "Bowling";
			public static String CHASSE_AU_GIBIER = "Chasse au gibier";
			public static String CHASSE_AVEC_SAFARI = "Chasse avec safari";
			public static String COURSE_D_ORIENTATION = "Course d'orientation";
			public static String DANSE = "Danse";
			public static String ESCRIME = "Escrime";
			public static String GOLF = "Golf";
			public static String MARCHE = "Marche";
			public static String PATINAGE = "Patinage";
			public static String PECHE_SANS_PLONGEE = "Pêche sans plongée";
			public static String PELOTE_BASQUE = "Pelote basque";
			public static String PETANQUE = "Pétanque";
			public static String PING_PONG = "Ping-pong";
			public static String POM_POM_GIRL = "Pom-pom girl";
			public static String SANDBOARD = "Sandboard";
			public static String SKATEBOARD = "Skateboard";
			public static String SQUASH = "Squash";
			public static String TENNIS = "Tennis";
			public static String TIR = "Tir";
			public static String ZORBING = "Zorbing";
			public static String AUTRE = "Autre";
		}

		public static String[] LISTE_CATEGORIES = { FOOTBALL_OU_RUGBY, ATHLETISME,
				ARTS_MARTIAUX, CYCLISME,
				EQUITATION, GYMNASTIQUE, SPORT_COLLECTIF, SPORT_NAUTIQUE, SPORT_DE_SALLE_OU_FITNESS, AUTRE };
	}
	public static class Adresse {
		public static String AUTRE = "Autre";
	}
}
