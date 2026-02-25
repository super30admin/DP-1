// Solution - 1

// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation: I am using dynamic programming to store the maximum money that can be robbed up to each house. 
// The array dp[i] represents the maximum money I can rob from the first i houses.
// For each house, I decide whether to skip it (dp[i-1]) or rob it (nums[i-1] + dp[i-2]) and take the maximum of the two. Finally, dp[nums.length] gives the answer.
class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length+1];
        dp[1] = nums[0];

        for(int i=2; i<nums.length+1; i++) {
            int max= Math.max(dp[i-1], nums[i-1]+dp[i-2]);
            dp[i] = max;
        }
        return dp[nums.length];
    }
}

// Solution - 2
// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation : Here I use recursion with memoization. At each index, I have two choices: skip the house or rob it and move two steps ahead.
//  I store results in a dp array to avoid recomputation. This ensures each index is computed only once.
class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return helper(nums, 0, dp);
        
    }

    private int helper (int[] nums, int idx, Integer[] dp) {
        // base 
        if(idx>=nums.length) return 0;
        if(dp[idx]!=null) {
            return dp[idx];
        }


        // no choose
        int case1 = helper(nums, idx+1, dp);
        

        // choose
        int case2= nums[idx] + helper(nums, idx+2, dp);

        int max = Math.max(case1, case2);
        dp[idx] = max;

        return max;

    }
}

// Solution - 3
// TimeComplexity: O(2ⁿ)
// SpaceComplexity: O(n) (recursion stack)
// Explanation: In this version, I recursively try both choices (rob or skip) at every house without storing results. 
// This causes repeated calculations of the same subproblems, leading to exponential growth in calls.
class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0);
        
    }

    private int helper (int[] nums, int idx) {
        // base 
        if(idx>=nums.length) return 0;


        // no choose
        int case1 = helper(nums, idx+1);
        

        // choose
        int case2= nums[idx] + helper(nums, idx+2);

        return Math.max(case1, case2);

    }
}
