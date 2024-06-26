package org.example;

import java.util.Scanner;

public class Machine {

    static Scanner scaner = new Scanner(System.in);
    private static double coffe_serves = 0.15;
    private static double milk_serves = 1;
    private static double water_serves = 1;

    public static void setDirtCup(int dirtCup) {
        Machine.dirtCup = dirtCup;
    }

    private static int dirtCup = 0;

    public int getDirtCup() {
        return dirtCup;
    }

    public double getCoffe_serves() {
        return coffe_serves;
    }

    public double getMilk_serves() {
        return milk_serves;
    }

    public double getWater_serves() {
        return water_serves;
    }



    //    Menu mn =new Menu();
    public int start() {
        Menu powerOn = new Menu();

        powerOn.switcher(1);

        return 0;
    }

    public void powerOff() {
                start();
    }

    public int addServes(int value) {

        double valueGram;
        switch (value) {
            case (1):
                valueGram = scaner.nextDouble();
                if (coffe_serves + valueGram <= 0.5) {
                    coffe_serves += valueGram;
                    return 1;
                } else if (coffe_serves >= 0.5) {
                    return 2;
                } else {
                    return 3;
                }
            case (3):
                valueGram = scaner.nextDouble();
                if (water_serves + valueGram <= 5) {
                    water_serves += valueGram;
                    return 1;
                } else if (water_serves >= 5) {
                    return 2;
                } else {
                    return 3;
                }
            case (2):
                valueGram = scaner.nextDouble();
                if (milk_serves + valueGram <= 5) {
                    milk_serves += valueGram;
                    return 1;
                } else if (milk_serves >= 5) {
                    return 2;
                } else {
                    return 3;
                }
        }
        return 0;
    }

    public int makeDrink(int userDrink){
        switch (userDrink) {
            case 1:
                if ((coffe_serves - res.CAPUCHINO.getCoffee() >= 0) && (milk_serves - res.CAPUCHINO.getMilk() >= 0) && (water_serves - res.CAPUCHINO.getWater()) >= 0) {
                    coffe_serves = -res.CAPUCHINO.getCoffee();
                    milk_serves = -res.CAPUCHINO.getMilk();
                    water_serves = -res.CAPUCHINO.getWater();
                    setDirtCup(getDirtCup() + 1);
                    return 1;
                } else {
                    return 2;
                }

            case 2:
                if (coffe_serves - res.ESPRESSO.getCoffee() >= 0 && milk_serves - res.ESPRESSO.getMilk() >= 0 && water_serves - res.ESPRESSO.getWater() >= 0) {
                    coffe_serves = -res.ESPRESSO.getCoffee();
                    milk_serves = -res.ESPRESSO.getMilk();
                    water_serves = -res.ESPRESSO.getWater();
                    setDirtCup(getDirtCup() + 1);
                    return 1;
                } else {
                    return 2;
                }
            case 3:
                return 3;
        }
        return 0;
    }

    public int clleaningCheck(){
        if (dirtCup==0){
            return 1;
        }else if(dirtCup>0){
            return 2;
        }else if(dirtCup==10){
            return 3;
        }
        return 0;
    }
    public void cleaninig(){
        dirtCup=0;
        return;
    }
}