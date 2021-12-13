// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class houseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0; 
        }
        
//         int[][] dp = new int[nums.length][2];
        
//         dp[0][1]= nums[0];
        
        int skip =0 , take =  nums[0];
        
        for(int i = 1 ; i < nums.length ; i++ ){
            int tempSkip = skip;
            skip = Math.max(skip,take);
            take = tempSkip +nums[i];
        }
        return Math.max(skip,take);
    }
}
