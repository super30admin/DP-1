// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
/* 
At every house, you have 2 choices, either rob it or skip it.
	1.	Skip the current house → keep previous maximum.
	2.	Rob the current house → add its money to the best value from two houses back.
*/ 

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //base 
        if (n==0) return 0;
        if (n==1) return nums[0];

        int[] dp = new int[n];
        int prev=nums[0];
        int curr= Math.max(nums[0], nums[1]);
        for (int i = 2; i<n; i++){
            int temp = curr;
            curr= Math.max(curr, nums[i] + prev);
            prev=temp;
        }
        return curr;
    }
}