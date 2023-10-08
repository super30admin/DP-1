// Time Complexity :O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int curr = nums[1];
        int prev = nums[0];

        for(int i= 2; i <n; i++){   
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev); 
            prev = temp;

        }   
        return curr;

    }
}
