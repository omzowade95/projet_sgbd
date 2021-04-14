package org.covidsn.covid.dao.vaccination;

import java.util.List;

public interface IVaccination {

    public void add(Vaccination f );
    public boolean update(Vaccination f );
    public boolean delete(int idF );
    public List<Vaccination> ListeVaccination();
    public Vaccination getVaccinationById(int idF);
}
