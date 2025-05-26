// TC: O(n) Every house is computed only once
// SC: O(n) For recursion stack space and memo array
// Approach : We can optimize the solution using memo array such that  
// memo[i] represents maximum value that can be collected from first i houses

import java.util.Arrays;

public class House_Robber_Memoization {

  private int[] memo;

  public int rob(int[] nums) {
    this.memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return helper(nums, 0);
  }

  private int helper(int[] nums, int idx) {
    // base case

    if (idx >= nums.length)
      return 0;

    if (memo[idx] != -1)
      return memo[idx];

    // logic
    // no choose
    int case1 = helper(nums, idx + 1);
    // choose
    int case2 = nums[idx] + helper(nums, idx + 2);
    memo[idx] = Math.max(case1, case2);
    return memo[idx];
  }

  public static void main(String[] args) {
    House_Robber_Recursive hr = new House_Robber_Recursive();
    int[] nums = new int[] { 1, 2, 3, 1 };

    System.out.println(hr.rob(nums));
  }
}
