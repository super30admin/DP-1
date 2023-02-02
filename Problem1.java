//time: O(n*m)
//space: O(n*m)

public class Problem1 {

    static int coinChange(int[] coins, int amount) {

        if (coins.length==0 || coins==null) return -1;
        else return helper(coins, amount, 0, 0);
    }

    static int helper(int[] coins, int amount, int index, int min) {

        int[][] dp = new int[coins.length+1][amount+1];

        dp[0][0] = 0;
        for (int i = 1; i<dp[0].length; i++){
            dp[0][i] = amount+1;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length;j++ ){

                if (coins[i-1]>j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if (dp[dp.length-1][dp[0].length-1]> amount) return -1;

        return dp[dp.length-1][dp[0].length-1];
    }

        public static void main(String[] args) {
            System.out.println("min coins "+coinChange(new int[]{1,2,5}, 11));
        }
}
