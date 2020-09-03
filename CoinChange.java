// Time Complexity : O(n*m), n is the number of coins and m is the amount
// Space Complexity : o(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        //initialze 0 for all denominations for amount 0
        for(int i=0; i<=coins.length;i++){
            dp[i][0] = 0;
        }
        //initialize max value for denomination 0 for all amount
        for(int j= 1; j<=amount;j++){
            dp[0][j] = 99999; //Int_max
        }
        

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
            	//if the amount is less than the denomination, then copy the previous denominations values
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{ //else it will the min of the previous denomination value and (current denomination coin plus coins of the required denomination to reach the amount)
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        //if the last amount value is greater than or equal to infinity or max value, return -1(no solution found), else return the value.
        return dp[coins.length][amount]>=99999?-1:dp[coins.length][amount];
        
    }
}