// Time Complexity : O(n), n = number of houses
// Space Complexity : O(n), n = number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Identify the repeating sub problems.
 * 2. Implement a recursive solution to pick a house and not pick a adjacent house.
 * 3. Store the result of the recursive solution in a memo array to avoid recomputation of the same sub problem.
 */

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] result = new int[]{0};
        int[] memo = new int[len];
        Arrays.fill(memo, -1);

        result[0] = dfs(nums, len-1, result, memo);

        return result[0];
    }

    private int dfs(int[] nums, int index, int[] result, int[] memo){
        if(index == 0){
            memo[index] = nums[index];
            return memo[index];
        }

        if(index < 0){
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        int pick = nums[index] + dfs(nums, index-2, result, memo);
        int notPick = 0 + dfs(nums, index-1, result, memo);

        return memo[index] = Math.max(pick, notPick);
    }
}