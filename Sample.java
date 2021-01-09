// Time Complexity :O(amount * n) where n is the denomination count
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
* 1. Coin Change - DP
*/

class Solution {
    
    //Recursive approach
    /*public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) retunr -1;
        return helper();
    }
    
    private int helper(int[] coins, int amount, int index, int min){
        //base
        if(amount == 0) return min;
        if(amount < 0 || index == coins.length) return -1;
        //logic
        //choose the coin
        int case1 = helper(coins, amount - coins[index], index, min + 1);
        //dont choose the coin
        int case2 = helper(coins, amount, index + 1, min);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }
    */
    
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = 999999;
        }
        for(int i = 1;i<dp.length; i++){
            for(int j = 1; j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result >= 999999) return -1;
        return result;
    }
    
}

//Time Complexity :O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :


//Your code here along with comments explaining your approach
/*
* 2. House Robber - DP
*/

class Solution2 {
    //Recursion approach time complexity is exponential
    /*public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount){
        //base
        if(index >= nums.length) return amount;
        //logic
        //when choosen
        int case1 = helper(nums, index + 2, amount + nums[index]);
        //when not choosen
        int case2 = helper(nums, index + 1, amount);
        return Math.max(case1, case2);
    }
    */
    /*DP approach with m*n matrix where the time complexity is O(m*n) and space is O(n))
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    } 
    */
	//DP approach with 2 variables where the time complexity is O(n) and space is O(1))
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int skip = 0;
        int take = nums[0];
        for(int i = 1;i<nums.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
	
}
