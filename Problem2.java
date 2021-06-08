// 198. House Robber

class Solution {
    public int rob(int[] nums) {
        // edge case
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int skip = 0; int take = nums[0];
        
        for(int i = 1; i < n; i++)
        {
            int temp = skip; 
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        
        return Math.max(skip, take);
    }
}


/*

Time Complexity: 
O(N) since we have a loop from N−2⋯0 and we use the precalculated values of our dynamic programming table to calculate the current value in the table which is a constant time operation.

Space Complexity: 
O(1) since we are not using a table to store our values. Simply using two variables will suffice for our calculations.

*/