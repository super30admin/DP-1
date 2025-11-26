// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We maintain variables to calculate the max amount the robber can make
// 2: We have prev and curr pointers that hold the max amount while iterating through the array
// 3: Once we have completed iteration, we return the curr amount which holds the total max value that the robber could make
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i<n; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }

        return curr;
    }
}