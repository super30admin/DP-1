class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initializing n and m 
        int n = coins.length + 1;
        int m = amount + 1;
        // Taking a 2d (n X m) array. In the array, we store minimum number of coins to sum up for the amount.
        int[][] dp = new int[n][m];
        
        // We take some amount greater than 10^4 as in the question mentioned amount will be in range 0 and 10^4. As if we keep Integer.MAX_VALUE, if we add 1, we get some garbage value. 
        // And we fill this because, as we know with 0 coin, we cannot get any sum.
        for(int j=1; j<=amount; j++){
            dp[0][j] = 99999;
        }
        
        for(int i=0; i<=coins.length; i++){
            dp[i][0] = 0;
        }
        
        // Iterate through coins and for each coin loop for amount. If amount < coin denomination, we simply copy the above coins data from
        // matrix else calculate the min of 1 (coin selected which is i) + dp[i][j - coins[i-1]] and dp[i-1][j]
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
                }
            }
        }
        // check if dp[n-1][m-1] (which is the target amount) is equal to 99999 (the initial set value), then there is no solution, return -1 else return dp[i-1][j]
        return dp[n-1][m-1] == 99999 ? -1 : dp[n-1][m-1];
    }
}