package home_work_1_exc;

import java.util.Arrays;
import java.util.Scanner;

public class Trow_demo {
    public static void main(String[] args) {
        System.out.println(division(2, 2));
        int [] array = toArray();
        System.out.println(Arrays.toString(array));
        int[]arr = new int[] {5, 9, 8, 6, 3};
        System.out.println(valueOfIndex(arr, 3));
        divisionArraysElements(array, arr);

    }

    public static int division(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Я не умею делить на ноль)");
        }
        return a / b;
    }

    public static int[] toArray() {
        int[]arr = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите число");
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else throw new RuntimeException("Введено не число");
        }
        scanner.close();
        return arr;
    }

    public static int valueOfIndex(int[] arr, int index) {
       if (index < arr.length) {
           return arr[index];
       } else throw new RuntimeException("Выход за пределы массива");
    }
 /*
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и
    возвращающий новый массив, каждый элемент которого равен разности
    элементов двух входящих массивов в той же ячейке. Если длины массивов
    не равны, необходимо как-то оповестить пользователя.
  */
    public static int[] divisionArraysElements(int[]arr1, int[]arr2) {
        int[]result = new int[arr2.length];
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] / arr2[i];
            }
        } else throw new RuntimeException("Массивы различной длинны");
        return result;
    }
}
