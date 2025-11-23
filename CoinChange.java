//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
//Solved in leetcode: Yes
/*
used 2d array for dp table
took coins in the row and amount in the column
iterated through each of the coin combinations and the amount possible
in every row, if the current coin denomination is greater that the amount we want, dont take it and store the dp value of above row.
if value of current coin in less than or equal to amount,
use 1 coin and calculate the rest and get the dp value of it which is already calculated from the table
 */
public class CoinChange {
    public int getMinCount(int[] coins, int amount){
        //increment the length by 1 as we are having an extra row and column
        int n = coins.length+1;
        int m = amount+1;

        int[][] dp = new int[n][m];

        // fill the first row with a maximum number, so it is easy for next rows to calculate min
        for (int j=1;j<m;j++){
            dp[0][j] = amount+1; //take the maximum number
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                // coin value is greater than amount
                if (coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j]; // get the previous row value
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);  // min of considering the coin and not considering the coin
                }
            }
        }

        if (dp[n-1][m-1] > amount){
            return -1;
        } else {
            return dp[n-1][m-1]; //last row and last column stored the result
        }
    }
    public static void main(String args[]) {
        CoinChange cg = new CoinChange();
        int count = cg.getMinCount(new int[]{1,2,5}, 11);
        System.out.println(count);
    }
}
