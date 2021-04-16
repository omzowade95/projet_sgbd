package org.covidsn.covid.dao.communiqueLocalite;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CommuniqueLocaliteDB  implements  ICommuniqueLocalite {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void add(CommuniqueLocalite c) {

        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
        //entityManager.getTransaction().rollback();
      //  entityManagerFactory.close();

    }
}
