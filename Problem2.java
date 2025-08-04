// Time Complexity : O(n) -Iterate through the nums array
// Space Complexity : O(1) - Use constant Prev, Current and temp
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took reference of class 


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // Current and Next to save current and next element
        int prev, curr;

        // base case if length is 1 return 1st elementy
        if( n == 1)
        return nums[0];

        //save 1st and 2nd element
        prev = nums[0];
        curr = Math.max(nums[0], nums[1]);

        // start with index 2 and compare Max Element with other set
        for ( int i=2; i<n ; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}