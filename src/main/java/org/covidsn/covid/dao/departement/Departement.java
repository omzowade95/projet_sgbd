package org.covidsn.covid.dao.departement;

import org.covidsn.covid.dao.commune.Commune;
import org.covidsn.covid.dao.region.Region;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDept ;
    @Column(unique = true)
    private String code ;
    private String nomDept;
    @OneToMany
    @JoinColumn
    private Collection<Commune> commune ;



}
