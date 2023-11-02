
public class Stock_BuySell {
    public static void main(String[] args) {
        int[] prices = { 7,6,4,3,1 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int left = 0, right = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[left] > prices[right]) {
                left = right;
                right = right + 1;

            }
            else {
                max_profit = Math.max(max_profit, (prices[right] - prices[left]));
                right += 1;
            }
        }

        return max_profit;
    }
}
