// Time Complexity : O(2^n) // 2 decisions for every coin (to choose vs not to choose), n = number of coins/denominations
// Space Complexity : O(n) // additional space for dp matrix O(n) and variables O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class CoinChangeSolution {
    private int[][] dp;
    
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        int ans = coinChange(coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans; // if amount of money cannot be made up of any combo, return -1, otherwise return actual value
    }
    
    public int coinChange(int[] coins, int index, int amount){
        if (amount == 0){ // finished!
            return 0;
        }
        
        if (index >= coins.length || amount < 0){
            return Integer.MAX_VALUE; // amount of money cannot be made up in any combination
        }
        
        if (dp[index][amount] > 0){ // seen this value before
            return dp[index][amount];
        }
        
        if (dp[index][amount] == 0){ // seeing this for first time
        
            int choose = coinChange(coins, index, amount-coins[index]);
            if (choose != Integer.MAX_VALUE){
                choose += 1; // increment number of coins by 1 since we chose successfully
            }
            int nChoose = coinChange(coins, index + 1, amount);
            
            dp[index][amount] = Math.min(choose, nChoose); // store in dp matrix
        }
        
        return dp[index][amount]; // choose optimal subsolution
    }
    
}