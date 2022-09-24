// Time Complexity : O(MN) M = Length of Coins Array and N = amount
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Solution 1:
// Greedy does not work in all cases so we will try exhaustive approach by giving recursive call
// We will try all combinations using this approach
// This works with small size but is not time efficient so we will try solution 2
// Make sure you check Solution 1 first

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         // base case
//         if(coins == null || coins.length == 0) return -1;
//         return helper(coins, amount, 0, 0);
//     }

//     private int helper(int[] coins, int amount, int index, int coinsUsed) {
//         // base case
//         if(index == coins.length || amount < 0){
//             return -1;
//         }

//         // matched case
//         if(amount == 0){
//             return coinsUsed;
//         }

//         // if we do not choose a coin we need to move to next coin so index + 1
//         int case1 = helper(coins, amount, index + 1, coinsUsed);

//         // if we choose a coin then we need to calculate the amount after choosing the coin as below
//         // and increase the coinsUsed because we have used 1 coin by choosing it
//         int case2 = helper(coins, amount - coins[index], index, coinsUsed + 1);

//         if(case1 == -1) {
//             return case2;
//         }

//         if(case2 == -1) {
//             return case1;
//         }

//         // if both cases has gives you some number of coinsUsed then we need to return the minimum
//         return Math.min(case1, case2);
//     }
// }

//Solution 2: DP solution
//        In DP we try to create a formula that solves our problem
//        We will store number of minimum coins used to store amount using given coins
//        Try to understand the formula designed below


class Solution {
    public int coinChange(int[] coins, int amount) {
        // base case
        if(coins == null || coins.length == 0) return -1;

        int m = coins.length;
        int n = amount;

        // declare a dp matrix with no of type of coins available + 1 and column of amount + 1
        int[][] dp = new int[m + 1][n + 1];

        // fill in first row with value which is greater than amount
        for(int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1;
        }

        // start filling your matrix from row 1 and col 1
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // if current amount is less than type of coin then just copy values from cell above current cell
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    // else set the current cell value as min of
                    // cell above and
                    // cell which is type of coin(1 or 2 or 5) behind the current cell
                    int preCellVal = dp[i][j - coins[i - 1]];
                    dp[i][j] = Math.min(dp[i - 1][j], preCellVal + 1);
                }
            }
        }

        // you will always find your min coins required in the last cell of matrix
        // if that cell contains amount which not possible that means we cannot make any combination from given coins
        if(dp[m][n] == amount + 1) {
            return -1;
        }

        // min coins used lies in last cell so return that
        return dp[m][n];
    }
}