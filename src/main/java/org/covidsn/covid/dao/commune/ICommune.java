package org.covidsn.covid.dao.commune;

import java.util.List;

public interface ICommune {

    public void add(Commune f );
    public boolean update(Commune f );
    public boolean delete(int idF );
    public List<Commune> ListeCommune();
    public String getCodeCommuneByname(String name);
    public String getNameByCode(String code);
}
