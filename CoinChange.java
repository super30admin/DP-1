
// Solution 1 => Recursion (TLE)

/**
 * Time Complexity: O(2 ^ (n + m)), where n = no. of coins and m  is amount. Since at every level we give 2 calls and we have levels till either n is exhausted or amount is exhausted
 * Space Complexity: O(n + m), levels in a tree
 */


class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, 0, amount);

        if(result >= Integer.MAX_VALUE - 1){ // - 1, because we add 1 if coin is selected. Can lead to INTEGER Overflow
            return -1;
        }

        return result;
    }

    private int helper(int [] coins, int idx, int amt){
        //base condition
        if(amt == 0){
            return 0;
        }

        if(idx >= coins.length || amt < 0){ // if all coins are processed but amount is still remaining or if coins are present but exact amount could not made using coins
            return Integer.MAX_VALUE - 1;
        }

        // Logic

        if(coins[idx] > amt){   // if coin denom at index is greater
            return helper(coins, idx + 1, amt); // we skip that coin
        }

        int case1 = 1 + helper(coins, idx, amt - coins[idx]); // pick coin

        int case2 = helper(coins, idx + 1, amt);  // don't pick coin

        return Math.min(case1, case2);
    }
}

// Solution 2 => Memoization / Top-Down Approach

/**
 * Time Complexity: O(m * n), where n = no. of coins and m  is amount. Since maximum combinations for coin amount is no. of coins * amount
 * Space Complexity: O(n * m),  Since maximum combinations for coin amount is no. of coins * amount that we store in matrix
 */

class Solution {

    int [][] dp;

    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount];

        int result = helper(coins, 0, amount);

        if(result >= Integer.MAX_VALUE - 1){
            return -1;
        }

        return result;
    }

    private int helper(int [] coins, int idx, int amount){
            // base condition
            if(amount == 0){
                return 0;
            }

            if(idx >= coins.length || amount < 0){
                return Integer.MAX_VALUE - 1;
            }


            if(dp[idx][amount - 1] != 0){ // if subproblem is already calculated
                return dp[idx][amount - 1];
            }

            // Logic

            if(coins[idx] > amount){ // if coin denom is greater than amount, skip coin
                return helper(coins, idx + 1, amount);
            }

            int case1 = helper(coins, idx + 1, amount); // dont pick coin
            int case2 =  1 + helper(coins, idx, amount - coins[idx]); // pick coin hence add 1

            return dp[idx][amount - 1] = Math.min(case1, case2);
        }
}


// Solution 3 => Tabulation/Botton-Up 

/**
 * Time Complexity: O(n * m), where n = no. of coins and m  is amount. Since for each coin we iterate m times
 * Space Complexity: O(m), where m = amount. Since we have only 1d array whose size is equal to amount + 1
 */

class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int m = amount + 1;
        
        int [] dp = new int[m];

        for(int j = 1; j < m ; j++){
            dp[j] = 11000; // max amount is 10^4
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(coins[i] <= j){  // if coin denom is smaller or equal to amount
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]); // pick min between => if coin not selected and if coin selected
                }
            }
        }

        if(dp[m - 1] >= 11000){ // if last index value is greater than 11000
            return -1; 
        }

        return dp[m - 1];
    }
}