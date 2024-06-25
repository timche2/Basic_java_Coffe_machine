package Tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_4 {
    static Scanner scaner = new Scanner(System.in);
    public static void main(String[] args) {
        int num_choice;
        String produkt;
        ArrayList <String> buscket = new ArrayList<>();
        while (1==1){
            System.out.println("Выберите функцию(введите цифру):");
            System.out.println("1.Добавить продукт");
            System.out.println("2.Удалить продукт");
            System.out.println("3.Список продуктов");
            System.out.println("4.Выйти");
            num_choice = scaner.nextInt();
            if (num_choice==4 || (num_choice!=1 && num_choice!=2 && num_choice!=3 && num_choice!=4)){
                break;
            }
            else if (num_choice==1){

                System.out.println("Введите называние продутка:");
                produkt = scaner.next();
                buscket.add(produkt);
            }
            else if (num_choice==2){
                System.out.println("Введите называние продутка:");
                produkt = scaner.next();
                buscket.remove(produkt);
            }
            else if (num_choice==3){
                System.out.println("Ваши продукты:"+buscket);
            }

        }
    }
}
