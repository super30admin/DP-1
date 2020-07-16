/* Time complexity: O(Tn); where T is the target and n is the number of elements
Space complexity: O(n)

1. Using dynamic programming to solve the problem of using different denominations of coins to add upto a target.
2. A matrix is used to store the different possible output for intermediate targte values.
3. At each step a comparison is done between giving priority to the "less number of coins used" and "being reluctant about the number of coins used (in which case the output at that step will be the previous row's)".

*/

class Solution{
    public int coinChange(int[] coins, int amount){
        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0; i<coins.length; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=amount; j++){
            dp[0][j] = 999999;
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }

                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }

        int val = dp[coins.length][amount];

        if(val > 999999){
            return -1;
        }

        else{
            return val;
        }
    }
}

