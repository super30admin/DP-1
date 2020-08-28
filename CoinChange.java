public class CoinChange {
    //Time complexity: O(n2) n: coins length m: amount
//Space complexity: O(n*m)
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1] [amount +1];
        int max = 99999;
        //default setting to max and 0 just because the amount can be obatined with the coins avaiable
        for(int i=1; i<=amount;i++)
            dp[0][i] = max;        
        for(int i=0; i<=coins.length;i++)
            dp[i][0] = 0;        
        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                //Only if previous coins value is not calculated
                 if(j < coins[i-1]){
                  dp[i][j] = dp[i-1][j];
               } else{
                   dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
               }                
            }
        }
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}