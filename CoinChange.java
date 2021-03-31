/**Leetcode Question 322 - Coin Change */
/**Algorithm - DP
 * Make a 2D array to store the coins denomination and the amount
 * For every row-colums pair, fill them with the num of minimum ways in which the given amount can be made.
 * Return the last element in the matrix
 */
/**TC- O(MN) - M= No. of rows, N = no. of columns
 * SC - O(MN)
 */
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins==null || coins.length == 0){
                return -1;
            }
            int[][] dp = new int[coins.length+1][amount+1];
            for(int j =1; j < dp[0].length; j++){
                dp[0][j] = amount + 1;
            }
            for(int i =1; i< dp.length; i++){
                for(int j =1; j< dp[0].length; j++){
                    if(coins[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                    }
                }
            }
            if(dp[dp.length-1][dp[0].length -1] == amount + 1){
                return -1;
            }
            return dp[dp.length-1][dp[0].length-1];
        }
    }
}
