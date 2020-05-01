package coding_interviews;

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 88.74%
 * 的用户
 * 内存消耗 :
 * 36.8 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */
public class Interview_13 {
    static boolean[][] flag;
    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(movingCount(3, 2, 17));
    }
    public static int movingCount(int m, int n, int k) {
        flag = new boolean[m][n];
        helper(0, 0, k);
        return sum;
    }

    public static void helper(int row, int col, int k) {

        if (row > flag.length - 1 || row < 0 || col < 0 || col > flag[0].length - 1) {
            return;
        }

        int m1 = row / 10;
        int m2 = row % 10;
        int n1 = col / 10;
        int n2 = col % 10;
        int t = m1 + m2 + n1 + n2;

        if (!flag[row][col] && t <= k) {
            sum++;
        } else {
            return;
        }
        flag[row][col] = true;
        helper(row + 1, col, k);
        helper(row, col + 1, k);
        helper(row - 1, col, k);
        helper(row, col - 1, k);
    }

}
