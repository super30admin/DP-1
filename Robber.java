// Time Complexity : DP solution take O(n).
// Space Complexity : DP solution take O(1) space complexity.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Taking decision at every point whether to rob the house or not. If I Rob - I will take max from previously robbed amount + current amount.
// If I don't rob I will take the MAX amount from PREVIOUSLY robbed houses and carry forward for next house.
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        
        int rob = nums[0];
        int notRob = 0;
        
        for(int i = 1; i<nums.length;i++){
            //Don't Rob
            int temp = notRob;
            notRob = Math.max(rob, notRob);
            
            // Rob
            rob = temp+nums[i];
        }
        
        return Math.max(notRob, rob);
    }
}
