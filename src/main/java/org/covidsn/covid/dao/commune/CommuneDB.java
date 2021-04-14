package org.covidsn.covid.dao.commune;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CommuneDB implements ICommune {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void add(Commune f) {
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();

        this.entityManagerFactory.close();

    }

    @Override
    public boolean update(Commune f) {
        return false;
    }

    @Override
    public boolean delete(int idF) {
        return false;
    }

    @Override
    public List<Commune> ListeCommune() {
        return null;
    }

    @Override
    public String getCodeCommuneByname(String name) {

        String commune = null ;
        try {
            commune = entityManager.createQuery("SELECT r.code FROM Commune r WHERE r.nomCommune = :name", String.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (Exception  e){

        }
        return commune ;
    }
}
