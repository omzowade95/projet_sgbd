package org.covidsn.covid.dao.vaccination;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VaccinationDB implements IVaccination {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void add(Vaccination f) {
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().rollback();

        this.entityManagerFactory.close();

    }

    @Override
    public boolean update(Vaccination f) {
        return false;
    }

    @Override
    public boolean delete(int idF) {
        return false;
    }

    @Override
    public List<Vaccination> ListeVaccination() {
        return null;
    }

    @Override
    public Vaccination getVaccinationById(int idF) {
        return null;
    }
}
