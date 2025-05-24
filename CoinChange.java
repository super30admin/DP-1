// Time Complexity O(m*n)
// Space Complexity O(m*n)
// Runs on LeetCode: Yes
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int cols = amount;
        int rows = coins.length;
        int[][] dp = new int[rows +1][cols +1];
        int MAX = Integer.MAX_VALUE - 10;

        dp[0][0] = 0;

        for(int i=1; i<= cols; i++){
            dp[0][i] = MAX;
        }

        for(int i = 1; i<= rows; i++){
            for(int j =1; j<= cols; j++){
                if(j < coins[i -1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min( dp[i-1][j], dp[i][j - coins[i -1]] +1 );
                }
            }
        }
        if(dp[rows][cols] == Integer.MAX_VALUE - 10) return -1;
        return dp[rows][cols];
    }
}