// Time Complexity : O(n.m) where n = length of array and m is the amount
// Space Complexity : O(m) // where m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int a = amount;
        int dp[] = new int [a+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i =1;i<dp.length;i++){
            for(int j =0;j<coins.length;j++){
                if(i-coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);  
                }
            }
        }

        if(dp[a] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[a];
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int dp[] = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i =2;i<n;i++){
            int incl = nums[i] + dp[i-2];
            int excl = dp[i-1];
            dp[i] = Math.max(incl, excl);
        }
        

       return dp[n-1];
    }

    public int helper(int []nums, int n , int dp[]){
        if(n<0){
            return 0;
        }

        if(n == 0){
            return nums[n];
        }

        if(dp[n]!= -1){
            return dp[n];
        }

        int incl = nums[n] + helper(nums, n -2 , dp);

        int excl = helper(nums, n-1, dp);

        dp[n] =  Math.max(incl, excl); 

        return dp[n];
    }
}