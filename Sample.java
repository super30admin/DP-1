
Question 1: https://leetcode.com/problems/coin-change/

Recursion:
// Time Complexity : 2 ^ no.of.coins
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        return helper(coins, 0, amount, 0);
    }
    public int helper(int[] coins, int index, int amount, int minCoins){
        //base
        if(amount == 0) return minCoins;
        if(amount < 0 || index == coins.length) return -1;
        
        //NOT choose first coin: 0 case
        int case0 = helper(coins, index+1, amount, minCoins);
        
            
        //choose first case: 1 case
        int case1 = helper(coins, index, amount-coins[index], minCoins+1);
        
        if(case0==-1) return case1; 
        if(case1==-1) return case0;
        
        return Math.min(case0, case1);
    }
}


Dynamic Programming:
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i = 1;i<dp[0].length;i++){
            dp[0][i]=amount+1;
        }
        
        for(int i = 1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j]; 
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        int res = dp[dp.length-1][dp[0].length-1];
        if(res>=amount+1) return -1;
        return res;
        
    }
}









Question 2: https://leetcode.com/problems/house-robber/

Recursion:
// Time Complexity : 2 ^ no.of.coins
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        return helper(nums,0);
    }
    public int helper(int[] nums, int index){
        if(index>=nums.length) return 0;
        
        int case0=helper(nums, index+1);
        int case1=helper(nums, index+2) + nums[index];
        return Math.max(case0, case1);
    }
}

Dynamic Programming:
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
    if(nums==null || nums.length==0) return 0;
    
    int n = nums.length;
    int dp[][] = new int[n][2];
        
    dp[0][1] = nums[0];
    
    for(int i=1;i<n;i++){
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        dp[i][1] = dp[i-1][0] +nums[i];
    }
        return Math.max(dp[n-1][0], dp[n-1][1]);
        
    }
}