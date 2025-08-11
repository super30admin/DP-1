// Time Complexity : O(m * n), m is number of rows and n is total number of columns
// Space Complexity : O(m * n), since we are using 2D matrix of m X n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //1. recrusive way - exhaustive search, leads to exponential time complexity

        //2. DP - saving the already computed results. The below approach is DP.

        //2D array
        int[][] dpArray = new int[coins.length + 1][amount + 1];

        //set the dummy columns to amount + 1
        for(int i = 0; i < amount + 1; i++){
            dpArray[0][i] = amount + 1;
        }

        //starting from row 1, col 1, compute minimum number of coins required to make up the change.
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i - 1]){ //coin array starts at 0, we are iterating from 1 due to dummy row and col.
                    dpArray[i][j] = dpArray[i - 1][j];
                }
                else{
                    dpArray[i][j] = Math.min(dpArray[i - 1][j], 1 + dpArray[i][j - coins[i - 1]]);
                }

            }
        }

        //return the value of last row and column which will have minimumn number of coins to make up the amount.
        if(dpArray[coins.length][amount] == amount + 1){
            return -1;
        }
        return dpArray[coins.length][amount];



    }
}