package org.covidsn.covid.dao.arrondissement;

import java.util.List;

public interface IArrondissement {

    public void add(Arrondissement f );
    public boolean update(Arrondissement f );
    public boolean delete(int idF );
    public List<Arrondissement> listeArrondissement();
    public String getCodeArrondissementByName(String name);
}
