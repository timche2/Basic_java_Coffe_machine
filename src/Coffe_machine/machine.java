package Coffe_machine;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class machine {
    static Scanner scaner = new Scanner(System.in);
    public static void main(String[] args) {
        int value_input = scaner.nextInt();
        switch (value_input){
            case (1):
                System.out.println("Hello!What are you want?");
                value_input = scaner.nextInt();
                break;
            case (2):
                System.out.println("Good buy!Come again!");
                break;
        }
    }
}