public class CoinChange1 {
    /*
       1. Recursive solution
          TC: exponential

    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==-1)
            return 0;
        return helper(coins,0,amount,0);
    }

    private int helper(int coins[],int index,int amount,int steps){
        if(amount==0){
            return steps;
        }
        if(amount<0 || index==coins.length){
            return -1;
        }

        int case1=helper(coins,index,amount-coins[index],steps+1);
        int case2=helper(coins,index+1,amount,steps);
        if(case1==-1){
            return case2;
        }
        if(case2==-1){
            return case1;
        }
        return Math.min(case1,case2);
    }
    */

    /*
       2. DP solution with 2D array
       TC: O(m*n) where m is the length of coins array and n is the amount
       SC: O(m*n)
    */
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==-1)
            return 0;

        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=amount+1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];
    }
}
