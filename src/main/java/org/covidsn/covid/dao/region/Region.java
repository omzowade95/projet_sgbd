package org.covidsn.covid.dao.region;

import org.covidsn.covid.dao.departement.Departement;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRegion ;
    @Column(unique = true)
    private String code ;
    private String nomRegion;
    @OneToMany
    @JoinColumn
    private Collection<Departement> departement ;


}
