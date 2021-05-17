package org.covidsn.covid.dao.communique;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CommuniqueDB implements ICommunique {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void add(Communique f) {

        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();

       // entityManagerFactory.close();

    }

    @Override
    public boolean update(Communique f) {
        entityManager.merge(f);
        return false;
    }

    @Override
    public boolean delete(Communique c) {
        entityManager.remove(c);
        return true;
    }

    @Override
    public List<Communique> ListeCommunique() {
        return null;
    }

    @Override
    public Communique getCommuniceById(int idF) {
        Communique comm = new Communique();
        //entityManager.find(comm,idF);
        return comm;

    }
}
