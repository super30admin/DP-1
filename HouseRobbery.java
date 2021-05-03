// Time Complexity : O(N*2) = O(N) where N is length of houses. Its a 2D array
// Space Complexity :O(N*2) = O(N) where N is length of houses. Its a 2D array 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class HouseRobbery {
    public int rob(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;
        
        int [][] dp = new int[nums.length][2]; // dp 2D array of nums.length and 2 represent 0 or 1 possibility whether house is chosen or not
        
        dp[0][1]=nums[0]; // first column gets first element
        
        for(int i=1;i<nums.length;i++){
            
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);// house not chosen so get max value from previous row
            dp[i][1]=nums[i]+dp[i-1][0]; // house chosen so add amount in that index to amount in previous row.
        }
        
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]); // last row captures max amount. Pick max between 0 and 1 index
    }
}