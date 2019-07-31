package lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
//            int a = 1;
//            int b = 5;
//            System.out.println(b / a);
//
//            try {
//                int[] arr = new int[5];
//                System.out.println("Cейчас должна быть ошибка ");
//                arr[88] = 888;
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("in словили исключение ArrayIndexOutOfBoundsException");
////                throw e;
//                throw new RuntimeException("Сами создали");
//            }
//
//        } catch (ArithmeticException e) {
//            System.out.println("словили исключение ArithmeticException");
//            e.printStackTrace();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("out словили исключение ArrayIndexOutOfBoundsException");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        FileInputStream fis= null;
////        try {
////            fis = new FileInputStream("1.txt");
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        } finally {
////            System.out.println("блок finally");
////            try {
////                fis.close();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }

//        try(Scanner sc = new Scanner(System.in)) {
//            System.out.println(sc.nextLine());
//        }catch (Exception e){
//
//        }finally {
//
//        }

//        try {
//            int a = 0;
//            int b = 5;
//            System.out.println(b / a);
//        }catch (RuntimeException e){
//            System.out.println("блок catch");
//        }finally {
//            System.out.println("блок finally");
//        }

//        try {
//            openFile("1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        try {
//            System.out.println(fact(-5));
//        } catch (FactorialException e) {
//            e.printStackTrace();
//            System.out.println(e.getValue());
//        }

        System.out.println("END");

        String[][] words ={
                {"234","654","3","34"},
                {"444","4","5645"},
                {"3","3","22","789"},
        };

        int i = Integer.parseInt(words[0][1]);
        System.out.println(i);
        System.out.println(words.length);
        System.out.println(words[2].length);


    }

    public static int fact(int n) throws FactorialException {
        if (n < 1) {
            throw new FactorialException(n);
        }
        int value = 1;
        for (int i = 1; i <= n; i++) {
            value *= i;
        }
        return value;
    }

    public static void openFile(String filename) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
    }


    public static int[] getArr(int n) {
        if (n > 0) {
            return new int[n];
        } else {
            throw new IllegalArgumentException("Размер массива " + n);
        }
    }

    public static void a() {
        b();
    }

    public static void b() {
        c();
    }

    public static void c() {
        d();
    }

    public static void d() {
        int a = 0;
        int b = 5;
        System.out.println(b / a);
    }
}
