package max_profit;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {


    public static void main(String[] args) {
        int[] profits = new int[] {7,6,4,3,1};
        System.out.println(maxProfit(profits));
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 290 ms, 在所有 Java 提交中击败了16.01%的用户
     * 内存消耗 :
     * 39.8 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int realLP = 0;
        int realRP = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            realLP = i;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    realRP = j;
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;

    }

    /**
     * 执行用时 :
     * 245 ms, 在所有 Java 提交中击败了22.10%的用户
     * 内存消耗 :
     * 39.8 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //如果prices[i]大于之前的最小值，无论往后怎样二次遍历,
            //prices[j] - min > prices[j] - prices[i]
            //以此达到剪枝节省时间的目的
            if (prices[i] < min) {
                min = prices[i];
            } else {
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;

    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 1 ms, 在所有 Java 提交中击败了99.12%的用户
     * 内存消耗 :
     * 39.5 MB, 在所有 Java 提交中击败了5.02%的用户
     * @param prices
     * @return
     *
     * 这个做法是继承了上面的那个做法了的，
     * 记录最小值，然后后面的每一个值，如果存在
     * 最大利润，一定是与这个最小值之间的差值
     * 这里做的是转化成一次遍历了。
     */
    public static int maxProfit3(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                //更新最小值
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                //每次与之前的最小值取差值
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;

    }

}
