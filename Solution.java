//Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int m=amount;
        int[][] dp=new int[n+1][m+1];

        //first row
        for(int j=1;j<=m;j++)
        {
            dp[0][j]=999999;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                //case 0 , don't choose
                if(j<coins[i-1])
                {
                    //not choosing the coin i->same prev coin i-1 is used
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    //choosing new coin 1 so amount or j will change now
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[n][m]>=999999)
        {
            return -1;
        }
        return dp[n][m];

    }
}