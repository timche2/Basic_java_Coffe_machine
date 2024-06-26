package org.example;

import java.util.Scanner;

public class Menu {

    static Scanner scaner = new Scanner(System.in);
    int userChoice;
    Machine machine = new Machine();


    public void switcher(int userChoice){
        while (true) {
            switch (userChoice) {
                case (1):
                    userChoice=powerOnMenu();
                    continue;
                case (2):
                    System.out.println("Good buy!Come again!");
                    break;
                case (3):
                    userChoice = addServesmenu();
                    continue;
                case (4):
                    userChoice = viewServesmenu();
                    continue;
                case (5):
                    userChoice = makeDrinkMenu();
                    continue;
                case (6):
                    userChoice = cleaningMenu();
                    continue;
            }
            break;
        }
        return;
    }
    public int powerOnMenu(){
        System.out.println("Hello!What are you want?\n" +
                "1.Power On\n" +
                "2.Power Off\n" +
                "3.Add Serves\n"+
                "4.View Serves\n"+
                "5.Make a Drink\n"+
                "6.Cleaning");
        userChoice = scaner.nextInt();

        return userChoice;
    }
    public int viewServesmenu(){
        System.out.println("Serwes:\n" +
                "Coffee: " + machine.getCoffe_serves() + "kg " + "/ 0.5kg\n" +
                "Milk: " + machine.getMilk_serves() + "l " + "/ 5l\n" +
                "Water: " + machine.getWater_serves() + "l " + "/ 5l\n\n");

        return 1;
    }
    public int addServesmenu() {
        while (true) {
            System.out.println("What are you want to add?\n" +
                    "1.Coffee\n" +
                    "2.Milk\n" +
                    "3.Water\n" +
                    "4.Back to main menu");

            userChoice = scaner.nextInt();
            if (userChoice == 4) {
                return 1;
            }
            System.out.println("How many you want to add?");
            int result = machine.addServes(userChoice);
            switch (result) {
                case (1):
                    break;
                case (2):
                    System.out.println("Storage is crowded!");
                    break;
                case (3):
                    System.out.println("Too many!");
                    break;
            }
        }
    }
    public int makeDrinkMenu() {
        while (true) {
            System.out.println("Which is drnk?\n" +
                    "1." + res.CAPUCHINO + "\n" +
                    "2." + res.ESPRESSO + "\n" +
                    "3.Back to main menu\n\n");
            int choiceDrink = scaner.nextInt();
            int choiceDrinkReturn=machine.makeDrink(choiceDrink);
            switch (choiceDrinkReturn) {
                case 3:
                    return (1);
                case 1:
                    System.out.println("Thank you!\n");
                    break;
                case 2:
                    System.out.println("Insufficient resources!\n");
                    break;
            }
        }
    }
    public int cleaningMenu(){
        System.out.println("Dirty cups: " + machine.getDirtCup() + "/10");
        switch (machine.clleaningCheck()){
            case 1:
                System.out.println("Machine is clean\n");
                break;
            case 2:
                System.out.println("Some cups are dirty.Are you want to clean machine?\n"+
                        "1.Yes\n"+
                        "2.No\n");
                if (scaner.nextInt()==1){
                    machine.cleaninig();
                    System.out.println("All cups are clean\n");
                }else if(scaner.nextInt()==2) {
                    System.out.println("Okay\n");
                }
                break;
            case 3:
                System.out.println("All cups are dirty.Are you want to clean machine?\n"+
                        "1.Yes\n"+
                        "2.No\n");
                if(scaner.nextInt()==1){
                    System.out.println("All cups are clean\n");
                    machine.cleaninig();
                }else if(scaner.nextInt()==2) {
                    System.out.println("Okay\n");
                }
                break;
        }
        return 1;
    }



}