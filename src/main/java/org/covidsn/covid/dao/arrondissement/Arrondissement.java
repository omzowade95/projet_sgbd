package org.covidsn.covid.dao.arrondissement;

import javax.persistence.*;

@Entity
@Table(name = "arrondissement")
public class Arrondissement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idArr ;
    @Column(unique = true)
    private String code ;
    private String nomArr;
    private int idC;




}
