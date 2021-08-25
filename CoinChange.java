// Time Complexity : O(m * n) where m is amount and n is number of denominations of coins provided
 // Space Complexity : O(m) where is m is amount+1
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : Could not develop/understand the logic at the line where Math.min is used

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins); //sorting just to make rest of process less taxing
        int[] dp = new int[amount+1]; //declaring an array to store minimum number of coins for all amounts
        
        Arrays.fill(dp, amount+1); //filling the array with maximum value so when we return minimum number of coins, instead of zero we will have maximum value stored i.e. amount+1
        
        dp[0] = 0; //because if 0 dollars we are searching, we need 0 coins
        
        for(int i = 0; i<=amount; i++) { //for each iteration till the amount
            for(int j = 0; j < coins.length; j++) { //actual iteration for each provided coin
                if(coins[j] <= i) //checking if the coin is of larger value than the amount
                {
                    dp[i] = Math.min(dp[i], (1 + dp[i - coins[j]]) );
                    //either dp[i] or 1 more than the coin that is currently being considered from provided set of coins
                }
                else {
                    break; //to avoid iteration through bigger coins
                }
                
            }
        }
        
        if(dp[amount] > amount) return -1; //if number of coins is bigger than amoun
        else return dp[amount];
        
        
    }
}