package array;

import java.util.Arrays;

public class SortedArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 8, 10, 11};
        System.out.println(Arrays.toString(solution(arr, 15)));
    }

    private static int[] solution(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int[] s = new int[2];
        while(left < right) {
            int result = arr[left] + arr[right];
            if (result == target) {
                s[0] = left + 1;
                s[1] = right + 1;
                return s;
            } else if (result < target) {
                left++;
            } else {
                right--;
            }
        }
        return s;
    }

}
