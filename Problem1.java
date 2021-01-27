//I was not quite able to get to the solution , my approach was to determine the coins required by any particular coin value to reach closest to amount
//and the remainder is what we need to form and check with other coins. But could not quite code it out.
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        
        int[] dp = new int[coins.length];
        return dynamic(coins,amount,dp);
        
        
    }
    public int dynamic(int[] coins,int amount, int[] dp)
    {
        int coins_num=0,rem=0;
        for(int i=0;i<coins.length;i++)
        {
            coins_num=amount/coins[i];
            if(coins_num<1){
                return 0;
            }
            rem=amount%coins[i];
            if(rem==0)
                dp[i]=coins_num;
            else 
                dp[i]=coins_num+dynamic(coins,rem,dp);
            
           
            
        }
        return dp[coins.length-1];
        
    }
}

//Time complexity-O(m*n), space complexity - O(m*n), This approach compares the result of chossing the current coins vs not choosing current coin and adding the min to dp matrix.
public int coinChange(int[] coins, int amount) {
    int n=coins.length;
    int m= amount;
    int[][]dp = new int[n+1][m+1];
    for(int i=0;i<n+1;i++)
        dp[i][0]=0;
    for(int j=1;j<m+1;j++)
        dp[0][j]=amount+1;
    
    for(int i=1;i<n+1;i++)
    {
        for(int j=1;j<m+1;j++)
        {
            if(coins[i-1]>j)
                dp[i][j]= dp[i-1][j];
            else
                dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
        }
    }
    return dp[n][m]==amount+1?-1: dp[n][m];
}
}
