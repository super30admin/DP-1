class Solution {
    public int coinChange(int[] coins, int amount) {
      //TC:O(n^2) SC:O(coins.length*amount)

     int[][] dp=new int[coins.length+1][amount+1]; 
        for(int k=1;k<amount+1;k++)
            dp[0][k]=amount+1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1])
                dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }

            }
        }
        if(dp[coins.length][amount]>amount)return -1;
        return dp[coins.length][amount];
    }
}

//recursion that gave time exceeded
class Solution {
    public int coinChange(int[] coins, int amount) {
     if(coins.length==0 )   return -1;

     return helper(coins,amount,0,0);
    }
    public int helper(int [] coins,int amount, int i, int numcoins){
        if(amount==0)return numcoins;
        if(amount<0||i==coins.length)return -1;
        //select
        int case1=helper(coins,amount-coins[i],i,numcoins+1);
        //no select
        int case2=helper(coins,amount,i+1,numcoins);
        if(case1==-1)return case2;
        if(case2==-1)return case1;
        return Math.min(case1,case2);

    }
}
