package service;

import hu.preznyak.weddingschedule.dao.WeddingDAO;
import hu.preznyak.weddingschedule.entity.Contract;
import hu.preznyak.weddingschedule.entity.Wedding;
import hu.preznyak.weddingschedule.service.WeddingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeddingServiceTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WeddingScheduleTestPU");
    private EntityManager em = emf.createEntityManager();
    private WeddingDAO weddingDAO;
    private WeddingService weddingService;

    private Wedding wedding;

    @Before
    public void initWeddingServiceTest(){
        weddingDAO  = new WeddingDAO(em);
        weddingService = new WeddingService(weddingDAO);
        wedding = new Wedding("Katalin","József", LocalDate.ofYearDay(2018,240),
                "Székelyhíd","Vegas Band","FotoVideo",new Contract(500,200));
        weddingService.createWedding(wedding);
    }

    @Test
    public void createWedding() throws Exception {
        assertEquals(true,weddingService.createWedding(wedding));
    }

    @Test
    public void getAllWeddings() throws Exception {
        assertEquals(1,weddingService.getAll().size());
    }

    @Test
    public void getMyIncome() throws Exception {
        assertEquals(wedding.getContract().getPrice(), weddingService.getMyIncome(),0.1);
    }

    @Test
    public void getMyDeposit() throws Exception {
        assertEquals(wedding.getContract().getDeposit(), weddingService.getMyDeposits(), 0.1);
    }

    @Test
    public void deleteWedding() throws Exception {
        assertEquals(true, weddingService.deleteWedding(wedding));
    }
}
