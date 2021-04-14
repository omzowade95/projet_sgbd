package org.covidsn.covid.dao.arrondissement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ArrondissementDB implements IArrondissement {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void add(Arrondissement f) {
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();

        this.entityManagerFactory.close();

    }

    @Override
    public boolean update(Arrondissement f) {
        return false;
    }

    @Override
    public boolean delete(int idF) {
        return false;
    }

    @Override
    public List<Arrondissement> listeArrondissement() {
        return null;
    }

    @Override
    public String getCodeArrondissementByName(String name) {

        String arrondissement = null ;
        try {
            arrondissement = entityManager.createQuery("SELECT r.code FROM Region r WHERE r.nomArr = :name", String.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (Exception e){

        }

        return arrondissement ;
    }
}
