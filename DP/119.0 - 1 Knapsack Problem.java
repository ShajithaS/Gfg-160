/*
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
*/
class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=wt.length;
        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0)
                dp[i][j]=0;
                else{
                    int pick=0;
                    if(wt[i-1]<=j)
                    pick=val[i-1]+dp[i-1][j-wt[i-1]];
                    int notpick=dp[i-1][j];
                    dp[i][j]=Math.max(pick,notpick);
                }
            }
        }
        return dp[n][W];
    }
}
