// Time Complexity : Exponential. 2^n (n is the length of nums array)
// Space Complexity : O(2n) = O(n)
// Did this code successfully run on Leetcode : No(time limit exceeded)
// Any problem you faced while coding this : Yes(got stackoverflowerror on line 23 but resolved by adding >= condition on line 18)


// Your code here along with comments explaining your approach

//by using exhaustive approach
class Solution {
    public int rob(int[] nums) {
        if(nums.length== 0 || nums == null) return 0;
        return helper(nums, 0,0);
        
    }
    private int helper(int[] nums, int index, int robbedAmount){
//base
if(index>=nums.length){
    return robbedAmount;
}
//logic
//do not rob or 0 case
int case1 = helper(nums,index + 1, robbedAmount);
//rob or 1 case
        int case2= helper(nums, index + 2, robbedAmount + nums[index]);
        return Math.max(case1,case2);
    }
}
// Time Complexity : O(n) where n is no. of houses
// Space Complexity : O(2n) = O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//By using DP choose and not choose and building a DP 2D matrix

class Solution {
    public int rob(int[] nums) {
        if(nums.length== 0 || nums == null) return 0;
        int n = nums.length;
       int dp[][] = new int[n][2];
    //    dp[0][0] = 0; // by default the value is 0 in Java
       dp[0][1] = nums[0];
       for(int i=1;i<n;i++){
           //get the max value of chose or not chose from previous row 
           //not chose
        dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
        //get the value of previous row not chose condition and add the current amount
        //chose
         dp[i][1] = dp[i-1][0] + nums[i];

       }
       //return the max of last row
       return Math.max(dp[n-1][0],dp[n-1][1]);
        
    }
}

// Time Complexity : O(n) where n is no. of houses
// Space Complexity : O(1) [As we are not building 2D matrix]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//Lets implement by DP taking two variables skip and take instead of using 2D matrix

//by using exhaustive approach
class Solution {
    public int rob(int[] nums) {
        if(nums.length== 0 || nums == null) return 0;
        int n = nums.length;
   int skip = 0;
    int take = nums[0];
       for(int i=1;i<n;i++){
        //use temp variable to avoid being overriden when computing chose
           int temp = skip;
           //not chose
       skip = Math.max(skip,take);
        //chose
        take = temp + nums[i];

       }
       //return the max of last row
       return Math.max(skip,take);
        
    }
}