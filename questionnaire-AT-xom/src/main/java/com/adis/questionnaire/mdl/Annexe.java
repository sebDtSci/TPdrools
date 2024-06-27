package com.adis.questionnaire.mdl;

import com.adis.questionnaire.domaine.CodeAnnexe;
import com.adis.questionnaire.domaine.LibelleAnnexe;

public class Annexe {
    private LibelleAnnexe libelle;
    private CodeAnnexe code;


    public Annexe() {
		this(LibelleAnnexe.DEFAUT, CodeAnnexe.DEFAUT);
	}

    public Annexe(LibelleAnnexe libelle, CodeAnnexe code){
        this.libelle = libelle;
        this.code = code;
    }

    public LibelleAnnexe getLibelle() {
        return libelle;
    }

    public void setLibelle(LibelleAnnexe libelle) {
        this.libelle = libelle;
    }

    public CodeAnnexe getCode() {
        return code;
    }

    public void setCode(CodeAnnexe code) {
        this.code = code;
    }
}
