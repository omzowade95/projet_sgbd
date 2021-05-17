package org.covidsn.covid.dao.communiqueLocalite;

import org.covidsn.covid.dao.communique.Communique;
import org.covidsn.covid.dao.departement.Departement;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;

@Entity
public class CommuniqueLocalite {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String codeLoc;
    private int nombreCas;
    @ManyToOne
    private Communique communique;

    public Communique getCommunique() {
        return communique;
    }

    public void setCommunique(Communique communique) {
        this.communique = communique;
    }

    @Transient
    Collection collection = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeLoc() {
        return codeLoc;
    }

    public void setCodeLoc(String codeLoc) {
        this.codeLoc = codeLoc;
    }

    public int getNombreCas() {
        return nombreCas;
    }

    public void setNombreCas(int nombreCas) {
        this.nombreCas = nombreCas;
    }
    


    public CommuniqueLocalite( String codeLoc, int nombreCas) {

        this.codeLoc = codeLoc;
        this.nombreCas = nombreCas;

    }

    public CommuniqueLocalite() {

    }
}
