// Time Complexity : O(N) N number of elements in nums array
// Space Complexity : O(1) no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve problem before class as usual :(


// Your code here along with comments explaining your approach: Same as class

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int notChosen = 0;
        int Chosen = nums[0];
        
        for(int i=1; i < nums.length; i++){
            int temp = notChosen;
            notChosen = Math.max(notChosen, Chosen);
            Chosen = temp + nums[i];
        }
        
        return Math.max(notChosen, Chosen);
    }
}