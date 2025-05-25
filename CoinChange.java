//Time Complexity: O(n*m) //where n = number of coins and m = amount
//Space Complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach: At each coin, a specific amount(j) can be achieved by finding min of coins that can be obtained if current 
//coin is skipped or  1+ min number of coins if current coin is chosen
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int i=1;i<=amount;i++){
            dp[0][i] = Integer.MAX_VALUE - 10;
        }
        for(int i=1; i<=coins.length; i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //System.out.println("In here.."+dp[i-1][j]+" "+dp[i][j-coins[i-1]]);
                    dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j-coins[i-1]]);
                }
                //System.out.println(dp[i][j]);
            }
        }
        if(dp[coins.length][amount] >= Integer.MAX_VALUE-10){
            return -1;
        }
        return dp[coins.length][amount];
    }
}