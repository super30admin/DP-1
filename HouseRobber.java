// Time Complexity :O(n) n-> nums.length;
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        
        
        
        for(int i = 1;i<nums.length;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    dp[i][j] = nums[i]+dp[i-1][1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][0],dp[i-1][1]);
                }
            }
            
            
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
