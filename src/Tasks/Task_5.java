
package Tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_5 {
    static Scanner scaner = new Scanner(System.in);
    public static void main(String[] args) {
        int num_choice;
        String password;
        String passsword_user;
        System.out.println("Придумйте пароль:");
        password = scaner.next();
        System.out.println("Введите ваш пароль:");
        passsword_user = scaner.next();
        while (passsword_user.equals(password)!=true){
            System.out.println("Пароль не верный!");
            System.out.println("1.Попробовать ещё");
            System.out.println("2.Выйти");
            num_choice = scaner.nextInt();
            if (num_choice==1) {
                System.out.println("Введите ваш пароль:");
                passsword_user = scaner.next();
            }else if(num_choice==2){
                System.out.println("До свидания!");
                break;
            }
        }
        if (passsword_user.equals(password)==true){
            System.out.println("Пароль верный,спасибо!");
        }
    }
}