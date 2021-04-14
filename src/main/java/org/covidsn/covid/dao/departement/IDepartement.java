package org.covidsn.covid.dao.departement;

import java.util.List;

public interface IDepartement {

    public void add(Departement f );
    public boolean update(Departement f );
    public boolean delete(int idF );
    public List<Departement> ListeDepartement();
    public String getCodeDepartementByName(String name);
}
