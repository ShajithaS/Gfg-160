//Stock Buy and Sell – Max one Transaction Allowed
class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
         if (prices == null || prices.length < 2) {
            return 0; 
        }
        int minPrice = Integer.MAX_VALUE; 
        int max = 0; 
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                max = Math.max(max, price - minPrice);
            }
        }
        return max;
    }
}
