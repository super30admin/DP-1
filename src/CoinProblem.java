package src;

public class CoinProblem {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 14;
        CoinSolution cs = new CoinSolution();
        System.out.println(cs.coinChange(coins, amount));
    }
}

class CoinSolution
{
    int[][] dp;
    public int coinChange(int[] coins, int amount)
    {
        dp = new int[coins.length][amount+1];
        int ans = coinChange(coins, 0, amount);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    private int coinChange(int[] coins, int i, int amount)
    {
        if(amount == 0)
            return 0;
        else if(amount < 0 || i == coins.length)
            return Integer.MAX_VALUE;

        if(dp[i][amount] > 0)
            return dp[i][amount];

        int notChoose = coinChange(coins, i+1, amount);

        int choose = coinChange(coins, i, amount-coins[i]);

        if(choose != Integer.MAX_VALUE)
            choose++;

        return dp[i][amount]=Math.min(notChoose,choose);
    }
}