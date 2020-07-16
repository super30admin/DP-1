//Time complexity: O(MN) I think. Could you please correct me if I am wrong?
//Space complexity: O(MN) because we are creating a dp array
//LeetCode = yes
//Any issue = No

class Solution {
    public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<coins.length+1; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<amount+1; j++){
            dp[0][j] = 99999;
        }
        
        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1; j++){
                int denom = coins[i-1];
                if(j<denom){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-denom]);
                }
            }
        }
        
        
        int result = dp[coins.length][amount];
        if(result >= 99999) return -1;
        else return result;
    }
}
