//Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n) for the memo array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. We use a memoization array to store the maximum amount of money that can be robbed up to each house
//2. We recursively explore two options for each house: robbing it and skipping it, while using the memo array to avoid redundant calculations
//3. The final result is obtained by calling the recursive function on the first house, which will consider all possible robbery combinations.



class Solution {
    // Memoization array to store the maximum amount of money that can be robbed up to each house
    private int[] memo;
    public int rob(int[] nums) {
        this.memo=new int[nums.length];
        // Initialize the memoization array with -1 to indicate unvisited houses
        Arrays.fill(memo,-1);
        return findhouse(nums,0);
    }
    public int findhouse(int[] nums,int idx){
        // Base case: if we have considered all houses, return 0
        if(idx>=nums.length) return 0;
        // If the current house has already been visited, return the stored result
        if (memo[idx]!=-1) return memo[idx];
        // Explore the two options: robbing the current house or skipping it
        int case1=findhouse(nums,idx+1);
        // If we rob the current house, we cannot rob the next house, so we skip it
        int case2=nums[idx]+findhouse(nums,idx+2);
        // Store the maximum of the two options in the memoization array
        memo[idx]=Math.max(case1,case2);
        // Return the maximum amount of money that can be robbed up to the current house
        return memo[idx];
    }
}