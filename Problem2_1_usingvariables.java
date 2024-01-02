// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int n = nums.length;

        int prev = nums[0];
        int curr = Math.max(nums[0], 0 + nums[1]);

        for(int i=2; i<n; i++)
        {   
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }

        return curr;
    }
}