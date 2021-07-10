// Time Complexity :O(m*n) where m is the number of coin and n is the amount
// Space Complexity :O(m*n) where m is the number of coin and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // base condition
        if(coins.length==0)
            return -1;
        int [][] dp = new int[coins.length+1][amount+1];
        for(int i = 1;i <=amount;i++)
        {
            dp[0][i] = Integer.MAX_VALUE-7;
        }
        for(int i = 1;i <=coins.length;i++)
        {
            for(int j = 1;j<=amount;j++)
            {
                if(j-coins[i-1]<0)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
     
        int result = dp[coins.length][amount];
        return  result < (Integer.MAX_VALUE-7) ? result:-1;
    }
    public static void main(String args[])
    {
        System.out.println(coinChange(new int[]{1,3,5},11));
    }
    
   
}