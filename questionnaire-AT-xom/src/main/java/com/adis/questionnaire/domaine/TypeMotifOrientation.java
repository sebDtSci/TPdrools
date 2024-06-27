package com.adis.questionnaire.domaine;

import java.util.Date;

import com.adis.questionnaire.util.DateUtils;

public class TypeMotifOrientation {
	// Niveau Evaluation Demande
	public static final TypeMotifOrientation REGLE_ALLEGEE = new TypeMotifOrientation("Règle allégée", "REGLE_ALLEGEE");
	public static final TypeMotifOrientation REGLE_ALLEGEE_ITT_SS_CM = new TypeMotifOrientation("règle allégée  et la durée de l'AT est supérieure à la durée IIT sans CM", "REGLE_ALLEGEE_ITT_SS_CM");
	public static final TypeMotifOrientation DOSS_REASS = new TypeMotifOrientation("Dossier réassuré", "DOSS_REASS");
	public static final TypeMotifOrientation RECHUTE = new TypeMotifOrientation("Rechute", "RECHUTE");
	public static final TypeMotifOrientation MT_THERA = new TypeMotifOrientation("Mi-temps thérapeutique","MT_THERA");
	public static final TypeMotifOrientation POLYPATH = new TypeMotifOrientation("Polypathologie", "POLYPATH");
	public static final TypeMotifOrientation POLYTRAUM = new TypeMotifOrientation("Polytraumatisme", "POLYTRAUM");
	public static final TypeMotifOrientation ETUD_PATHOLOGIE = new TypeMotifOrientation("Pathologie à étudier", "ETUD_PATHOLOGIE");
	public static final TypeMotifOrientation NAT_AT_INC = new TypeMotifOrientation("Nature de l'arrêt de travail inconnu","NAT_AT_INC");
	public static final TypeMotifOrientation NOTION_CENTRE_REED = new TypeMotifOrientation("Vérifier la notion de centre de rééducation", "NOTION_CENTRE_REED");
    public static final TypeMotifOrientation OP_SOINS_ALD = new TypeMotifOrientation("Vérifier s'il y a une opération ou des soins ALD", "AL_OP_SOINS_ALD");
	public static final TypeMotifOrientation REED_NN_PSY_DOS = new TypeMotifOrientation("Option psy/dos non souscrite et hospitalisation en centre de ré-éducation", "REED_NN_PSY_DOS");
	public static final TypeMotifOrientation AUCUNE_ADHESION_APPL = new TypeMotifOrientation("Aucune des adhésions ne permet la prise en charge", "AUCUNE_ADHESION_APPL");
	public static final TypeMotifOrientation UNE_ADHESION_APPL = new TypeMotifOrientation("Au moins une adhésion applicable", "UNE_ADHESION_APPL");

	// Niveau Dossier de Prestation
	public static final TypeMotifOrientation PSY_EXC_NOTICE = new TypeMotifOrientation("durée AT < 90 jours pour Psy exclu par la notice", "PSY_EXC_NOTICE");
	public static final TypeMotifOrientation NN_PSY = new TypeMotifOrientation("Pas d'hospitalisation et option psy/dos non souscrite pour psy", "NN_PSY");
	public static final TypeMotifOrientation NN_DOS = new TypeMotifOrientation("Option psy/dos non souscrite et pas d'hospitalisation pour dos", "NN_DOS");
	public static final TypeMotifOrientation NN_PSYDOS_REED = new TypeMotifOrientation("Option psy/dos non souscrite et hospitalisation en centre de rééducation", "NN_PSYDOS_REED");
	public static final TypeMotifOrientation NN_DOS_15_HOSP = new TypeMotifOrientation("Option psy/dos non souscrite et durée d'hospitalisation < 15 pour dos", "NN_DOS_15_HOSP");
	public static final TypeMotifOrientation NN_PSY_30_HOSP = new TypeMotifOrientation("Option psy/dos non souscrite et durée d'hospitalisation < 30 pour psy", "NN_PSY_30_HOSP");
	public static final TypeMotifOrientation AUCUNE_GARANTIE_APPL = new TypeMotifOrientation("Aucune des garanties de l'adhésion ne permet la prise en charge", "AUCUNE_GARANTIE_APPL");
	public static final TypeMotifOrientation UNE_GARANTIE_APPL = new TypeMotifOrientation("Au moins une garantie applicable", "UNE_GARANTIE_APPL");

	// Niveau Evaluation de Garantie
	public static final TypeMotifOrientation AT_ABS_FRANCHISE = new TypeMotifOrientation("Arrêt de travail absorbé par la franchise", "AT_ABS_FRANCHISE");
	public static final TypeMotifOrientation PAIEMENT_OK = new TypeMotifOrientation("Ok pour paiement", "PAIEMENT_OK");
	public static final TypeMotifOrientation PAIEMENT_OK_DUREE = new TypeMotifOrientation("Ok pour paiement jusqu'au %s", "PAIEMENT_OK_DUREE");
	public static final TypeMotifOrientation PAIEMENT_OK_DUREE_PLUS = new TypeMotifOrientation("Ok pour paiement jusqu'au %s, date maximale: %s", "PAIEMENT_OK_DUREE_PLUS");
	public static final TypeMotifOrientation ZERO_JOURS_FRANCHISE_HOSPI = new TypeMotifOrientation("Nb de jours de franchises pour hospitalisation à 0", "ZERO_JOURS_FRANCHISE_HOSPI");

	public static final TypeMotifOrientation DEFAUT = new TypeMotifOrientation("", "DEFAUT");
	
	private String libelle; // libelle
	private String code; // code

	private TypeMotifOrientation(String value, String key) {
		this.libelle = value;
		this.code = key;
	}

	private TypeMotifOrientation(){

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

	public TypeMotifOrientation copy(){
		return new TypeMotifOrientation(this.libelle, this.code);
	}

	public TypeMotifOrientation copyAndFormat(Object value){
		if (value instanceof Date){
			value = DateUtils.getDateFormat().format(value);
		}
		TypeMotifOrientation newMotif = new TypeMotifOrientation(this.libelle, this.code);
		newMotif.libelle = String.format(newMotif.libelle, value);
		return newMotif;
	}
	public TypeMotifOrientation copyAndFormat(Object value1,Object value2){
		if (value1 instanceof Date){
			value1 = DateUtils.getDateFormat().format(value1);
		}
		if (value2 instanceof Date){
			value2 = DateUtils.getDateFormat().format(value2);
		}
		TypeMotifOrientation newMotif = new TypeMotifOrientation(this.libelle, this.code);
		newMotif.libelle = String.format(newMotif.libelle, value1, value2);
		return newMotif;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof TypeMotifOrientation == false)
			return false;
		TypeMotifOrientation other = (TypeMotifOrientation) o;
		return code.equals(other.getCode());
	}
}