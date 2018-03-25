package hu.preznyak.weddingschedule.service;

import hu.preznyak.weddingschedule.dao.WeddingDAO;
import hu.preznyak.weddingschedule.entity.Wedding;

import java.util.List;

public class WeddingService {

    private WeddingDAO weddingDAO;

    public WeddingService(WeddingDAO weddingDAO) { this.weddingDAO = weddingDAO; }

    public boolean createWedding(Wedding wedding){
        return weddingDAO.createWedding(wedding);
    }

    public boolean deleteWedding(Wedding wedding){
        return weddingDAO.deleteWedding(wedding);
    }

    public List<Wedding> getAll(){
        return weddingDAO.getAll();
    }

    public double getMyIncome(){
        List<Wedding> weddings = getAll();
        double income = 0.0;
        for (Wedding wedding: weddings){
            income += wedding.getContract().getPrice();
        }
        return income;
    }

    public double getMyDeposits(){
        List<Wedding> weddings = getAll();
        double deposit = 0.0;
        for (Wedding wedding: weddings){
            deposit += wedding.getContract().getDeposit();
        }
        return deposit;
    }


}
