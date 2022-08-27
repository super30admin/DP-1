// Time complexity : O(m*n)

// Space complexity : O(m*n)

// Approach: We used a bottom up dynamic programming approach to solve repeated sub problems using the exhaustive approach. We took a 2D array of the two contraints where the rows are the coins (we added a 0th row as a dummy row and a 0th column as a dummy column) and the columns are the amounts in increasing order from 0 to amount.

// We can optimize space further by only using 1D array as we only need previous and current row.

// Steps to approach DP:
// 1. Try Greedy approach - that is we only take the best choice at the moment. Just 1 path. This will fail for [2,5] and amount 6 as we will take 5 as the first count and will return false as the next coin we will take is 2. 5+2 is 7. But the coin combination is possible, 2,2,2 = 6.
// 2. Try exhaustive approach. Here we use recursion to find all possible paths by choosing all different kinds of combinations of coins and then find out the minimum path. This works but will give time limit exceeded as it is an exponential time complexity solution as at every step, there are two choices whether to select the coin or not.
//3. Now when we notice there are a lot of repeating sub problems in the exhaustive approach, that is when we use DP. There are two types, top down and bottom up approach. Here we took bottom up. Choose between 1-D and 2-D array for our dp based on contraints given in the problem. For example our result is affected by the two contraints, coin denominations and amount. So we take a 2D array where rows is coins and columns is amount.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        for (int j = 1; j <= amount; j++) {
            dp[j] = amount+1;
        }
        
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i-1]) {
                    dp[j] = Math.min(dp[j] , dp[j-coins[i-1]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}