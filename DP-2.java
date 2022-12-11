// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        
        int prev = nums[0];
        int curr = Math.max(prev, nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);  // choose or dont choose
            prev = temp;
        }
        
        return curr;
    }
}
