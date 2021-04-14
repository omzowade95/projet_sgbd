package org.covidsn.covid.dao.region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RegionDB implements IRegion {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void add(Region f) {
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();

        this.entityManagerFactory.close();

    }

    @Override
    public boolean update(Region f) {
        return false;
    }

    @Override
    public boolean delete(int idF) {
        return false;
    }

    @Override
    public List<Region> ListeRegion() {
        return null;
    }

    @Override
    public String getCodeRegionByName(String name)
    {
        String book = null ;
        try {
            book = entityManager.createQuery("SELECT r.code FROM Region r WHERE r.nomRegion = :name", String.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (Exception e){

        }

        return book ;
    }
}
