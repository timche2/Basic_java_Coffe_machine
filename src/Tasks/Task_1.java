package Tasks;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {
    static Scanner scaner = new Scanner(System.in);
    public static void main(String[] args) {
        String st="Hello World";
        boolean f=false, t=true;
        ArrayList <String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");

        System.out.println(Byte.TYPE+"\t" + Byte.MIN_VALUE
                + "\t" + Byte.MAX_VALUE);
        System.out.println(Short.TYPE+"\t" + Short.MIN_VALUE
                + "\t" + Short.MAX_VALUE);
        System.out.println(Integer.TYPE+"\t\t" + Integer.MIN_VALUE
                + "\t" + Integer.MAX_VALUE);
        System.out.println(Float.TYPE+"\t"+ Float.MIN_VALUE
                + "\t" + Float.MAX_VALUE);
        System.out.println(Long.TYPE+"\t" + Long.MIN_VALUE + "\t"
                + Long.MAX_VALUE);
        System.out.println(Double.TYPE+"\t"  + Double.MIN_VALUE
                + "\t" + Short.MAX_VALUE);
        System.out.println(Character.TYPE+"\t"+ Character.MAX_VALUE+ "\t"+Character.MIN_VALUE );
        System.out.println("String" +"\t"+st);
        System.out.println(Boolean.TYPE+"\t"+t+"\t"+f);
        System.out.println("Array" +"\t"+arr);
    }
}