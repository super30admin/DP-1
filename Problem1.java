// There are three approaches 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : Indices for previous calculated optimal amount


// Your code here along with comments explaining your approach

// Approach 1. Brute force
// Time complexity: O(2^(T/M))
//      T: Target Amount
//      M: Minimum of array i.e. nums
// Space complexity: O(T/M)
//      T: Target Amount
//      M: Minimum of array i.e. nums
class BruteForce {

    /** compute the fewest number of coins to make up the amount */
    public int coinChange(int[] coins, int amount) {
        
        return helper(coins, amount, 0, 0);
    }
    
    /**
     * Helper function to find minimum coins
     * @param coins array holding coin denomination
     * @param amount amount remaining
     * @param coinIndex index of coins[]
     * @param coinsUsed number of coins used
     * @return int
     */
    private int helper(int[]coins, int amount, int coinIndex, int coinsUsed){
        
        // base case 1.1: if amount is not achievable using the current coin
        // base case 1.2: All coins are used up
        if(amount < 0 || coinIndex >=coins.length)
            return -1;
        // base case 2: Amount is achieved
        if(amount == 0)
            return coinsUsed;
        // tree like structure
        else{
            // if don't use the current coin
            int notUseCoin = helper(coins, amount, coinIndex+1, coinsUsed); // increase the coin index

            // if we use the current coin we reduce the amount
            int useCoin =   helper(coins, amount-coins[coinIndex], coinIndex, coinsUsed+1); // increse coinsUsed
            
            // if amount not achievable from left side return right side
            if( notUseCoin == -1)
                return useCoin;
             // if amount not achievable from right side return left side
            if (useCoin ==-1)
                return notUseCoin;
            // if amount achievable from both branch return minimum
            else
                return Math.min(notUseCoin, useCoin);
        }
        
    }
}

// Approach 2. Dynamic programming 
// Time complexity: O(T*n)
//      T: Target Amount
//      n: number of coins
// Space complexity: O(T*n)
//      T: Target Amount
//      n: number of coins
class DP1 {

    /** find minimum coins to make up the amount*/
    public int coinChange(int[] coins, int amount) {
        
        // creating dp matrix from 0 to coins(row) and O to amount(col)
        int [][] dp = new int[coins.length+1][amount+1]; // adding for Amount=0 and coin value=0
        
        // initialize Oth col for all the row
        //   as you need zero coins to make zero amount
        for(int i=0;i<coins.length+1; i++)
            dp[i][0] = 0;
        
        // initialize Oth row for all the col 
        //  as you need infinite coins to make amount from Zero coin denomination
        for(int j=1; j<amount+1; j++)
            // instead of Integer.MAX_VaLUE 
            dp[0][j] = amount+1;
            // amount+1 will act as upper bound.

        // starting from 1st coin
        for(int i=1; i<coins.length+1; i++){
            
            // starting from 1st amount
            for(int j=1; j<amount+1; j++){
                
                // if amount is less than Coin-value we can't use the coin
                // Here we access 1st(Oth index) coin as [i-1] as we start i from 1.
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j]; // we copy the previous optimal 
                else
                    // if we use the coin - find minimum of previous coin used and current coin
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                    // here 1 signifies coin used
                    // we find the previous optimal coins used for (Amount - Coin value)
                    // Note: coins[i-1] - to find coin value as we start i from 1.
            }
        }
        
        // the last dp element will store minimum coins required.
        // if it is greater than amount means we can't acheive the amount using given coins.
        int result = dp[coins.length][amount];
        return (result> amount) ? -1:result;
        
    }
}

// Approach 3. Dynamic programming using less space
// Time complexity: O(T*n)
//      T: Target Amount
//      n: number of coins
// Space complexity: O(T)
//      T: Target Amount
class Problem1 {

   /** find minimum coins to make up the amount*/
   public int coinChange(int[] coins, int amount) {
        
        // creating dp array from O to amount
        int [] dp = new int[amount+1]; // adding for Amount = 0
        
        // initialize Oth col as you need zero coins to make zero amount
        dp[0]= 0; 
        // as you need infinite coins to make amount from Zero coin denomination
        for(int j=1; j<amount+1; j++)
            // instead of Integer.MAX_VaLUE 
            dp[j] = amount+1;
            // amount+1 will act as upper bound.

        // starting from 1st coin
        for(int i=0; i<coins.length; i++){
            
            // starting from 1st amount as we already intialzed 0th
            for(int j=1; j<amount+1; j++){
                
                // if coin can be used
                if(j >= coins[i])
                    // if we use the coin - find minimum of previous coin used and current coin
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i]]);
                    // here 1 signifies coin used
                    // we find the previous optimal coins used for (Amount - Coin value)
            }
        }
        
        // the last dp element will store minimum coins required.
        // if it is greater than amount means we can't acheive the amount using given coins.
        int result = dp[amount];
        return (result> amount) ? -1:result;
    }

}