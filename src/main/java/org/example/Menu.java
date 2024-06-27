package org.example;

import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private final Scanner scaner = new Scanner(System.in);
    private int userChoice;
    private final Machine machine = new Machine();


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
                case (7):
                    userChoice = createProfileMenu();
                    continue;
                case 8:
                    userChoice = choiceProfileMenu();
                    continue;
            }
            break;
        }
    }

    public int powerOnMenu() {
        System.out.println("Hello!What are you want?\n" +
                "1.Power On\n" +
                "2.Power Off\n" +
                "3.Add Serves\n"+
                "4.View Serves\n"+
                "5.Make a Drink\n"+
                "6.Cleaning\n"+
                "7.Create profile\n"+
                "8.Speed dial by profile");
        String userChoice = scaner.nextLine();
        return (machine.inputChecked(userChoice,1,8));

    }

    public int viewServesmenu(){
        System.out.println("Serwes:\n" +
                "Coffee: " + machine.getCoffee_serves() + "kg " + "/ 5kg\n" +
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

            String userChoiceInput = scaner.nextLine();
            userChoice = machine.inputChecked(userChoiceInput,1,4);
            if (userChoice == 4) {
                break;
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
                case (4):
                    return 1;
            }
        }
        return 1;
    }

    public int makeDrinkMenu() {
        while (true) {
            System.out.println("Which is drnk?\n" +
                    "1." + res.CAPUCHINO + "\n" +
                    "2." + res.ESPRESSO + "\n" +
                    "3.Back to main menu");
            String choiceDrinkInput = scaner.nextLine();
            int choiceDrink = machine.inputChecked(choiceDrinkInput,1,3);
            String kindCoffee = "";
            switch (choiceDrink){
                case 3:
                    return (1);
                case 2:
                    kindCoffee = "ESPRESSO";
                case 1:
                    kindCoffee = "CAPUCHINO";
            }
            int count = howManyCupsMenu();
            if (count==-1){
                continue;
            }
            int choiceDrinkReturn=machine.makeDrink(choiceDrink,count);
            switch (choiceDrinkReturn) {
                case 1:
                    System.out.println("Thank you!\n"+
                            "Take your " + count + " cup(s) of " + kindCoffee);
                    break;
                case 2:
                    System.out.println("Insufficient resources!\n");
                    break;
                case 4:
                    System.out.println("Not enough clean cups!Please, clean the machine\n");
                    break;
            }
        }
    }

    public int cleaningMenu() {
        System.out.println("Dirty cups: " + machine.getDirtCup() + "/10");
        switch (machine.cleaningCheck()){
            case 1:
                System.out.println("Machine is clean\n");
                break;
            case 2:
                System.out.println("Some cups are dirty.Are you want to clean machine?\n"+
                        "1.Yes\n"+
                        "2.No\n");
                String valueInput = scaner.nextLine();
                int value = machine.inputChecked(valueInput,1,2);
                if (value==1){
                    machine.cleaninig();
                    System.out.println("All cups are clean\n");
                }else if(value==2) {
                    System.out.println("Okay\n");
                }
                break;
            case 3:
                System.out.println("All cups are dirty.Are you want to clean machine?\n"+
                        "1.Yes\n"+
                        "2.No\n");
                valueInput = scaner.nextLine();
                value = machine.inputChecked(valueInput,1,2);
                if(value==1){
                    System.out.println("All cups are clean\n");
                    machine.cleaninig();
                }else if(value==2) {
                    System.out.println("Okay\n");
                }
                break;
        }
        return 1;
    }

    public int howManyCupsMenu() {
        System.out.println("How many cups are you want?\n"+
                "1.One cup\n" +
                "2.Three cups\n" +
                "3.Enter a number\n"+
                "4.Cancel\n");
        String choiceNumberInput = scaner.nextLine();
        int choiceNumber = machine.inputChecked(choiceNumberInput,1,4);
        if (choiceNumber == 3) {
            System.out.println("Enter a number");
        }
        return machine.howManyCups(choiceNumber);
    }

    public int createProfileMenu(){
        System.out.println("What is your name?");
        String nameUser = scaner.nextLine();
        int cap = 0;
        int esp = 0;
        int capValue = 0;
        int espValue = 0;
        while (true) {
            System.out.println("Hello, " + nameUser + "!\n" +
                    "What is drink you want to add in your profile?\n" +
                    "1." + res.CAPUCHINO + "\n" +
                    "2." + res.ESPRESSO + "\n" +
                    "3.Save\n"+
                    "4.Back to main menu");
            String choiceNumberInput = scaner.nextLine();
            int choiceNumber = machine.inputChecked(choiceNumberInput, 1, 4);
            switch (choiceNumber) {
                case 4:
                    return 1;
                case 1:
                    cap = 1;
                    System.out.println("How much cups?(Enter a number)");
                    String choiceCapValue = scaner.nextLine();
                    capValue = machine.inputChecked(choiceCapValue, 1, 10);
                    break;
                case 2:
                    esp = 2;
                    System.out.println("How much cups?(Enter a number)");
                    String choiceEspValue = scaner.nextLine();
                    espValue = machine.inputChecked(choiceEspValue, 1, 10);
                    break;
            }
            if (choiceNumber == 3){
                break;
            }
        }
        int keyUser = machine.createProfile(cap,esp,espValue,capValue,nameUser);
        System.out.println("Profile created!\n" +
                "Name: " + nameUser + "\n"+
                "The key for speed dial: " + keyUser);
        return 1;
    }

    public int choiceProfileMenu () {
        Map<Integer, String> profiles = machine.getProfiles() ;
        if (profiles.size() == 0){
            System.out.print("There are no profiles\n" +
                    "You can create them from the main menu\n");
            return 1;
        }
        System.out.print("Find your profile and enter the code:\n");
        for(Map.Entry<Integer, String> entry: profiles.entrySet()) {
            System.out.print(entry.getValue() + " ");
            System.out.println(entry.getKey());
        }
        System.out.print("10000.Back to main menu\n");
        String profileKeyInput = scaner.nextLine();
        int profileKey = machine.inputChecked(profileKeyInput, 10000, 19192);
        if (profileKey == 10000){
            return 1;
        }
        for(Map.Entry<Integer, String> entry: profiles.entrySet()) {
            Integer key = entry.getKey();
            String nameUser = entry.getValue();
            if (profileKey == key){
                fastDialMenu((profileKey / 1000) % 10,(profileKey / 100) % 10,
                        (profileKey / 10) % 10,profileKey % 10,nameUser);
                return 1;
            }
        }
        return 1;
    }
    public int fastDialMenu(int cupCount,int cup, int espCount,int esp,String userName){
        int choiceDrinkReturn=0;
        if(cup+esp == 3) {
            choiceDrinkReturn = machine.makeDrink(cup,esp ,cupCount);
            switch (choiceDrinkReturn) {
                case 1:
                    System.out.println("Take your " + cupCount + " cup(s) of " + res.CAPUCHINO);
                    break;
                case 2:
                    System.out.println("Insufficient resources!\n");
                    break;
                case 4:
                    System.out.println("Not enough clean cups!Please, clean the machine\n");
                    break;
            }
            return 1;
        }






        if(cup != 0 ) {
            choiceDrinkReturn = machine.makeDrink(cup, cupCount);
            switch (choiceDrinkReturn) {
                case 1:
                    System.out.println("Take your " + cupCount + " cup(s) of " + res.CAPUCHINO);
                    break;
                case 2:
                    System.out.println("Insufficient resources!\n");
                    break;
                case 4:
                    System.out.println("Not enough clean cups!Please, clean the machine\n");
                    break;
            }
        }
        if (esp != 0 && (choiceDrinkReturn != 2) && choiceDrinkReturn != 4){
            choiceDrinkReturn = machine.makeDrink(esp, espCount);
            switch (choiceDrinkReturn) {
                case 1:
                    System.out.println("Take your " + espCount + " cup(s) of " + res.ESPRESSO);
                    break;
                case 2:
                    System.out.println("Insufficient resources!\n");
                    break;
                case 4:
                    System.out.println("Not enough clean cups!Please, clean the machine\n");
                    break;
            }
        }

        return 1;
    }


}