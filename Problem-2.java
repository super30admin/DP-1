//Time complexity - O(n)
// space - o(n)
//solved on leetcode - yes
// Did you face any problem - no
// Using recursive solution the time complexity will be 2^(n) due to repeated subproblems, but to reduce this, we are using a dp array to store the solution of recursive problem and using them. using memorization we are storing the value of previous problem in an array
class Solution {
    public int rob(int[] nums) {
        int memo[] = new int[nums.length+1];
        Arrays.fill(memo,-1);
        return helper(nums, 0, memo);
    }

    private int helper(int[] nums, int index, int[] memo) {
        // Base case: no more houses left
        if (index >= nums.length) return 0;
        if(memo[index] != -1) return memo[index];

        // Two choices:
        // 1. Rob current house and skip the next one (index + 2)
        // 2. Skip current house and go to the next one (index + 1)
        int rob = nums[index] + helper(nums, index + 2, memo);
        int skip = helper(nums, index + 1, memo);
        memo[index] =  Math.max(rob, skip);
        return memo[index];
    }
}
