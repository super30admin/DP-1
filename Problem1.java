// Time Complexity : o(amount.length * coins.length)
// Space Complexity : o(amount.length * coins.length)
public class Problem1 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<amount+1;i++){
            dp[0][i]=amount+1;
        }
        for(int j=1;j<coins.length+1;j++){
            
            for(int k=1;k<amount+1;k++){
                
               if(k<coins[j-1]){
                   dp[j][k]=dp[j-1][k];
               }else{
                   dp[j][k]=Math.min(dp[j-1][k],1+dp[j][k-coins[j-1]]);
               }   
        }
    }
        //incase of infinity;
        if(dp[coins.length][amount]>amount){
            return -1;
        }
        return dp[coins.length][amount];
}
}
