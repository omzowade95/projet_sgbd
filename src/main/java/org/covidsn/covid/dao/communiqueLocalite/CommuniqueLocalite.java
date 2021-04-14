package org.covidsn.covid.dao.communiqueLocalite;

import org.covidsn.covid.dao.communique.Communique;
import org.covidsn.covid.dao.departement.Departement;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;

@Entity
public class CommuniqueLocalite {


    @Id
    private int id;
    private String codeLoc;
    private int nombreCas;

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
    
    public Collection addLoc(CommuniqueLocalite l){
        collection.add(l);
        return collection;
    }

    public Collection listeLoc(){
        return collection;
    }

    public CommuniqueLocalite(int id, String codeLoc, int nombreCas, Collection collection) {
        this.id = id;
        this.codeLoc = codeLoc;
        this.nombreCas = nombreCas;
        this.collection = collection;
    }
}
