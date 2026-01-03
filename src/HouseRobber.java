/*
HOUSE ROBBER (LeetCode 198)

Problem:
Given an array where each element represents money in a house,
find the maximum amount you can rob without robbing two adjacent houses.

This class demonstrates MULTIPLE approaches, starting from brute force
and gradually optimizing to Dynamic Programming.

Approaches implemented:
1. Pure Recursive (Exhaustive Decision Tree)
2. Top-Down DP (Recursion + Memoization)
3. Bottom-Up DP (1D Array)
4. Bottom-Up DP (O(1) Space Optimized)
*/

public class HouseRobber {

    // Used for memoization in Top-Down DP
    private int[] memo;

    /* 1. PURE RECURSIVE SOLUTION (BRUTE FORCE)
       At each house:
       - Either rob it and skip next
       - Or skip it and move to next

       Time Complexity: O(2^n)
       Space Complexity: O(n) recursion stack
    */
    public int robRecursive(int[] nums) {
        return robHelper(nums, 0);
    }

    private int robHelper(int[] nums, int index) {
        // Base case: out of bounds
        if (index >= nums.length) return 0;

        // Choice 1: Do not rob current house
        int skip = robHelper(nums, index + 1);

        // Choice 2: Rob current house
        int rob = nums[index] + robHelper(nums, index + 2);

        return Math.max(skip, rob);
    }

    /*2. TOP-DOWN DP (MEMOIZATION)
       Same recursion, but store results to avoid recomputation.

       Time Complexity: O(n)
       Space Complexity: O(n)
    */
    public int robTopDown(int[] nums) {
        memo = new int[nums.length];
        return robHelperMemo(nums, 0);
    }

    private int robHelperMemo(int[] nums, int index) {
        if (index >= nums.length) return 0;

        if (memo[index] != 0) return memo[index];

        int skip = robHelperMemo(nums, index + 1);
        int rob = nums[index] + robHelperMemo(nums, index + 2);

        memo[index] = Math.max(skip, rob);
        return memo[index];
    }

    /* 3. BOTTOM-UP DP (1D ARRAY)
       dp[i] = maximum money that can be robbed up to house i
       Transition:
       dp[i] = max(dp[i-1], nums[i] + dp[i-2])

       Time Complexity: O(n)
       Space Complexity: O(n)
    */
    public int robBottomUp(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    /* 4. BOTTOM-UP DP (SPACE OPTIMIZED)
       Uses only two variables instead of dp array.
       Time Complexity: O(n)
       Space Complexity: O(1)
    */
    public int robOptimized(int[] nums) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int money : nums) {
            int curr = Math.max(prev1, prev2 + money);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
