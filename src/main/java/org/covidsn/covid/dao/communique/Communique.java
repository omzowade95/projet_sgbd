package org.covidsn.covid.dao.communique;



import org.covidsn.covid.dao.communiqueLocalite.CommuniqueLocalite;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name="communique")
public class Communique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCommunique ;
    @Column(nullable = false)
    private String nomCommunique ;
    @Column(nullable =false )
    private String dateCommunique ;
    private int nbTest;
    private int nbNouveauCas;
    private int nbCasCommun;
    private int nbGueri;
    private int nbDeces;
    private String nomFichier;

    @OneToMany
    @JoinColumn
    private Collection<CommuniqueLocalite> communiqueLocalites;

    public Communique(int idCommunique, String nomCommunique, String dateCommunique, int nbTest, int nbNouveauCas, int nbCasCommun, int nbGueri, int nbDeces, String nomFichier, Collection<CommuniqueLocalite> communiqueLocalites) {
        this.idCommunique = idCommunique;
        this.nomCommunique = nomCommunique;
        this.dateCommunique = dateCommunique;
        this.nbTest = nbTest;
        this.nbNouveauCas = nbNouveauCas;
        this.nbCasCommun = nbCasCommun;
        this.nbGueri = nbGueri;
        this.nbDeces = nbDeces;
        this.nomFichier = nomFichier;
        this.communiqueLocalites = communiqueLocalites;
    }

    public Communique() {

    }
}
