
//problem 1

// Time Complexity : o(n)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        if (dp[coins.length][amount] > amount) {
            return -1;
        }

        return dp[coins.length][amount];

    }
}

// Problem 2
// approach 1 T.C O(n)
// S.C O(n)

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[][] dp = new int[nums.length][2];

        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}

// approach 2 T.C o(n)
// approcah 2 S.C o(1)

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int skip = 0, take = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }

        return Math.max(skip, take);
    }
}