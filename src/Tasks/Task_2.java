package Tasks;
import java.util.Scanner;

public  class Task_2 {
    static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        float num_1;
        float num_2;
        System.out.println("Введите два числа");
        System.out.println("Число 1:");
        num_1 = scaner.nextFloat();
        System.out.println("Число 2:");
        num_2 = scaner.nextFloat();
        if (num_1 > num_2) {
            System.out.println("Большее число:" + num_1);
        } else if (num_1 < num_2) {
            System.out.println("Большее число:" + num_2);
        } else {
            System.out.println("Числа равны");
        }
    }
}