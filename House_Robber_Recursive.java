// TC: O(2^n)
// SC: O(n)
// Approach : Choose and don't choose. Calling recursive function.
// 1. Rob the current house and skip house just before it
// 2. Skip the current house and move to next house

public class House_Robber_Recursive {

  public int rob(int[] nums) {
    return helper(nums, 0);
  }

  private int helper(int[] nums, int idx) {
    // base case

    if (idx >= nums.length)
      return 0;

    // logic
    // no choose
    int case1 = helper(nums, idx + 1);
    // choose
    int case2 = nums[idx] + helper(nums, idx + 2);

    return Math.max(case1, case2);

  }

  public static void main(String[] args) {
    House_Robber_Recursive hr = new House_Robber_Recursive();
    int[] nums = new int[] { 1, 2, 3, 1 };

    System.out.println(hr.rob(nums));
  }
}
