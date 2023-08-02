package home_work_2_exc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Try_catch_demo {
    public static void main(String[] args) {

        /*
            Задание 2
        */
        try {
            int d = 0;
            int[] intArray = {1, 6, 7, 5, 9, 5, 9};
            double catchedRes1 =  intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }


        // printUsersNumber();
    }

    /*
        Реализуйте метод, который запрашивает у пользователя ввод
        дробного числа (типа float), и возвращает введенное значение.
        Ввод текста вместо числа не должно приводить к падению приложения,
        вместо этого, необходимо повторно запросить у пользователя ввод данных.
    */
    public static void printUsersNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число");

        try {
            System.out.println(scanner.nextFloat());
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат, дробная часть отделена ',' ");
            printUsersNumber();
        }
    }
    /*
    Разработайте программу, которая выбросит Exception, когда
    пользователь вводит пустую строку. Пользователю должно
    показаться сообщение, что пустые строки вводить нельзя.
     */


}
