// Time Complexity = O(mn), where m=no of coins, n=given amount
// Space Complexity = O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int n = coins.length;

        // 2D array for coins vs amount
        int[][] dp = new int[n+1][amount+1];

        // Update the values of the 2D matrix
        for (int i=0; i<=n;i++) {
            for (int j=0; j<=amount; j++) {
                // Case 1: Here amount=0, so we pay 0 coins for it.
                if (j == 0) {
                    dp[i][j] = 0;
                }
                //case 2: Here we have 0 coins, therefore we need infinite number of coins to pay the amount.
                else if (i == 0) {
                    dp[i][j] = 100000; //Assume 100,000 is infinity
                }
                //case 3: Here the coin denomination is greater than the amount to be paid, so we take the value from the top of the matrix, like in the exclude case
                else if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                //case 4: This case is min(Include, exclude), where
                //Exclude -> taken from the above block in the matrix
                //Include -> (1 + stay in the same row but go back to coin denomination number of spots in the colomn field)
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        //If the last block of the 2d matrix is infinity i.e., its greater than the amount we return -1 since the amount cant be formed using the available coins, otherwise we return the amountin the field
        return (dp[n][amount] > amount) ? -1 : dp[n][amount];
    }
}