public class CoinChange {
        public int coinChange(int[] coins, int amount) {
            if(coins == null) return 0;
            int m=coins.length;int n=amount;
            int dp[][] = new int[m+1][n+1];
            dp[0][0] = 0;

            for(int j=1;j<=n;j++)
            {
                dp[0][j] = 99999;
            }

            for(int i=1;i<=m;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(j<coins[i-1])
                    {
                        dp[i][j] = dp[i-1][j];

                    }
                    else
                    {

                        dp[i][j] =Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                    }

                }
            }
            if(dp[m][n]>=99999){return -1;}


            return dp[m][n];

        }

}
//time complexity O(mn)
