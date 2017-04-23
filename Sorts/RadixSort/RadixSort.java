package Sorts.RadixSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jerdys on 23.04.17.
 */

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {57, 2, 345, 28, 13, 0, 147};
        int max = 0, rank = 0;

        System.out.println("Unsorted Array:\n" + Arrays.toString(nums) + "\n");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        while (max > 0) {
            max /= 10;
            rank += 1;
        }

        ArrayList<String>[] list = new ArrayList[10];
        String[] sNums = new String[nums.length];
        int counter;

        for (int i = 0; i < 10; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            sNums[i] = "";
            sNums[i] = nums[i] + "";
        }

        for (int i = 0; i < sNums.length; i++) {
            counter = sNums[i].length();

            while (counter < rank) {
                sNums[i] = "0" + sNums[i];
                counter++;
            }
        }

        ArrayList newList = new ArrayList();
        String str;
        int divider = 1, k = 0;

        while (k != rank) {
            for (int i = 0; i < sNums.length; i++) {
                int radix = (Integer.parseInt(sNums[i]) / divider) % 10;

                list[radix].add(sNums[i]);
            }

            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    str = list[i].get(j);
                    newList.add(str);
                }
            }

            for (int i = 0; i < list.length; i++) {
                list[i].clear();
            }

            divider *= 10;
            k += 1;

            System.arraycopy(newList.toArray(), 0, sNums, 0, sNums.length);
            newList.clear();
        }

        for (int i = 0; i < sNums.length; i++) {
            nums[i] = Integer.parseInt(sNums[i]);
        }

        System.out.println("Sorted Array:\n" + Arrays.toString(nums));
    }
}
