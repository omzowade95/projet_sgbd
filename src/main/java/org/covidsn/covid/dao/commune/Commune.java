package org.covidsn.covid.dao.commune;

import org.covidsn.covid.dao.arrondissement.Arrondissement;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCommune;
    @Column(unique = true)
    private String code ;
    private String nomCommune;
    @OneToMany
    @JoinColumn
    private Collection<Arrondissement> arrondissements ;



}
