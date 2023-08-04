package services;

import models.Sneaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class SneakerServiceTest {

    SneakerService sneakerService = new SneakerService();

    @Test
    public void createTest() {

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        double expectedSize = 10.5;

        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        double actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQuantity();
        float actualPrice = testSneaker.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSport, actualSport);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
        sneakerService.clear();

    }

    @Test
    public void testFind() {

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        double expectedSize = 10.5;

        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker expected = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        Sneaker actual = sneakerService.findSneaker(1);
        // actual = sneakerService.findSneaker(0);
        Assertions.assertEquals(expected, actual);
        sneakerService.clear();

    }
    @Test
    public void testDelete() {
        SneakerService s = new SneakerService();
        Sneaker s1 = s.create("Stan Smith", "Adidas", "Tennis", 10.5,10, 80.00f );
        Sneaker s2 = s.create( "NOTStan Smith", "NOTAdidas", "NOTTennis", 5.5,133, 55.00f );
        boolean expectedDelete = true;
        boolean actual = s.delete(1);
        int expectint = 1;
        Assertions.assertEquals(expectedDelete,actual);
        s.clear();
    }

    @Test
    public void testDelete2() {
        SneakerService ss = new SneakerService();
        Sneaker s1 = ss.create("Stan Smith", "Adidas", "Tennis", 10.5,10, 80.00f );
        Sneaker s2 = ss.create( "NOTStan Smith", "NOTAdidas", "NOTTennis", 5.5,133, 55.00f );
        ss.delete(s1.getId());
        //boolean expectedDelete = true;
        //boolean actual = s.delete(1);
        int expectint = 1;
        Assertions.assertEquals(expectint,ss.findAll().length);
        ss.clear();
    }
}