class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        
        int skip=0;
        int take=nums[0];
        int prevSkip=-1;
        
        for(int i=1;i<n;i++)
        {
            prevSkip=skip;
            skip=Math.max(skip,take);
            take=nums[i]+prevSkip;
            
        }
        
        return Math.max(skip,take);
        
        // Time Complexity : O(n)
        // Space Complexity : O(1)         
        
        /*int[] dp=new int[n];
        
        if(n==1) return nums[0];
        
        if(n==2) return Math.max(nums[0],nums[1]);
        
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=dp[0]+nums[2];
        
        for(int i=3;i<n;i++)
        {
            dp[i]=nums[i]+Math.max(dp[i-2],dp[i-3]);
            
        }
        
        return Math.max(dp[n-1],dp[n-2]);

        // Time Complexity : O(n)
        // Space Complexity : O(n)



        */
        
    }
}


// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
