// TC: O(n) Every house is computed only once
// SC: O(n) We are using dp array of size n
// Space can further be optimized to O(1) by storing results in 2 variables 
// Approach : The idea is to build the solution in bottom up manner.

public class House_Robber_Tabulation {

  public int rob(int[] nums) {
    int n = nums.length;

    // create a dp array to store max values at each house
    int[] dp = new int[n + 1];

    // base cases
    dp[0] = 0;
    dp[1] = nums[0];

    // fill the dp array using bottom up approach
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
    }
    return dp[n];
  }

  public static void main(String[] args) {
    House_Robber_Recursive hr = new House_Robber_Recursive();
    int[] nums = new int[] { 1, 2, 3, 1 };

    System.out.println(hr.rob(nums));
  }
}
