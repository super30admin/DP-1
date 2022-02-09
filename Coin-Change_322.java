import java.utils.*;
// Time Complexity : O(n*c) where  n = amount and c = no of coins
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// find the recurrence relation or what we call as subproblem
// in this case if we know the optimal solution for smaller amout then we can calculate for larger
//dp[i] stores the least number of coins for amount i
//dp[i] = min {dp[i-c1] +  1 , dp[i-c2] +  1, ...... } where c1, c2 are the coins given
// base case dp[0] = 0
class Solution {
    public int coinChange(int[] coins, int amount) {

        //Holds optimal coins needed of each amount represented via index
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i=0; i<=amount; i++) {
            int val = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++) {
                if (i-coins[j] >=0 && dp[i-coins[j]] >=0) {
                    val = Math.min(val, dp[i-coins[j]] + 1);
                }
                if (val < Integer.MAX_VALUE) {
                    dp[i] = val;
                }
            }
        }
        return dp[amount];
    }
}
