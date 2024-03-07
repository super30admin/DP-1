import java.util.Arrays;
// tc = o(m*n) where m is amount and n is coins
//sc = o(m) where m is amount 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}