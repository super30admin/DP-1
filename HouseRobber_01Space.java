// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int Chosen = 0;
        int notChosen = 0;
        for(int i=0; i< nums.length;i++){
            int temp = Chosen;
            Chosen = notChosen + nums[i];
            notChosen = Math.max(temp, notChosen);
        }
        
        return Math.max(Chosen, notChosen);
    }
}