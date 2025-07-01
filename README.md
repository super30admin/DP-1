# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
// Time Complexity : O(m*n) where m = number of rows and n = number of cols
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will initialize a 2D dp array and fill the first row with infinity because in case if none of the coins sum of to amount we can return infinity which is represented by amount+1;
2. We will check in the if condition whether the current amount(represented by j) is less than the coin(represented by i) if yes, then we will copy the value in the previous row and the current col to the current row nd current col
3. Else we will find out the minimum bw the two (prev row and current col) & ( current row and col is represnted by amount - the value of coin)

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;

        int[][] dp = new int[coins.length + 1][amount + 1];

        // initialize the first row (i = 0) with "infinity"
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // don't take
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // take or don't take
                }
            }
        }

        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }
}

## Problem2 (https://leetcode.com/problems/house-robber/)
// Time Complexity : O(n) where n = number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will declare a 2 variable skip(it means we will not rob from the current house) and take (it represents that we will rob from the current house)
2. we will run a loop and update skip with whatever the prev max was between take and skip
3. and take will be sum of the cash present in the current house and the prev skip;
4. we will return the max bw skip or take


class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int skip = 0;
        int take = nums[0];

        for(int i=1; i<nums.length; i++){
            int tempSkip = skip;
            skip = Math.max(take, skip);
            take = tempSkip+nums[i];
        }

        return Math.max(skip,take);
    }

}