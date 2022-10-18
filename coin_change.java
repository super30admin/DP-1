// TC: O(n*amount)
// SC: O(amount)

// Approach: This is just a basic pick and not pick problem. Try to use to functional recurison.



class Solution {
  public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount+1];
    for(int[] arr: dp)
      Arrays.fill(arr, -1);
    int ans = solve(coins, 0, amount, dp);
    return ans == Integer.MAX_VALUE-1 ? -1 : ans;

  }

  private int solve(int[] arr, int idx, int amount, int[][] dp) {

    if(amount == 0)
      return 0;

    if(idx == arr.length || amount < 0)
      return Integer.MAX_VALUE-1;

    if(dp[idx][amount] != -1)
      return dp[idx][amount];


    int pick = 1+solve(arr, idx, amount-arr[idx], dp);

    int notpick = solve(arr, idx+1, amount, dp);

    return dp[idx][amount] = Math.min(pick, notpick);

  }
}