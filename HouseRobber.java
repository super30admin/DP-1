//Time Complexity: O(N)
// Space Complexity: O(N)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
//Memory Usage: 38.3 MB, less than 5.04% of Java online submissions for House Robber.


class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];   
        
        if(nums.length == 2)
        {
            if(nums[0] > nums[1])return nums[0];
            else return nums[1];
        }  
        
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i+1] = Math.max(dp[i],nums[i]+dp[i-1]);
        }
        return dp[nums.length ];
    }
}
