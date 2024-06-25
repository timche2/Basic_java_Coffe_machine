package Tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_3 {
    static Scanner scaner = new Scanner(System.in);
    public static void main(String[] args) {
        int num_1;
        int num_2;
        int numc;
        numc = 2;
        int numche = 13;
        num_1 = scaner.nextInt();
        num_2 = scaner.nextInt();
        while (num_1 != num_2+1) {
            numche=num_1;
            while (true) {
                if (numc == num_1-1 || num_1==1 || num_1==2 || (numc*-1)==num_1+1 || num_1==-2) {
                    System.out.println(numche + " ");
                    numc=2;
                    break;
                }
                if (numche % numc != 0) {
                    numc = numc + 1;
                    continue;
                } else {
                    numc = 2;
                    break;
                }
            }
            num_1=num_1+1;
        }
    }
}