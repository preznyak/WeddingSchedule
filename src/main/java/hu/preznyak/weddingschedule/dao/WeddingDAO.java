package hu.preznyak.weddingschedule.dao;

import hu.preznyak.weddingschedule.entity.Wedding;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class WeddingDAO {

    private EntityManager entityManager;

    public WeddingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean createWedding(Wedding wedding){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(wedding);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteWedding(Wedding wedding){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(wedding);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Wedding> getAll(){
        List<Wedding> weddings = new ArrayList<>();
        try {
            weddings = entityManager.createQuery("select w from wedding w")
                    .getResultList();
        } catch (NoResultException e){
            e.printStackTrace();
        }
        return weddings;
    }
}
