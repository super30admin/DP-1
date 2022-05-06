

public class CoinChangeLeetcode322 {
/* Solution 1 basic brute force Recursion technique */
    //Time Complexity: O(A^N) N is the no of coins and A is the amount.
    //Spcae complexity: O(1) No auxillary data structure. Stack recursion space not counted. For stack space will be depth of the tree which will O(A)
    //Leetcode : Yes.
        public int coinChange(int[] coins, int amount) {

            if (coins == null) {
                return -1;
            }

            if (amount == 0) {
                return 0;
            }

            return minCoinChange(coins,amount,0);
        }

        public int minCoinChange(int[] coins, int amount, int index) {
            int count = 0;
            if (index >= coins.length) {
                return Integer.MAX_VALUE -1;
            }

            if (amount == 0) {
                return 0;
            }
            //we either take the coin and continiue with the same coin(as one coin can be used multiple times
            // or not take teh coin and move to the next coin
            if (coins[index] <= amount) {
                return  Math.min(1 + minCoinChange(coins, amount - coins[index], index),
                        minCoinChange(coins, amount, index + 1));
            }
            //if the current coin is greater than amount remaining then skip that coin and go the next avaialble coin
            return minCoinChange(coins, amount, index + 1);
        }

    /* Solution 2 Recursion technique using memiozation */
    //Time Complexity: O(N*A) N is the no of coins where A is the amount
    //Spcae complexity: O(N*A) No auxillary data structure. 
    //Leetcode : Yes


    Integer [][] dp;
    public int coinChange1(int[] coins, int amount) {

        if (coins == null) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        dp = new Integer[coins.length][amount + 1];
        int result = minCoinChange1(coins,amount,0) ;
        //this is need if we cannot get to the amount at all ex..given coin is only 2 and the amount is 3 we can never reach the amount 3 in that case. No coins possible. so return -1 otherwise leetcode test case fails.
        return result == Integer.MAX_VALUE-1 ? -1 : result;
    }

    public int minCoinChange1(int[] coins, int amount, int index) {
        int count = 0;
        if (index >= coins.length) {
            return Integer.MAX_VALUE -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (dp[index][amount] != null) {
            return dp[index][amount];
        }
        //we either take the coin and continiue with the same coin(as one coin can be used multiple times
        // or not take teh coin and move to the next coin
        if (coins[index] <= amount) {
            dp[index][amount] =  Math.min(1 + minCoinChange1(coins, amount - coins[index], index),
                    minCoinChange1(coins, amount, index + 1));
        } else {
            //this is need if we cannot get to the amount at all ex..given coin is only 2 and the amount is 3 we can never reach the amount 3 in that case. No coins possible. so return -1 otherwise leetcode test case fails.
            dp[index][amount] = minCoinChange1(coins, amount, index + 1);
        }
        return dp[index][amount];
    }
}

