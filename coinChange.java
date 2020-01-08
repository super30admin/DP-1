//Recursive Approach

// Time Complexity : O(2^(m*n)) n- number of coin denominations and m is the amount
// Space Complexity : O(1) - if recursive stack is not considered.
//If stack is considered, it is O(nm).
// Did this code successfully run on Leetcode : TIME LIMIT EXCEEDED
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount,0,0);
    }

    private int helper(int []coins,int amount,int index,int min){
        //Base case
        if(amount == 0) return min;
        if(index >= coins.length || amount < 0) return -1;

        //Logic
        //not chosen
        int case1 = helper(coins,amount,index+1,min);
        int case2 = helper(coins,amount-coins[index],index,min+1);

        if(case1 == -1) return case2;
        else if(case2 == -1) return case1;
        else{
            return Math.min(case1,case2);
        }

    }
}



//DP APPROACH

// Time Complexity : O(NK) - where n is the number of coin denominations and k is the amount
// Space Complexity : O(NK) - where n is the number of coin denominations and k is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length+1][amount+1];
        int result = 0;

        int m = dp.length;
        int n = dp[0].length;

        //Fill the first column to 0.
        for(int i=0;i<m;i++){
            dp[i][0] = 0;
        }


        //Fill the first row to infinity for comparison
        for(int i=1;i<n;i++){
            dp[0][i] = 99999;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //if the amount has not reached the denominatin yet,
                //copy the value from the previous row
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                    //choose the minimum between the above value or the one behind by //coins[i-1] denomination
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }

        result = dp[m-1][n-1];
        //if result is infinity, no combination works
        if(result == 99999)
            return -1;
        return result;
    }


}


