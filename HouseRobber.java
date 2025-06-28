/*
 * House Robber
 * Approach 1: Exhaustive Search
 * 1. Use recursion to explore two choices at each house: rob it or skip it.
 * 2. If we rob the current house, we cannot rob the next one, so we move to the house after that.
 * 3. If we skip the current house, we move to the next house.
 * 4. Base case: If we reach beyond the last house, return the accumulated sum.
 * *  Time Complexity: O(2^n) where n is the number of houses, as we explore all combinations.
 * *  Space Complexity: O(n) for the recursion stack.
 * 
 * 
 * Approach 2: Rob with Top-Down Dynamic Programming (Memoization) 1D Array
 * 1. Use a memoization array dp to store the maximum amount that can be robbed starting from each house.
 * 2. At each house (index), make a decision:
 *      - Rob it: Add the current house value to the result of robbing from index + 2 onward.
 *      - Skip it: Move to index + 1 without robbing the current house.
 * 3. Store the result of each decision in dp[index] to avoid recomputation.
 * 4. Recursively apply this logic starting from index 0 and return the result.
 *
 * Time Complexity: O(n) – each house index is computed only once.
 * Space Complexity: O(n) – for the memoization array and recursion stack.
 * 
 * Approach 3: Rob with 2D Dynamic Programming
 * 1. Use a 2D array dp where dp[i][0] represents the maximum amount robbed up to house i without robbing it,
 *    and dp[i][1] represents the maximum amount robbed up to house i with robbing it.
 * 2. Initialize dp[0][1] with the value of the first house.
 * 3. Iterate through the houses, updating dp[i][0] and dp[i][1] based on whether we rob the current house or not.
 * 4. The final result is the maximum of dp[n][0] and dp[n][1], where n is the number of houses.
 * * Time Complexity: O(n) where n is the number of houses.
 * * Space Complexity: O(n) for the 2D array.
 * 
 * Approach 4: Space Optimized Dynamic Programming
 * 1. Instead of using a 2D array, we can use two variables to keep track of the maximum amounts robbed up to the previous house.
 * 2. Use two variables skip and take to represent the maximum amounts robbed up to the last house and the house before that.
 * 3. Iterate through the houses, updating these variables based on whether we rob the current house or not.
 * 4. The final result is the maximum of skip and take after processing all houses.
 * * Time Complexity: O(n) where n is the number of houses.
 * * Space Complexity: O(1) – only a few variables are used for tracking the state.
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int robSum) {
        if (index >= nums.length) {
            return robSum;
        }
        int rob = helper(nums, index + 2, robSum + nums[index]);
        int skip = helper(nums, index + 1, robSum);

        return Math.max(rob, skip);
    }


    // Approach 2: Dynamic Programming using 1D array
    public int robWithDP(int[] nums) {
        // Base case: if input is null or empty, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int n = nums.length;
    
        // Create a memoization array (dp) of size n+1 and initialize with -1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // -1 means result for that index has not been computed yet
    
        // Start solving from index 0
        return robWithDPHelper(nums, 0, dp);
    }
    
    private int robWithDPHelper(int[] nums, int index, int[] dp) {
        // Base case: if index is out of bounds, return 0 (no money to rob)
        if(index >= nums.length) {
            return 0;
        }
    
        // If we’ve already computed this state, return the stored result
        if (dp[index] != -1) {
            return dp[index];
        }
    
        // Choose to rob the current house and skip the next one
        int rob = nums[index] + robWithDPHelper(nums, index + 2, dp);
    
        // Or skip the current house and move to the next
        int skip = robWithDPHelper(nums, index + 1, dp);
    
        // Store and return the maximum of both choices
        dp[index] = Math.max(rob, skip);
        return dp[index];
    }

    // Approach 3: Using 2D Dynamic Programming
    public int robWith2DArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][1] = nums[0]; // If we rob the first house

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); // Skip current house
            dp[i][1] = dp[i - 1][0] + nums[i - 1]; // Rob current house
        }

        return Math.max(dp[n][0], dp[n][1]);
    }

    // Approach 4: Space Optimized Dynamic Programming
    public int robWithSpaceOptimization(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        int skip = 0; // Maximum amount robbed up to the last house
        int take = nums[0]; // Maximum amount robbed including the first house

        for (int i = 1; i < n; i++) {
            int temp = Math.max(skip, take); // Skip current house
            take = skip + nums[i]; // Rob current house
            skip = temp; // Update skip for next iteration
        }

        return Math.max(skip, take);
    }

}
