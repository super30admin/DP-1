// COIN CHANGE PROBLEM
/*
Time Complexity: O(M*N) M- Coins, N- Amount
Space Complexity :O(M*N)

Approach:
    In a recursive approach, we can split each problem into two sub half's of choosing a coin and not choosing a coin

    In a recursive approach, we are cutting down the paths by using memorization where we store the optimal number of coins
        used until them for that amount

    Since the final optimal number of coins used is derived form the optimal number at each subproblem this approch
        can be used
 */

// COIN CHANGE PROBLEM
class Problem1 {
    class Solution {

        int[][] memoryMatrix;

        public int coinChange(int[] coins, int amount) {
            // Create global 2D array to represent coins as rows, column as
            // amount and the optimal coins used at an index for that amount
            memoryMatrix = new int[coins.length][amount + 1];
            // Initialize the array with -1 values
            for (int i = 0; i < coins.length; i++) {
                for (int j = 0; j < amount + 1; j++) {
                    memoryMatrix[i][j] = -1;
                }
            }
            int coinsUsed = helper(coins, 0, amount);
            // We choose -10 so that in case of case2 if you add +1 it won't result to integer overflow
            if (coinsUsed >= Integer.MAX_VALUE - 10) return -1;
            return coinsUsed;
        }

        private int helper(int[] coins, int i, int amount) {
            // BASE CASES
            // If amount cannot be achieved by using the coins
            if (amount < 0 || i == coins.length) return Integer.MAX_VALUE - 10;
            // If we got the desided amount
            if (amount == 0) return 0;
            //If the subproblem is already solved
            if (memoryMatrix[i][amount] != -1) return memoryMatrix[i][amount];

            // Don't choose the coin
            int case1 = helper(coins, i + 1, amount);

            //Choose the coin
            int case2 = 1 + helper(coins, i, amount - coins[i]);

            int coinsUsed = Math.min(case1, case2);
            // Store optimal value in memorization matrix
            memoryMatrix[i][amount] = coinsUsed;
            return coinsUsed;
        }
    }
}
