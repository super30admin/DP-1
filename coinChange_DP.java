//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //base
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1]; //1 extra for dummy row -- 0,1,2,5 & 0-11
        dp[0][0] = 0;
        //fill dummy row //top row
        for(int j = 1; j< dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                //till amount is equal to denomination, value is same as above one
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = dp[m][n];
        if(result > amount) return -1;
        return result;
    }
}
