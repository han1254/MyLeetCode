package max_profit;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxProfitPlus {

    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(mastProfit(array));
    }

    /**
     * 2020/4/5
     * @param prices
     * @return
     */
    public static int mastProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public static int calculate(int[] prices, int position) {
        //首先我们要判断是不是数组越界，如果越界，此递归结束
        //此时蓝框框内没有元素，那么篮框框内的利润为零
        if (position >= prices.length) {
            return 0;
        }

        //到这里我就想了，我要获得最大的利润，我得有个值去记录
        //它呀
        int max = 0;

        //接下来我们就要开始循环，从第一个开始，然后接着它二重循环
        for (int i = position; i < prices.length; i++) {
            //在二重遍历里面，我们想要获得的是啥?
            //正如上图，
            //1.我们需要知道j与i指针之间的利润profile1
            //2.需要知道后面蓝框框里的最大利润值profile2
            for(int j = position + 1; j < prices.length; j++) {
                int temp = 0;
                if (prices[j] > prices[i]) {
                    temp = (prices[j] - prices[i]) + calculate(prices, j + 1);
                }
                if(temp > max) {
                    max = temp;
                }
            }
        }

        return max;

    }

}
