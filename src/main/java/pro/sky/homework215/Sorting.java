package pro.sky.homework215;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        //проверка
        int[] arr = generateRandomArray();
        int[] arr2 = Arrays.copyOf(arr, 100_000);
        int[] arr3 = Arrays.copyOf(arr, 100_000);

        long start = System.currentTimeMillis();
        sortBubble(arr);
        System.out.println("Время пузырьковой сортировки: " + (System.currentTimeMillis() - start) + " мс"); //самая быстрая сортировка
        sortSelection(arr2);
        System.out.println("Время сортировки выбором: " + (System.currentTimeMillis() - start) + " мс");
        sortInsertion(arr3);
        System.out.println("Время сортировки вставкой: " + (System.currentTimeMillis() - start) + " мс");

        int element = 99;
        System.out.println("Результат бинарного поиска: " + (binarySearch(arr, element)));
    }

    private static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1) + 99_999;
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static boolean binarySearch(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
