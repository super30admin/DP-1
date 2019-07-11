// Time Complexity :O(M*N) --> M is number of coins and N is amount
// Space Complexity :O(M*N)  ---> because of 2d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
   public class CoinChange{
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<dp[0].length;i++){
            dp[0][i] = 9999;
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                //copying from above
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.min(dp[i-1][j] , 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[coins.length][amount];
        if(result>=9999) return -1;
        return result;
        }
    
    public static void main(String[] args) {
        int[] coins = new int[]{3,4,5};
        int  amount = 7;
        System.out.println(coinChange(coins,amount));
    }
}
