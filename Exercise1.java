class Solution {
    public int coinChange(int[] coins, int amount) {
        
    int []  dp = new int[amount+1];
   
        dp[0]=0;
    
    for(int j=1;j<=amount;j++)
    {
        dp[j]=9999;
    }
    for(int i=1;i<=coins.length;i++)
    {
        for(int j=1;j<=amount;j++)
        {
            if(j<coins[i-1]){dp[j]=dp[j];}
            else{dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
        }
    }
}
        int result=dp[amount];
        if(result>=9999){return -1;}
        return result;
}}