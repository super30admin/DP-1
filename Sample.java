
//1) coin change 
// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) { return -1;}

        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i= 1; i< amount +1 ; i++){
            dp[0][i] = amount +1;
        }

        for (int i = 1; i< n+1 ; i++){
            for (int j = 1; i< amount +1; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{

                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+ 1);
                }

            }
        }

        if (dp[n][amount] == amount + 1){

        return -1;

        }

    return dp[n][amount];


    }
}

//2) House Robber
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0 ) { return 0;}
        int n = nums.length;
        int skip = 0, take;

        take = nums[0];

        for (int i = 1 ; i< n ; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];


        }

        return Math.max(skip,take);
    }
}
