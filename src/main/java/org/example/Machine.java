package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Machine {

    final Scanner scaner = new Scanner(System.in);
    private double coffeServes = 1;
    private double milkServes = 2;
    private double waterServes = 2;
    private Map<Integer, String> profiles = new HashMap<>();
    private String logDrinks = "";

    public void setLogDrinks(String logDrinks) {
        this.logDrinks = logDrinks + this.logDrinks;
    }

    public String getLogDrinks() {
        return logDrinks;
    }

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

    public double getCoffeeServes() {
        return coffeServes;
    }

    public double getMilkServes() {
        return milkServes;
    }

    public double getWaterServes() {
        return waterServes;
    }

    public void start() {
        Menu powerOn = new Menu();
        powerOn.switcher(1);
    }

    public int addServes(int value) {
        Double valueGram;
        String valueGramUser;
        switch (value) {
            case (1):
                valueGramUser = scaner.nextLine();
                valueGram = inputChecked(valueGramUser,0.0,5.0);
                if (coffeServes + valueGram <= 5) {
                    coffeServes += valueGram;
                    return 1;
                } else if (coffeServes >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (3):
                valueGramUser = scaner.nextLine();
                valueGram = inputChecked(valueGramUser,0.0,5.0);
                if (waterServes + valueGram <= 5) {
                    waterServes += valueGram;
                    return 1;
                } else if (waterServes >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (2):
                valueGramUser = scaner.nextLine();
                valueGram = inputChecked(valueGramUser,0.0,5.0);
                if (milkServes + valueGram <= 5) {
                    milkServes += valueGram;
                    return 1;
                } else if (milkServes >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (4):
                return 4;
        }
        return 0;
    }

    public int makeDrink(int userDrink,int count) {
        switch (userDrink) {
            case 1:
                if (count + getDirtCup() > 10) {
                    return 4;
                }
                if ((coffeServes - Reserves.CAPUCHINO.getCoffee()*count >= 0) &&
                        (milkServes - Reserves.CAPUCHINO.getMilk()*count >= 0) &&
                        (waterServes - Reserves.CAPUCHINO.getWater()*count) >= 0) {
                    coffeServes = coffeServes - Reserves.CAPUCHINO.getCoffee()*count;
                    milkServes = milkServes - Reserves.CAPUCHINO.getMilk()*count;
                    waterServes = waterServes - Reserves.CAPUCHINO.getWater()*count;
                    setDirtCup(getDirtCup() + count);
                    return 1;
                } else {
                    return 2;
                }
            case 2:
                if (getDirtCup() + count > 10) {
                    return 4;
                }
                if (coffeServes - Reserves.ESPRESSO.getCoffee() *count >= 0 &&
                        milkServes - Reserves.ESPRESSO.getMilk() * count >= 0 &&
                        waterServes - Reserves.ESPRESSO.getWater()*count >= 0) {
                    coffeServes = coffeServes - Reserves.ESPRESSO.getCoffee()*count;
                    milkServes = milkServes - Reserves.ESPRESSO.getMilk()*count;
                    waterServes = waterServes - Reserves.ESPRESSO.getWater()*count;
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

    public int makeDrink(int cap,int esp,int count) {
                if (count + getDirtCup() > 10) {
                    return 4;
                }
                if ((coffeServes - Reserves.CAPUCHINO.getCoffee()*count >= 0) &&
                        (milkServes - Reserves.CAPUCHINO.getMilk()*count >= 0) &&
                        (waterServes - Reserves.CAPUCHINO.getWater()*count) >= 0 &&
                        coffeServes - Reserves.ESPRESSO.getCoffee() *count >= 0 &&
                        milkServes - Reserves.ESPRESSO.getMilk() * count >= 0 &&
                        waterServes - Reserves.ESPRESSO.getWater()*count >= 0) {

                    coffeServes = coffeServes - Reserves.CAPUCHINO.getCoffee()*count;
                    milkServes = milkServes - Reserves.CAPUCHINO.getMilk()*count;
                    waterServes = waterServes - Reserves.CAPUCHINO.getWater()*count;

                    coffeServes = coffeServes - Reserves.ESPRESSO.getCoffee()*count;
                    milkServes = milkServes - Reserves.ESPRESSO.getMilk()*count;
                    waterServes = waterServes - Reserves.ESPRESSO.getWater()*count;
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

    public int createProfile(int cup,int esp,int espValue,int cupValue,String userName) {
        if (cupValue == 10) {
            cupValue = 0;
        }
        if (espValue == 10) {
            espValue = 0;
        }
        int keyProfile = (10000 + cupValue * 1000 + cup * 100 + espValue * 10 + esp);
        profiles.put(keyProfile, userName);
        return keyProfile;
    }

    public int cleaningCheck() {
        if (dirtCup == 0) {
            return 1;
        }else if(dirtCup > 0 && dirtCup < 10) {
            return 2;
        }else if(dirtCup == 10) {
            return 3;
        }
        return 0;
    }
    public void cleaninig() {
        dirtCup=0;
    }

    public int inputChecked(String userChoice, int minValue,int maxValue) {
        while (true) {
            try {
                if (userChoice.equals("")) {
                    userChoice=scaner.nextLine();
                    continue;
                }
                int userChoiceInt = Integer.parseInt(userChoice);
                if (userChoiceInt < minValue || userChoiceInt > maxValue) {
                    System.out.println("Incorrect input!Try again!\n" +
                            "You can enter numbers from " + minValue +" to "+ maxValue);
                } else {
                    return userChoiceInt;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!Try again!\n" +
                        "You can enter numbers from " + minValue + " to " + maxValue);
            }
            userChoice=scaner.nextLine();
        }
    }

    public Double inputChecked(String userChoice, Double minValue, Double maxValue) {
        while (true) {
            if (userChoice.equals("")) {
                userChoice=scaner.nextLine();
                continue;
            }
            try {
                double userChoiceInt = Double.parseDouble(userChoice);
                if(userChoiceInt < minValue || userChoiceInt > maxValue) {
                    System.out.println("Incorrect input!Try again!\n" +
                            "You can enter numbers from " + minValue + " to " + maxValue);
                }else {
                    return userChoiceInt;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!Try again!\n"+
                        "You can enter numbers from " + minValue + " to " + maxValue);
            }
            userChoice=scaner.nextLine();
        }
    }

    public String inputChecked(String nameDrink) {
        while (true) {
            try {
                Reserves.valueOf(nameDrink);
                return nameDrink;
            } catch (java.lang.IllegalArgumentException value) {
                System.out.println("There is no such recipe.\n" +
                        "Try again!");
            }
            nameDrink = scaner.nextLine();
        }
    }
}