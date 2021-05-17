package org.covidsn.covid.dao.region;

import java.util.List;

public interface IRegion {

    public void add(Region f );
    public boolean update(Region f );
    public boolean delete(int idF );
    public List<Region> ListeRegion();
    public String getCodeRegionByName(String name);
    public String getNameByCode(String code);
}
