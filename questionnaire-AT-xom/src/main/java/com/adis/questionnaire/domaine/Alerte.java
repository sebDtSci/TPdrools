package com.adis.questionnaire.domaine;

import com.adis.questionnaire.util.DateUtils;
import java.util.Date;

public class Alerte {
    public static final Alerte AL_BONIF = new Alerte("Demander le choix de l'assuré concernant l'application de la bonification.", "AL_BONIF");
    public static final Alerte AL_DATE_ACCOUCH = new Alerte("Demander la date prévue de l'accouchement.", "AL_DATE_ACCOUCH");
    public static final Alerte AL_PAIMENT = new Alerte("Possible de prendre en charge jusqu'à la date D", "AL_PAIMENT");
    public static final Alerte AL_CIRC_ACCIDENT = new Alerte("Vérifier les circonstances accident.", "AL_CIRC_ACCIDENT");
	public static final Alerte AL_ATTEST_REG_OBL = new Alerte("65 ans ou plus : Attestation de régime obligatoire ?", "AL_ATTEST_REG_OBL");
	public static final Alerte AL_MAT = new Alerte("Ouvrir un dossier forfait maternité", "AL_MAT");
	public static final Alerte AL_DEC_FISC = new Alerte("Déclaration fiscale", "AL_DEC_FISC");
	public static final Alerte AL_RIB = new Alerte("Vérifier le RIB", "AL_RIB");
	public static final Alerte AL_EXCLUSION = new Alerte("Présence d'une annexe exclusion", "AL_EXCLUSION");
	public static final Alerte AL_AMORTISSEMENT = new Alerte("Vérifier le tableau d'ammortissement", "AL_AMORTISSEMENT");
	public static final Alerte AL_GARANTIE_MOINS_2ANS = new Alerte("Modification ou ajout de garantie depuis moins de 2 ans", "AL_GARANTIE_MOINS_2ANS");
	public static final Alerte AL_PRISE_EN_CHARGE = new Alerte("Possible de prendre en charge jusqu'au %s", "AL_PRISE_EN_CHARGE");
	public static final Alerte AL_SPORT = new Alerte("Vérifier l'annexe sport", "AL_SPORT");
	public static final Alerte AL_ADHERENT = new Alerte("Présence d'un adhérent", "AL_ADHERENT");
	public static final Alerte AL_CESSION = new Alerte("Cession sur la garantie %s", "AL_CESSION");
	public static final Alerte AL_A2PS = new Alerte("Adhésion A2PS n° %s : ouvrir un dossier", "AL_A2PS");
	public static final Alerte AL_ECHEANCE_NN_CONST = new Alerte("Tableau d'amortissement avec échéances non constantes", "AL_ECHEANCE_NN_CONST");
	public static final Alerte AL_SPORT_NN_CONVENTIONNEL = new Alerte("Sport non standard ou inconnu", "AL_SPORT_NN_CONVENTIONNEL");
	public static final Alerte AL_PLS_HOSP_NN_CONT = new Alerte("Plusieurs hospitalisation non continues", "AL_PLS_HOSP_NN_CONT");

    public static final Alerte PM_JUSTIF_SALARIE = new Alerte("Pièces Manquantes: Justificatifs salarié.", "PM_JUSTIF_SALARIE");
    public static final Alerte PM_TABL_AMORT = new Alerte("Pièces Manquantes: Tableau d'ammortissement.", "PM_TABL_AMORT");
    public static final Alerte PM_AT = new Alerte("Pièces Manquantes: Arrêt de travail, CM AGIPI, toute autre pièce nécessaire.", "PM_AT");
    public static final Alerte PM_AT_SUCC = new Alerte("Pièces Manquantes: Demander l'arrêt de travail manquant.", "PM_AT_SUCC");
    public static final Alerte PM_AT_INIT = new Alerte("Pièces Manquantes: Arrêt de travail initial et éventuelles prolongations.", "PM_AT_INIT");
    public static final Alerte PM_AT_AU_DELA_PAIEMENT = new Alerte("Pièces Manquantes pour étudier l'arrêt de travail au delà du %s", "PM_AT_AU_DELA_PAIEMENT");
	public static final Alerte PM_PIEC_MEDIC = new Alerte("Demande de pièce médicale.", "PM_PIEC_MEDIC");

    private String libelle; // libelle
	private String code; // code
	private String type;


	private Alerte(String value, String key) {
		this.libelle = value;
		this.code = key;
		if ((key.substring(0, 2)).equals("AL")){
			this.type = "ALERTE";
		}else this.type = "PIECE_MANQUANTE";
	}

	private Alerte(){

	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Alerte copy(){
		return new Alerte(this.libelle, this.code);
	}

	public Alerte copyAndFormat(Object value){
		if (value instanceof Date){
			value = DateUtils.getDateFormat().format(value);
		}
		Alerte newMotif = new Alerte(this.libelle, this.code);
		newMotif.libelle = String.format(newMotif.libelle, value);
		return newMotif;
	}
}
