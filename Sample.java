// Time Complexity :O(n * k) -> n for max amount loop, k for no of coins
// Space Complexity : O(n) -> DP array for max amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can solve this problem using recursion but we have to
// solve repetative sub problems and greedy choices do not work
// hence we choose to go with DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        //1D DP array
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            // Loop for each coin
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Time Complexity: O(n), where n is the number of houses
//   - We process each house once and do constant work per house
// Space Complexity: O(1)
//   - Only a fixed array of size 3 is used regardless of input size

class Solution {
    public int minCost(int[][] costs) {        
        int[] dp = new int[3]; // dp[i] holds min cost if the last house is painted with color i
        
        for(int i=0; i<costs.length; i++){
            // Calculate current costs based on previous row
            int dp0 = costs[i][0] + Math.min(dp[1], dp[2]); // Paint red
            int dp1 = costs[i][1] + Math.min(dp[0], dp[2]); // Paint blue 
            int dp2 = costs[i][2] + Math.min(dp[0], dp[1]); // Paint green
            
            // Update dp with new costs
            dp[0] = dp0; dp[1] = dp1; dp[2] = dp2;
        }
        // Return minimum of final choices
        return Math.min(dp[0], Math.min(dp[1], dp[2]));   
    }
}
