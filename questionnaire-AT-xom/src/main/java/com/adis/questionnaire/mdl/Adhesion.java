package com.adis.questionnaire.mdl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.adis.questionnaire.domaine.CodeProduit;
import com.adis.questionnaire.domaine.TypeProduit;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Adhesion {
    private String numeroAdhesion;
    private CodeProduit codeProduit = CodeProduit.DEFAUT;
    private TypeProduit typeProduit = TypeProduit.DEFAUT;	
    private String generationContrat = "";
    private Adresse adresse;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFinPaiementCotisation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateFinDePret;
    private boolean optionPsyDos = false;
    private boolean presenceAdherent = false;
    private boolean reassure = false;
    private boolean estA2PS = false;
    
    private List<Annexe> annexes = new LinkedList<Annexe>();

    private int nbJoursBonifies = 0;
    public int getNbJoursBonifies() {
        return nbJoursBonifies;
    }

    public void setNbJoursBonifies(int nbJoursBonifies) {
        this.nbJoursBonifies = nbJoursBonifies;
    }

    // Liste des garanties récupérées de la base adhésion
    private List<Garantie> garanties = new LinkedList<>();
    
    public String getNumeroAdhesion() {
        return numeroAdhesion;
    }

    public void setNumeroAdhesion(String numeroAdhesion) {
        this.numeroAdhesion = numeroAdhesion;
    }

	public CodeProduit getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(CodeProduit codeProduit) {
		this.codeProduit = codeProduit;
	}
    
    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }
    
    public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

    public Date getDateFinPaiementCotisation() {
        return dateFinPaiementCotisation;
    }

    public void setDateFinPaiementCotisation(Date dateFinPaiementCotisation) {
        this.dateFinPaiementCotisation = dateFinPaiementCotisation;
    }

    public String getGenerationContrat() {
        return generationContrat;
    }

    public void setGenerationContrat(String generationContrat) {
        this.generationContrat = generationContrat;
    }

    public boolean getOptionPsyDos() {
        return optionPsyDos;
    }

    public void setOptionPsyDos(boolean optionPsyDos) {
        this.optionPsyDos = optionPsyDos;
    }

    public boolean isPresenceAdherent() {
        return presenceAdherent;
    }

    public void setPresenceAdherent(boolean presenceAdherent) {
        this.presenceAdherent = presenceAdherent;
    }

    public List<Annexe> getAnnexes() {
        return annexes;
    }

    public void setAnnexes(List<Annexe> annexes) {
        this.annexes = annexes;
    }

    public List<Garantie> getGaranties() {
        return garanties;
    }

    public void setGaranties(List<Garantie> garanties) {
        this.garanties = garanties;
    }

    public boolean isReassure() {
        return reassure;
    }

    public void setReassure(boolean reassure) {
        this.reassure = reassure;
    }

    public boolean isEstA2PS() {
        return estA2PS;
    }

    public void setEstA2PS(boolean estA2PS) {
        this.estA2PS = estA2PS;
    }

    public Date getDateFinDePret() {
        return dateFinDePret;
    }

    public void setDateFinDePret(Date dateFinDePret) {
        this.dateFinDePret = dateFinDePret;
    }

}