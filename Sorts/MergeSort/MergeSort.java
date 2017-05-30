package Sorts.MergeSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Data-Structures-and-Algorithms-1
 * Created by @author jerdys on 31.05.17
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }

        mergeSort(array);

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] mergeSort(int[] array) {

        if (array.length == 1) {
            return array;
        }

        int[] array1 = mergeSort(Arrays.copyOf(array, array.length / 2));
        int[] array2 = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));

        int i = 0, j = 0, k = 0;

        while (i < array1.length || j < array2.length) {
            while (i < array1.length && j < array2.length) {
                if (array1[i] <= array2[j]) {
                    array[k] = array1[i];
                    i++;
                    k++;
                }
                else {
                    array[k] = array2[j];
                    j++;
                    k++;
                }
            }
            if (i == array1.length) {
                array[k] = array2[j];
                j++;
                k++;
            }
            else {
                array[k] = array1[i];
                i++;
                k++;
            }
        }

        return array;
    }
}
