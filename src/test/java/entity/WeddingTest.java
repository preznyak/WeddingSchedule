package entity;

import hu.preznyak.weddingschedule.entity.Contract;
import hu.preznyak.weddingschedule.entity.Wedding;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class WeddingTest {
    private Wedding wedding;

    @Before
    public void initWedding(){
        wedding = new Wedding();

        wedding.setId(1);
        wedding.setBrideName("Kovács Katalin");
        wedding.setGroomName("Fülöp Lajos");
        wedding.setBandName("Hungária");
        wedding.setDate(LocalDate.ofYearDay(2018,205));
        wedding.setLocale("Debrecen");
        wedding.setFotoVideo("MiskaFotó");
        wedding.setContract(new Contract(500,200));

    }

    @Test
    public void getBrideName() throws Exception {
        assertEquals("Kovács Katalin", wedding.getBrideName());
    }

    @Test
    public void getGroomName() throws Exception {
        assertEquals("Fülöp Lajos", wedding.getGroomName());
    }

    @Test
    public void getBandName() throws Exception {
        assertEquals("Hungária", wedding.getBandName());
    }

    @Test
    public void getDate() throws Exception {
        assertEquals(LocalDate.ofYearDay(2018,205), wedding.getDate());
    }

    @Test
    public void getLocale() throws Exception {
        assertEquals("Debrecen", wedding.getLocale());
    }
    @Test
    public void getFotoVideo() throws Exception {
        assertEquals("MiskaFotó", wedding.getFotoVideo());
    }

    @Test
    public void getContract() throws Exception {
        assertEquals(500, wedding.getContract().getPrice(), 0.00001);
        assertEquals(200, wedding.getContract().getDeposit(), 0.00001);
    }
}
