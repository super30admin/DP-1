/**
 * Exhaustive approach
 * time: O(2^(m*n))
 * space: O(2^(m*n))
 */
class Approach1 {
    public int coinChange(int[] coins, int amount) {
        // null case
        if(coins == null || coins.length == 0) return 0;
        return helper(coins, amount, 0, 0);
        
    }
    
    public int helper(int[] coins, int amount, int index, int minCoinsUsed){
        // base
        if(amount == 0) return minCoinsUsed;
        if(index == coins.length || amount < 0) return -1;
        
        // logic
        // dont choose
        int case1 = helper(coins, amount, index + 1, minCoinsUsed);
        // choose
        int case2 = helper(coins, amount - coins[index], index, minCoinsUsed+1);
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
        
    }
}

/**
 * DP approach
 * n = coins
 * m = amount
 * time: O(m*n)
 * space: O(m*n) 
 */
class Approach2 {
    public int coinChange(int[] coins, int amount) {
        // null case
        if(coins == null || coins.length == 0) return 0;
        // coins.length+1 for dummy row
        int[][] dp = new int[coins.length+1][amount+1];
        
        // infinity filled in dummy 0 row
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = 99999; 
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                // amount > current coin denomination
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length-1][dp[0].length-1];
        if(result >= 99999) return -1;
        return result;
    }

}
