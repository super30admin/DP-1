public class CoinChange {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 5};

        int amount = 11;

        CoinChange obj = new CoinChange();

        int obj2 = obj.dynamicPro(arr, amount);

        System.out.println("min amount" + obj2);

    }

    public int dynamicPro(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return 0;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        // first row

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[m][n] > amount)
            return 0;
        return dp[m][n];

    }

}