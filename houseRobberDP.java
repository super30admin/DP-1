// Time Complexity : O(n)
// Space Complexity : O(m+2)--> O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class houseRobberDP {

    public int rob(int[] nums) {
        
        if(nums==null || nums.length==0)
            return 0;
        
        int[][] dp=new int[nums.length][2];
        dp[0][1]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            dp[i][0]= Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1]= nums[i]+dp[i-1][0];
        }
        
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
        
    }
    
}
