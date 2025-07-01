// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Appproach; I used an 2D Array to store for any repeated possibilites. and to fill the matrix comparing coins with amount if amount is less than coin of matrix fill the matrix with the previous row value and for other cases compare the skipping case and we are picking a coin case +1 .return the minimum value of it.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0){
            return -1;
        }
        int [] [] dp= new int [coins.length+1] [amount+1];

        for(int j=1;j<=amount;j++){
            dp[0] [j] =99999;
        }
        for (int i=1;i<=coins.length;i++){
            for( int j=0;j<=amount;j++){
                 if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else{
                dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if (dp[coins.length][amount]==99999){
            return -1;
        } else{
        return dp[coins.length][amount];
        }
        
    }
}