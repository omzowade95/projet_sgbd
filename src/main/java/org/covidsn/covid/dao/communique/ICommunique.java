package org.covidsn.covid.dao.communique;

import java.util.List;

public interface ICommunique {

    public void add(Communique f );
    public boolean update(Communique f );
    public boolean delete(Communique c);
    public List<Communique> ListeCommunique();
    public Communique getCommuniceById(int idF);

}
