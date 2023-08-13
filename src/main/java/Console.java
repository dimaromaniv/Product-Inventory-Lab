import services.SneakerService;

import java.util.Scanner;
//package io;


public class Console extends SneakerService {

    public static void printWelcome() {
        System.out.println("" +
                "*****************************************************"+"\n"+
                "***           Welcome and Bienvenue               ***"+"\n"+
                "***                    to                         ***"+"\n"+
                "***          ZipCo Inventory Manager              ***"+"\n"+
                "*****************************************************");
    }


    public static void printMainMenu() {
        System.out.println(""+
                        "*****************************************************"+"\n"+
                        "***          Press number to make choice          ***"+"\n"+
                        "***           [1]    Create a new product         ***"+"\n"+
                        "***           [2]    Read existing products       ***"+"\n"+
                        "***           [3]    Update product               ***"+"\n"+
                        "***           [4]    Delete product               ***"+"\n"+
                        "***           [5]    Get reports about products   ***"+"\n"+
                        "***           [6]    Exit the program             ***"+"\n"+
                        "*****************************************************"

                );
    }

    public static void createAProduct(){

    }

}
