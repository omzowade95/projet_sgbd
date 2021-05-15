package org.covidsn.covid.dao.communiqueLocalite;


import javax.persistence.*;
import java.util.List;

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

    @Override
    public List getAllCode() {
        List results = null;
        TypedQuery<String> query =
                entityManager.createQuery("SELECT codeLoc FROM CommuniqueLocalite c", String.class);
        results = query.getResultList();
        return results;

    }

    @Override
    public int getNbCasByCode(String code) {
        long book = 0;

    try{
            book = entityManager.createQuery("SELECT SUM(r.nombreCas) FROM CommuniqueLocalite r WHERE r.codeLoc = :code", Long.class)
                    .setParameter("code", code)
                    .getSingleResult();

        }catch (Exception e){
            //System.out.println("you there");
            book =0;
        }
        System.out.println(book);

        return (int)book ;
    }
}
