// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    
    public int rob(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }
        

        /*int dp[][]=new int[nums.length][2];
        //dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);*/
        
        int skip=0;
        int take=nums[0];
        
        for(int i=1;i<nums.length;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+nums[i];
            
        }
        return Math.max(skip,take);
        
    }


}
