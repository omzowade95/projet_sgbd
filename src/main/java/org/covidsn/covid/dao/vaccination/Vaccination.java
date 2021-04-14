package org.covidsn.covid.dao.vaccination;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccination {
    @Id
    private  int id ;
    private int nombreCasJour;
    private int nctotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombreCasJour() {
        return nombreCasJour;
    }

    public void setNombreCasJour(int nombreCasJour) {
        this.nombreCasJour = nombreCasJour;
    }

    public int getNctotal() {
        return nctotal;
    }

    public void setNctotal(int nctotal) {
        this.nctotal = nctotal;
    }
}
