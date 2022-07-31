// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;   
        int n = nums.length;
        if(n==1) return nums[0];
        
        int[] dp = new int[n];
        //fill dp[0] with nums[0];
        dp[0] = nums[0];
        //fill dp[1] with  max value between nums[0] and nums[1];
        dp[1] = Math.max(nums[0],nums[1]);
        //now we have two values in the dp array start iterating from 2nd index
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+ dp[i-2]);
            //dp[i] is max value between previous index and curent nums[i]+ dp[n-2] 
            
        }
        return dp[n-1];
    }
}
