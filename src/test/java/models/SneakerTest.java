package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SneakerTest {


        @Test
        public void setNameTest() {
            // given (1)
            String expected = "OZWEEGO";

            // when (2)
            Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
            testSneaker.setName(expected);

            // then (3)
            Assertions.assertEquals(expected, testSneaker.getName());
        }


    @Test
    void setId() {
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
        int expected = 2;
        testSneaker.setId(expected);
        Assertions.assertEquals(expected,testSneaker.getId());


    }

    @Test
    void setName() {
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
        String expected = "name";
        testSneaker.setName(expected);
        Assertions.assertEquals(expected,testSneaker.getName());
    }

    @Test
    void setBrand() {
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
        String expected = "Nike";
        testSneaker.setBrand(expected);
        Assertions.assertEquals(expected,testSneaker.getBrand());
    }

    @Test
    void setSize() {
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
        double expected = 11.5;
        testSneaker.setSize(expected);
        Assertions.assertEquals(expected,testSneaker.getSize());

    }

    @Test
    void setQty() {
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
        int expected = 22;
        testSneaker.setQty(expected);
        Assertions.assertEquals(expected,testSneaker.getQty());
    }

    @Test
    void setPrice() {
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);
        float expected = 90.00f;
        testSneaker.setPrice(expected);
        Assertions.assertEquals(expected,testSneaker.getPrice());
    }

    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (3)
        Sneaker testSneaker = new Sneaker( 6, "Stan Smith", "Adidas", "Tennis", 10.5, 10, 80.00f);

        // (4)
        Assertions.assertEquals(expectedId, testSneaker.getId());
        Assertions.assertEquals(expectedName, testSneaker.getName());
        Assertions.assertEquals(expectedBrand, testSneaker.getBrand());
        Assertions.assertEquals(expectedSport, testSneaker.getSport());
        Assertions.assertEquals(expectedQty, testSneaker.getQty());
        Assertions.assertEquals(expectedPrice, testSneaker.getPrice());}
}