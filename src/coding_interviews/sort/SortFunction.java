package coding_interviews.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class SortFunction {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 3, 2, 6, 9, 29};
        int[] temp = arr;
        bubbleSort(temp);
        System.out.println("冒泡排序: " + Arrays.toString(temp));
        temp = arr;
        selectSort(temp);
        System.out.println("选择排序："+ Arrays.toString(temp));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序，每次找到最小或者最大的数据，放到排序好的第一位或者最后一位
     * @param arr 数组
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
