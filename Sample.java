// Problem1
// Time Complexity : O(n * l) where n = coins array length, l = amount
// Space Complexity : O(n) -> extra space for 2D array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - initialize 2D dp array with size equal to coins length and amount + 1
// 2 - loop over array and amount
// 3 - if current amount less than coin, get result of previous
// 4 - else get min of previous and 1 + amount - current coin value
// 5 - return last element of dp
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for (int i=0; i<=coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int j=1; j<=amount; j++) {
            dp[0][j] = 99999;
        }
        
        // 2
        for (int i=1; i<=coins.length; i++) {
            for (int j=1; j<=amount; j++) {
                // 3
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else { // 4
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        // 5
        return dp[coins.length][amount] >= 99999 ? -1 : dp[coins.length][amount];
    }
}

// Problem2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze choose and dontchoose
// 2 - loop over array
// 3 - intialize temp to store previous dontchoose
// 4 - dontchoose is max of previous choose and dontchoose
// 5 - choose is sum of previous dontchoose and current value
// 6 - return max of choose and dontchoose
class Solution {
    public int rob(int[] nums) {
        // 1
        int choose = 0;
        int dontChoose = 0;
        
        // 2
        for (int i=0; i<nums.length; i++) {
            // 3
            int temp = dontChoose;
            
            // 4
            dontChoose = Math.max(choose, dontChoose);
            // 5
            choose = temp + nums[i];
        }
        
        // 6
        return Math.max(choose, dontChoose);
    }
}