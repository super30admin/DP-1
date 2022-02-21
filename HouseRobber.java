// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        int chosen=0;
        int notChosen=0;
        int temp;
        for(int i=0;i<nums.length;i++){
            temp = notChosen;
            notChosen = Math.max(chosen,notChosen);
            chosen = temp + nums[i];
        }
        return Math.max(chosen,notChosen);
    }
}