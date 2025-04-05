class Solution {
    int memo[];
    public int rob(int[] nums) {
       int n= nums.length;
       int[] dp = new int[n];
       dp[0] = nums[0];
       if(n==1)
       return dp[0];
       dp[1] = Math.max(dp[0],nums[1]+0);
       for(int i=2;i<n;i++)
       {
        dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
       }
       return dp[n-1];
    }

   
}

//tc: O(n)
//sc: O(n)