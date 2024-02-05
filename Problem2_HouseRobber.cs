// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Missed edge cases initially.

// Approach: To Find and solve the repeating subproblem and storing its values in temporary variables
// for next iterations while solving the main problem.
public class Solution {
    public int Rob(int[] nums) {
        if(nums.Length == 0) return 0;
        if(nums.Length == 1) return nums[0];
        int n = nums.Length;
        int prev = nums[0];
        int curr = Math.Max(prev, nums[1]);
        for(int i = 2;i < n; i++) {
           int temp = curr;
           curr = Math.Max(temp, nums[i] + prev);
           prev = temp;
        }
        return curr;
    } 
}
