// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m + 1][n + 1];

        //fill the first row with Infinity apart from amount = 0
        //we put amount + 1 instead of infinity. because max num of coins can never be more than amount
        for(int j = 1; j <= n; j++) {
            dp[0][j] = amount + 1;
        }

        //Perform Memoization:-
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                //if coin > amount then it will be Infinity
                //hence we removed 2nd part
                if(coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else {

                    //case 0 :- we do not choose the coin
                    //case 1:- we choose the coin hence plus 1
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }

        int result = dp[m][n];
        if(result >= amount + 1)
            return -1;
        
        return result;
    }
}