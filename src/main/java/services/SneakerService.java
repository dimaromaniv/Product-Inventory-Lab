package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService extends Sneaker{
    private static int nextID = 1;
    private ArrayList<Sneaker> inventory = new ArrayList<>();


    public Sneaker create(String expectedName, String expectedBrand, String expectedSport, double expectedSize, int expectedQty, float expectedPrice) {
        Sneaker sneaker = new Sneaker(nextID++, expectedName, expectedBrand, expectedSport, expectedSize, expectedQty, expectedPrice);
        this.inventory.add(sneaker);
        return sneaker;
    }

    public Sneaker findSneaker(int i) {
        for (Sneaker s : inventory) {
            if (s.getId() == i) {
                return s;
            }
        }
        return null;
    }

    public Sneaker[] findAll() {

        return inventory.toArray(new Sneaker[0]);
        // should return a basic array copy of the ArrayList
    }

    //delete
    public boolean delete(int id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == id) {
                inventory.remove(i);
            }
            return true;
        }

        return false;
    }

    public void getInvetoryReport () {
        for (Sneaker s : inventory) {
            System.out.println("Id: " + s.getId() +"\n" + "Name: " + s.getName()+"\n"  + "Qty: " + s.getQty()  );
        }
    }

    public void clear() {
        inventory.clear();
    }

}
