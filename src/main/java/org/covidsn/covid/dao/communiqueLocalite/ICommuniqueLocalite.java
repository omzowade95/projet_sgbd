package org.covidsn.covid.dao.communiqueLocalite;

import java.util.List;

public interface ICommuniqueLocalite {

    public void add (CommuniqueLocalite c);
    public List getAllCode() ;
    public int getNbCasByCode(String code) ;

    }
