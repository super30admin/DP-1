//Time Complexity O(N*M) where N=length of coins array and M= amount
class Solution {
    public int coinChange(int[] coins, int amount) {


        if(coins==null || coins.length==0)return 0;
        int[][] dp = new int[coins.length+1][amount+1];


        //fill the first row with infinity
        for(int i=0;i<=amount;i++){
            dp[0][i]= 999999;
        }


        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];    
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);    
                }
            }
        }
        if(dp[coins.length][amount]>=99999) return -1;
        return dp[coins.length][amount];
        
    }


}
