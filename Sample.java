//Problem 1:
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The general idea of this solution is to figure out how this problem can be
// done in an exhaustive approach, then figuring out how we can store the already
// calculated values into the dp array. 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        System.out.println("length is "+ dp.length);
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int a = 1;a<amount+1;a++){
            for(int c: coins){
                if(a-c >= 0){
                    dp[a] = Math.min(dp[a], 1+dp[a-c]);
                }
            }
        }
        if(dp[amount] == amount+1){
            return -1;
        }
        return dp[amount];
    }
}


//Problem 2:
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The general approach to this solution is to store the up to date max 
// robbing value in the dp array, and update its max based on the condition
// that we can not rob two houses in a row. 
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
        }


        return dp[nums.length];
    }
}