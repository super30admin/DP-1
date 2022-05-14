/* Problem 1: Coin Change 1
*/

// Time Complexity : O(mn) where m is amount and n is number of coins
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Dynamic Programming
//1. Greedy Approach: Start with greedy approach and see if it doesn't fail in any other cases. It chooses local optimum/best optimal value at each time. Its non exhaustive and best approach
//2. If greedy fails, start with exhaustive approach(recursion) and see flow chart and tree.
//3. Look for repeated subproblems, if it exists, use DP approach
//4. look for decision making parameters like in this case, its n(number of coins) and m(amount)
//5. now create 1d/2d array based on decision parameters(if we have only 1 constraint then 1d array will work)
//6. convert your tree into matrix(m*n)
//Approach 1: Recursion(Exhaustive approach).
//How many nodes/recursive calls in recursive stack? (m + n) max calls where n: number of coins, m:amount(m and n are deciding parameters) 
//0(t) = O(m+n)
//This will result in TLE(time limit exceeded)
//Approach 2: DP Matrix
//convert into 2d array(matrix) because we have 2 decision parameters here
//O(t) = O(mn) and O(s) = O(mn)
//Approach 2: DP Matrix
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        //initialise first row and column as 0. we will be creating another top row for 0th values
        dp[0][0] = 0;
        //top row
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //Case 1: if amount < denomination of coin, then values will be previous row values
                //since we are taking 0 rows as well, so index i will be i-1 since i starts from 0
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result > amount) return -1;
        return result;
    }
}

//Approach 1: Recursion Exhaustive approach
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         return helper(amount, coins, 0, 0);
//     }
//     //create private helper function
//     //changing parameters: amount, coins, index, coinsUsed
//     private int helper(int amount, int[] coins, int index, int coinsUsed){
//         //base: terminating cases
//         if(amount == 0) return coinsUsed;
//         if(amount < 0 || index == coins.length) return -1;
//         //logic: since we create flow chart, we will have two options: choose(1) or not choose(0)
//         //1.Case 1: not choose
//         int case1 = helper(amount, coins, index + 1, coinsUsed);
//         //2.Case 2: choose
//         int case2 = helper(amount - coins[index], coins, index, coinsUsed + 1);
//         //while it iterated in both directions in tree, if either of cases results in -1(means amount < 0 or index goes out of bounds), then choose other direction
//         if(case1 == -1) return case2;
//         if(case2 == -1) return case1;
//         return Math.min(case1, case2);
//     }
// }