public class Solution2{
    // Time Complexity :O(n) n=length of houses
// Space Complexity :O(n) n=length of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachpublic class Solution2 {
    public int rob(int[] nums) {
        
        if(nums==null||nums.length==0)
            return 0;
        int [][]dp= new int[nums.length][2];
        // rob only first house
        dp[0][1]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            // do not rob the ith house
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);

            // rob the ith house 
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);    
          
}
}
