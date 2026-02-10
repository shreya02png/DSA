
public class BestTimeToBuySell {

    // Brute Force
    // Reminder: "Try every buy-sell pair"
    static int brute(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // Optimal (One Pass)
    // Reminder: "Track minimum so far"
    static int optimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if(price < minPrice) {
                minPrice = price; 
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

// Brute → O(n²)
// Optimal → O(n)
// Space → O(1)
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        System.out.println(brute(prices));
        System.out.println(optimal(prices));
    }
}
