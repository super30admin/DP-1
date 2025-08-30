// Time Complexity : O(m*n)
// Space Complexity : O(n)

// Use a single dp array to keep track of the min number of coins required to make that index amount
// At every step return the min of taking the coin or not taking the coin
// In the end if it returns a large number return -1 otherwise return the value

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1]; 
        dp[0] = 0;
        for(int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE - 10;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int case1 = dp[j];
                if(j < coins[i-1])
                    dp[j] = case1;
                else {
                    int case2 = 1 + dp[j-coins[i-1]];
                    dp[j] = Math.min(case1, case2);
                }
            }
        }
        if(dp[n] >= Integer.MAX_VALUE - 10)
            return -1;
        return dp[n];
    }
}