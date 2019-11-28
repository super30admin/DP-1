//Brute force
// Time Complexity  - O(2^n)
//Space Complexity - O(2^n)
// This code did not work on LeetCode and ended in Time Limit Exceeded error.

class Solution {
    public int rob(int[] nums) {
        return helper(nums,0,0);
    }
    private int helper(int[] nums,int i,int amount){
        // Base Case
        if(i >=nums.length) return amount;
        // Logic
        //chosen
        int Case1 = helper(nums,i+2,amount+nums[i]);
        //not chosen
        int Case2 = helper(nums,i+1,amount);
        return Math.max(Case1,Case2);
    }
}

// Dynamic Programing using array
// Time Complexity  - O(n)
//Space Complexity - O(n)
// This solution worked on Leecode

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0)  return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        
        dp[0][0] = 0; //not choose for first house
        dp[0][1] = nums[0]; //choose  for first house
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]); // not choose
            dp[i][1] = dp[i-1][0] + nums[i];  // choose
        }
        return Math.max(dp[n-1][0],dp[n-1][1]); // return maximum of both choose and not choose amount sum
    }
}

// Dynamic Programing using 3 variables chosen, not chosen and temp instead of dp array to save all the previous amount from houses
// Time Complexity  - O(n)
//Space Complexity - O(1)
// This solution worked on Leetcode
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0)  return 0;
        int n = nums.length;        
        int notchosen = 0; //not chosen
        int chosen = nums[0];
        int temp = notchosen;
        for(int i=1;i<n;i++){
            temp = notchosen;  // save the previous notchosen value for it will be used for calculating chosen
            notchosen = Math.max(chosen,notchosen);
            chosen = temp + nums[i];
        }
        return Math.max(chosen,notchosen);
    }
}
