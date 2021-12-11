// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Initialize a 2d matrix where rows =  coins.length + 1 and columns = amount + 1;
 * 1st row is for coin 0. Hence put in 1st row 1st col = 0 and for rest of the columns of 1st row as inifinity( defined as amount + 1)
 * Now for each row, check if col value is less than coins[row - 1]. If yes, put in dp[row][col] = dp[row-1][col].
 * Else, dp[row][col] = Minimum between --> dp[row-1][col] or 1 + dp[row][col - coins[row - 1]] 
 * This way at the last row last col of dp matrix we will get, minimum coins required to make current amount.
 * If this value is greater than amount we want to make, there is no way we can form this amount with given coins so we return -1.
 * Else we return the value which is present at last row last column.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null || amount == 0)return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int col = 1; col < dp[0].length;col++)dp[0][col] = amount + 1;
        
        for(int row = 1; row < dp.length;row++){
            for(int col = 0; col < dp[0].length;col++){
                if(col < coins[row-1])dp[row][col] = dp[row-1][col];
                else{
                    dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col - coins[row - 1]]);
                }
            }
        }
        
        if(dp[dp.length-1][dp[0].length - 1] > amount)return -1;
        return dp[dp.length-1][dp[0].length - 1];
    }
    

    //Recursive approach solution
	
    private int cal(int[] coins, int index, int amount, int target, int count){
        //base case
        if(index == coins.length || amount > target)return -1;
        if(amount == target)return count;
        
        //logic
        //case 1 - not to choose current coin
        int case1 = cal(coins, index+1, amount, target, count);
        
        //case2 2 - choose current coin
        int case2 = cal(coins, index, amount + coins[index],target, count+1);
        
        if(case1 == -1)return case2;
        if(case2 == -1)return case1;
        
        return Math.min(case1, case2);
    }
}