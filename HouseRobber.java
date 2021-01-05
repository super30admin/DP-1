// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with the logic for skipping or choosing a variable in DP

// Notes : Optimal solution will include creating two variable which will hold the money robbed if we rob/skip the house, and update these varibles based on its previous values.

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        if(nums.length == 1) return nums[0];
        
        int skip = 0, take = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int prevSkip = skip;
            skip = Math.max(skip , take);
            take = prevSkip + nums[i];
        }
        
        return Math.max(take, skip);
    }
}
