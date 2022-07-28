// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I had to do some modifications when errors occurred

class DPCoinChange2 {
    public static void main(String args[]) {
        int[] coins = {1,2,5};
        int amount = 11;
        DPCoinChange2 obj = new DPCoinChange2();
        System.out.println(obj.coinChange(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[][] dp = new int[coins.length + 1][amount + 1] ;
        dp[0][0] = 0;
        // writing infinite value to the first row
        for(int i =0; i < dp[0].length; i ++) {
            dp[0][i] = amount + 3;
        }
        // filling up the rest of the rows in dp matrix
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // amount is less than coin value then take the value which is calculated for the coin above that
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } 
                else {
                    // Take the min out of the one above cell or the cell value subtracting coins[i] 
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[coins.length][amount];
        if ( result > amount) return -1;
        return result;
    }
}