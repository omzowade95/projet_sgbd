package org.covidsn.covid.dao.departement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DepartementDB implements IDepartement {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void add(Departement f) {
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();

        this.entityManagerFactory.close();

    }

    @Override
    public boolean update(Departement f) {
        return false;
    }

    @Override
    public boolean delete(int idF) {
        return false;
    }

    @Override
    public List<Departement> ListeDepartement() {
        return null;
    }

    public String getCodeDepartementByName(String name){
        String dept = null ;
        try {
            dept = entityManager.createQuery("SELECT r.code FROM Departement r WHERE r.nomDept = :name", String.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (Exception E){

        }

        return dept ;
    }
}

