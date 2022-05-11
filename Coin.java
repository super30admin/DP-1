// Time Complexity :O(n∗s) where s is the amount to change
// Space Complexity :O(s) 
import java.util.Arrays;

class Coin {
    public int coinChange(int[] coins, int amount) {
         int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    if(dp[amount] > amount)
    {
        return -1;
        
    }
        else
        {
            return dp[amount];
        }
}
}