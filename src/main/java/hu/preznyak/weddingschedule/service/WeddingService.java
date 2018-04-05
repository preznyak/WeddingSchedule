package hu.preznyak.weddingschedule.service;

import hu.preznyak.weddingschedule.dao.WeddingDAO;
import hu.preznyak.weddingschedule.entity.Wedding;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link WeddingService} class.
 *
 * @author Preznyák László
 * @version 1.0
 */

public class WeddingService {

    /**
     * A {@link WeddingDAO} object.
     */
    private WeddingDAO weddingDAO;

    /**
     * Constructor for {@link WeddingService}.
     * @param weddingDAO a {@link WeddingDAO} object.
     */
    public WeddingService(WeddingDAO weddingDAO) { this.weddingDAO = weddingDAO; }

    /**
     * Method for saving a {@link Wedding} in the database.
     * @param wedding a {@link Wedding} object.
     * @return boolean A boolean value which shows that the operation was successful or not.
     */
    public boolean createWedding(Wedding wedding){
        return weddingDAO.createWedding(wedding);
    }

    /**
     * Method for deleting a {@link Wedding} object from the database.
     * @param wedding The {@link Wedding} object which will be deleted.
     * @return boolean A boolean value which shows that the operation was successful or not.
     */
    public boolean deleteWedding(Wedding wedding){
        return weddingDAO.deleteWedding(wedding);
    }

    /**
     * A method for getting all the {@link Wedding} objects from the database.
     * @return List a List of {@link Wedding} objects.
     */
    public List<Wedding> getAll(){
        return weddingDAO.getAll();
    }

    /**
     * A method for computing the income from the registered {@link hu.preznyak.weddingschedule.entity.Contract} objects.
     * @return double The expected income of the user.
     */
    public double getMyIncome(){
        return getAll().stream()
                .map(wedding -> wedding.getContract().getPrice())
                .collect(Collectors.summingDouble(Double::doubleValue));
    }

    /**
     * A method for computing the sum of the deposits from the registered {@link hu.preznyak.weddingschedule.entity.Contract} objects.
     * @return double The sum of the deposits.
     */
    public double getMyDeposits(){
        return getAll().stream()
                .map(wedding -> wedding.getContract().getDeposit())
                .collect(Collectors.summingDouble(Double::doubleValue));
    }


}
