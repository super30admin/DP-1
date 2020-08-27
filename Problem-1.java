//Time complexity-O(n*m)
//space complexity-O(n)
//Very difficult for me to think this approach on own, as of now used classroom approach.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp=new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++)
        {
            dp[i][0]=0;
        }
        for(int j=1;j<=amount;j++)
        {
            dp[0][j]=9999;
        }
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[coins.length][amount] >=9999 ? -1 : dp[coins.length][amount];
    }
}
