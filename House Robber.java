// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int picked = nums[0];
        int notPicked = 0;
        for(int i = 1 ; i < nums.length ; i++){
            int temp = picked;
            picked = notPicked + nums[i];
            notPicked = Math.max(notPicked,temp);
        }
        return Math.max(picked,notPicked);
    }
}
