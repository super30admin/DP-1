public class DpSol {

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length + 1][amount + 1];

        if (coins == null || amount == 0)
            return 0;

        for (int i = 1; i < memo[0].length; i++) {
            memo[0][i] = amount + 1;
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (j < coins[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.min(memo[i - 1][j], 1 + memo[i][j - coins[i - 1]]);
                }
            }
        }

        if (memo[coins.length][amount] > amount)
            return -1;
        else
            return memo[coins.length][amount];
    }

    public static void main(String[] args) {
        DpSol ds = new DpSol();

        int[] coins = { 1, 2, 5 };

        System.out.println(ds.coinChange(coins, 11));
    }
}
