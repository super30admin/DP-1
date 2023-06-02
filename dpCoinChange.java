/*
 * O(m*n)
 * 
 */
public class dpCoinChange {
    public int coinChange(int[] coins, int amount)
    {
        int [][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int j =1; j<= amount;j++)
        {
            dp[0][j] = 99999;
        }
        //i is number of coins (rows)
        //j is the range of amount (columns)
        for(int i=1;i <= coins.length;i++)
        {
            for(int j=1; j<= amount; j++)
            {
                //until the denomination of the coin is equal to amount
                if(coins[i-1] > j)
                {
                    //keep copying the value of the same column in above row
                    dp[i][j] = dp[i-1][j];



                }
                else {
                    //0 and 1 case
                    // left coin value number times go and add 1; above value same column above row; min of two values
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);


                }
            }
        }
        if(dp[coins.length][amount] >= 99999)return -1;
        return dp[coins.length][amount];

    }
}
