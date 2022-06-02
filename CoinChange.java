// Time Complexity : O(n*m) = n is number of coin types and m is total amount
// Space Complexity : O(n*m) = n is number of coin types and m is total amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to wait until class to know how to solve this problem
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int [][] dp = new int[m+1][amount +1];
        for(int j=1; j<dp[0].length;j++){
            dp[0][j] = 99999;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][amount]>=99999) return -1;
        return dp[m][amount];
    }

    public static void main(String [] args){
        CoinChange cc = new CoinChange();
        int [] coins = new int[]{1,2,5};
        System.out.println(cc.coinChange(coins, 11));
    }
}