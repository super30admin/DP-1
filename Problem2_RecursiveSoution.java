// Problem 2: House Robber
class Problem2_RecursiveSolution {
    public int rob(int[] nums) {
        if(nums== null ||nums.length ==0) return 0;
        
        return helper(nums, 0,0);
        
    }
    
    public int helper (int [] nums, int index, int amount){
        
        if(index>=nums.length) return amount;
        
        int case1 = helper(nums, index+1, amount);
        int case2 = helper(nums, index+2, amount+nums[index]);
        
        return Math.max(case1, case2);
    }
}
/*
Time Complexity : 2^n
Space Complexity : O(1)
Did this code successfully run on Leetcode : There was time exceeded exception
Any problem you faced while coding this : No
Approach:

- We have 2 choices, rob or do not rob a home
- Every time we perform this operation on an element for the given array, 
we identify a repeated sub-problem. 
- Therefore, we implement the solution recursively choosing or not choosing an element,
hence generating amounts on each condition.
- The maximum of 2 cases is considered for the computation of future recursion.

*/
