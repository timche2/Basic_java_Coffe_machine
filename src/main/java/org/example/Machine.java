package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Machine {

    final Scanner scaner = new Scanner(System.in);
    private double coffe_serves = 1;
    private double milk_serves = 2;
    private double water_serves = 2;
    private Map<Integer, String> profiles = new HashMap<>();

    public Map<Integer, String> getProfiles() {
        return profiles;
    }

    public void setDirtCup(int dirtCup) {
        this.dirtCup = dirtCup;
    }

    private int dirtCup = 0;

    public int getDirtCup() {
        return dirtCup;
    }

    public double getCoffee_serves() {
        return coffe_serves;
    }

    public double getMilk_serves() {
        return milk_serves;
    }

    public double getWater_serves() {
        return water_serves;
    }

    //    Menu mn =new Menu();
    public void start() {
        Menu powerOn = new Menu();
        powerOn.switcher(1);
    }

    public void powerOff() {
        start();
    }

    public int addServes(int value) {
        Double valueGram;
        String valueGramUser;
        switch (value) {
            case (1):
                valueGramUser = scaner.nextLine();
                valueGram = inputChecked(valueGramUser,0.0,5.0);
                if (coffe_serves + valueGram <= 5) {
                    coffe_serves += valueGram;
                    return 1;
                } else if (coffe_serves >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (3):
                valueGramUser = scaner.nextLine();
                valueGram = inputChecked(valueGramUser,0.0,5.0);
                if (water_serves + valueGram <= 5) {
                    water_serves += valueGram;
                    return 1;
                } else if (water_serves >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (2):
                valueGramUser = scaner.nextLine();
                valueGram = inputChecked(valueGramUser,0.0,5.0);
                if (milk_serves + valueGram <= 5) {
                    milk_serves += valueGram;
                    return 1;
                } else if (milk_serves >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (4):
                return 4;
        }
        return 0;
    }

    public int makeDrink(int userDrink,int count){
        switch (userDrink) {
            case 1:
                if (count * getDirtCup() >= 10){
                    return 4;
                }
                if ((coffe_serves - res.CAPUCHINO.getCoffee()*count >= 0) &&
                        (milk_serves - res.CAPUCHINO.getMilk()*count >= 0) &&
                        (water_serves - res.CAPUCHINO.getWater()*count) >= 0) {
                    coffe_serves = coffe_serves - res.CAPUCHINO.getCoffee()*count;
                    milk_serves = milk_serves - res.CAPUCHINO.getMilk()*count;
                    water_serves = water_serves - res.CAPUCHINO.getWater()*count;
                    setDirtCup(getDirtCup() + count);
                    return 1;
                } else {
                    return 2;
                }

            case 2:
                if (getDirtCup()==10){
                    return 4;
                }
                if (coffe_serves - res.ESPRESSO.getCoffee() *count >= 0 &&
                        milk_serves - res.ESPRESSO.getMilk() * count >= 0 &&
                        water_serves - res.ESPRESSO.getWater()*count >= 0) {
                    coffe_serves = coffe_serves - res.ESPRESSO.getCoffee()*count;
                    milk_serves = milk_serves - res.ESPRESSO.getMilk()*count;
                    water_serves = water_serves - res.ESPRESSO.getWater()*count;
                    setDirtCup(getDirtCup() + count);
                    return 1;
                } else {
                    return 2;
                }
            case 3:
                return 3;

        }
        return 0;
    }
    public int makeDrink(int cap,int esp,int count){
                if (count * getDirtCup() >= 10){
                    return 4;
                }
                if ((coffe_serves - res.CAPUCHINO.getCoffee()*count >= 0) &&
                        (milk_serves - res.CAPUCHINO.getMilk()*count >= 0) &&
                        (water_serves - res.CAPUCHINO.getWater()*count) >= 0 &&
                        coffe_serves - res.ESPRESSO.getCoffee() *count >= 0 &&
                        milk_serves - res.ESPRESSO.getMilk() * count >= 0 &&
                        water_serves - res.ESPRESSO.getWater()*count >= 0) {

                    coffe_serves = coffe_serves - res.CAPUCHINO.getCoffee()*count;
                    milk_serves = milk_serves - res.CAPUCHINO.getMilk()*count;
                    water_serves = water_serves - res.CAPUCHINO.getWater()*count;

                    coffe_serves = coffe_serves - res.ESPRESSO.getCoffee()*count;
                    milk_serves = milk_serves - res.ESPRESSO.getMilk()*count;
                    water_serves = water_serves - res.ESPRESSO.getWater()*count;
                    setDirtCup(getDirtCup() + count);
                    return 1;
                } else {
                    return 2;
                }
    }
    public int howManyCups(int choiceNumber) {
        switch (choiceNumber) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                String value = scaner.nextLine();
                return inputChecked(value,0,10);
            case 4:
                return -1;
        }
        return 0;
    }

    public int createProfile (int cup,int esp,int espValue,int cupValue,String userName){
        if (cupValue == 10){
            cupValue = 0;
        }
        if (espValue == 10){
            espValue = 0;
        }
        int keyProfile = (10000 + cupValue * 1000 + cup * 100 + espValue * 10 + esp);
        profiles.put(keyProfile, userName);
        return keyProfile;
    }
    public int choiceProfile(){

        return 1;
    }

    public int cleaningCheck() {
        if (dirtCup == 0){
            return 1;
        }else if(dirtCup > 0 && dirtCup < 10) {
            return 2;
        }else if(dirtCup == 10){
            return 3;
        }
        return 0;
    }
    public void cleaninig() {
        dirtCup=0;
    }

    public int inputChecked(String userChoice, int minValue,int maxValue){
        while (true) {
            try {
                if (userChoice.equals("")){
                    userChoice=scaner.nextLine();
                    continue;
                }
                int userChoiceInt = Integer.parseInt(userChoice);
                if(userChoiceInt < minValue || userChoiceInt > maxValue){
                    System.out.println("Incorrect input!Try again!\n"+
                            "You can enter numbers from " +minValue+" to "+maxValue);
                } else {
                    return userChoiceInt;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!Try again!\n"+
                        "You can enter numbers from " +minValue+" to "+maxValue);
            }
            userChoice=scaner.nextLine();
        }
    }
    public Double inputChecked(String userChoice, Double minValue, Double maxValue){
        while (true) {
            if (userChoice.equals("")){
                userChoice=scaner.nextLine();
                continue;
            }
            try {
                double userChoiceInt = Double.parseDouble(userChoice);
                if(userChoiceInt < minValue || userChoiceInt > maxValue){
                    System.out.println("Incorrect input!Try again!\n"+
                            "You can enter numbers from " +minValue+" to "+maxValue);
                }else {
                    return userChoiceInt;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!Try again!\n"+
                        "You can enter numbers from " +minValue+" to "+maxValue);
            }
            userChoice=scaner.nextLine();
        }
    }
}