package com.adis.questionnaire.mdl;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DemandeDePrestation {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateTraitement;
    // liste des pièces justificatives récupérés de la GED
    private List<PieceJustificative> piecesJustificatives = new LinkedList<>();
    // liste des évènemenst médicaux récupérés de la base client
    

    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

	public Collection<PieceJustificative> getPiecesJustificatives() {
		return piecesJustificatives;
	}

	public void setPiecesJustificatives(List<PieceJustificative> piecesJustificatives) {
		this.piecesJustificatives = piecesJustificatives;
	}

	
}
