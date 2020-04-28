package coding_interviews;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class Interview_4 {


    public static void main(String[] args) {
        int[][] arr = {{-1,3}};
        System.out.println(findNumberIn2DArray(arr, 3));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int row = matrix.length;
        if(row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if(col == 0) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == target || matrix[i][col - 1] == target) {
                return true;
            }
            if (matrix[i][0] < target && matrix[i][col - 1] > target) {
                result = bSearch(matrix[i], target);
                if (result) {
                    return true;
                }
            }
        }
        return result;
    }

    public static boolean bSearch(int[] arr, int target) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            } else if(target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
