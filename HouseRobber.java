/**
 * Leet Code: https://leetcode.com/problems/house-robber/description/
 *
 * Approach:
 * This is a recursive solution with memoization (top-down dynamic programming).
 * At each house, you can either rob it (and skip the next house) or skip it (move to the next house).
 * The function recursively tries both options and stores the result in a memo array to avoid recomputation.
 *
 * Time Complexity: O(N), where N = number of houses. Each subproblem is solved once.
 * Space Complexity: O(N) for the memoization array and recursion stack.
 */
import java.util.Arrays;

public class HouseRobber {
    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return recursive(nums, 0);
    }

    private int recursive(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) return memo[index];
        // Try skipping or robbing the current house
        int notPick = recursive(nums, index + 1);
        int pick = recursive(nums, index + 2) + nums[index];

        int max = Math.max(notPick, pick);
        memo[index] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2, 1, 1, 2}));
    }
}
