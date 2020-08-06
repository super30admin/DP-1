/* Finding minimum number of coins */

// Time Complexity : O(nk) where n is number of elements and k is sum
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* DP Solution */
// Your code here along with comments explaining your approach
//Here we will consider the pattern: for coin 1, its incrementing by 1 after 1 iteration
//for coin 2, its incrementing after twice of iteration
//for coin 5, its incrementing after five times of iteration
//secondly, we start O in the coins index(as we can have 0 amount case)

class Solution {
    public int coinChange(int[] coins, int amount){
        //edge case
        if(coins == null || coins.length == 0) return 0;
        //initialise 2d matrix with coins length +1 and amount +1
        //because we are starting with 0 index
        int[][] dp = new int[coins.length+1][amount+1];
        //initialise first index values[i][0] for Oth column as 0
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 0;
        }
        //keep integer.max or maximum value for 0th index for every column
        for(int j = 1; j <= amount; j++){
            dp[0][j] = 9999;
        }
        //here check if your amount value is lesser than coin denomination of previous
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    //now find min of value(above j index) and value at (j - coins[i-1])
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int result = dp[coins.length][amount];
        if(result >= 9999) return -1;
        else return result;
    }
}




/* Recursive Solution 

// Your code here along with comments explaining your approach
//Recursive approach-finding all the combinations starting from index O 
//and eliminating it(index) and follow the path(calculate it). the path number
//will provide you number of coins across it. We will finc repeating pattern here
//so it will result in time limit exceeded

class Solution {
    public int coinChange(int[] coins, int amount) {
        //helper function
        return helper(coins, amount, 0, 0);
    }
    private int helper(int[] coins, int amount, int index, int min){
        //base case
        if(amount < 0 || index >= coins.length) return -1;
        if(amount == 0) return min;
        //logic
        //1.not choosing index
        int case1 = helper(coins, amount, index + 1, min);
        //choosing index
        int case2 = helper(coins, amount-coins[index], index, min + 1);
        //if case 1 stops or lesser sum than amount
        if(case1 == -1) return case2;
        else if(case2 == -1) return case1;
        //returning min number of coins
        return Math.min(case1, case2);
    }
}

*/