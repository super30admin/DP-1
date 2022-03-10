/**
 * time/space complexity is O(n*k) - n is number of coins k - amount
 */
public class MinCoinRecursiveMemo {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount+1];
        int res = coinChange(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int coinChange(int[] coins, int amount, int i) {
        if(amount < 0 || i >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if(amount == 0) {
            return 0;
        }
        if(dp[i][amount] == null) {
            // include coin[i]
            int case1 = coinChange(coins, amount-coins[i], i);
            if(case1 != Integer.MAX_VALUE) {
                case1 = 1 + case1;
            }
        
            //don't include coin[i]
            int case2 = coinChange(coins, amount, i+1);
            dp[i][amount] = Math.min(case1, case2);
        }
        return dp[i][amount];
    }
}
