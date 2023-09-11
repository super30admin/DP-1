// Time Complexity : O(n*k) => n is length of coins and k is amount
// Space Complexity : o(n*k)
// Did this code successfully run on Leetcode : yes



class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length + 1][amount + 1];

        for(int j=0; j<amount+1; j++){
            dp[0][j] = amount +1;
        }
        for(int i=1; i<coins.length + 1; i++){
            for(int j=1; j<amount+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
                }
            }
        }
        if(dp[coins.length][amount] == amount+1){
            return -1;
        }
        return dp[coins.length][amount];
    }

        public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5}; // Replace with your coin denominations
        int amount = 11; // Replace with your target amount

        int result = solution.coinChange(coins, amount);
        System.out.println("Minimum number of coins required to make " + amount + " is: " + result);
    }
}