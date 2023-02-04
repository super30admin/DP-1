// s[i][j] = min(s[i-1][j],s[i][j-coins[i-1]]+1) if j>= coins[i-1] top cell,denomination times back.
// s[i][j] = s[i-1][j] top cell

public class CoinChange1 {
    public static int coinChange(int[] coins, int amount) {
        if(coins.length==0||coins==null) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int res = dp[m][n];
        if(res>amount) return -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(CoinChange1.coinChange(new int[]{1,2,5},11));
    }
}
