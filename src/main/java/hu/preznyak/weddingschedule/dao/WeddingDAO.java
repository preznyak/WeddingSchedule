package hu.preznyak.weddingschedule.dao;

import hu.preznyak.weddingschedule.entity.Wedding;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import org.pmw.tinylog.Logger;

/**
 * {@link WeddingDAO} class.
 *
 * @author Preznyák László
 * @version 1.0
 */

public class WeddingDAO {

    /**
     * An EntityManager object for the dao.
     */
    private EntityManager entityManager;

    /**
     * Constructor for {@link WeddingDAO}.
     * @param entityManager an {@link EntityManager} object.
     */
    public WeddingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Method for saving a {@link Wedding} object to the database.
     * @param wedding a {@link Wedding} object.
     * @return boolean A boolean value which shows that the operation was successful or not.
     */
    public boolean createWedding(Wedding wedding){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(wedding);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        }
        Logger.info("Wedding saved.");
        return true;
    }

    /**
     * Method for deleting a {@link Wedding} object from the database.
     * @param wedding The {@link Wedding} object which will be deleted.
     * @return boolean A boolean value which shows that the operation was successful or not.
     */
    public boolean deleteWedding(Wedding wedding){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(wedding);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        }
        Logger.info("Wedding deleted.");
        return true;
    }

    /**
     * A method for getting all the {@link Wedding} objects from the database.
     * @return List a List of {@link Wedding} objects.
     */
    public List<Wedding> getAll(){
        List<Wedding> weddings = new ArrayList<>();
        try {
            weddings = entityManager.createQuery("select w from wedding w")
                    .getResultList();
        } catch (NoResultException e){
            e.printStackTrace();
        }
        Logger.info("All weddings got.");
        return weddings;
    }
}
