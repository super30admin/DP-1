// TC: O(n)
// SC: O(n)

//Approach: Again a variation of pick and not pick.


class Solution {

  private int solve(int[] nums, int ans, int idx, int[] dp) {


    if(idx >= nums.length )
      return 0;

    if(dp[idx] != -1)
      return dp[idx];

    int pick = nums[idx] + solve(nums, ans, idx+2, dp);
    int notpick = solve(nums, ans, idx+1, dp);

    return dp[idx] = Integer.max(pick, notpick);
  }


  public int rob(int[] nums) {
    int ans = 0;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return solve(nums, ans, 0, dp);
  }


}