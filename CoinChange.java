// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
//Lets use DP and use 2D matrix with row being the coin denomination and column being the amount

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins== null || coins.length == 0) return -1;
        int m = coins.length;
        int n = amount;
        // In java by default the initialized int array will have default values 0.
        int[][] dp = new int[m+1][n+1]; // to accomodate 0 entry row and column
        //fill the first row and second column with infinity as the amount cannot be formed with coin denomination 0
        for(int j=1;j<=n;j++){
            dp[0][j] = amount+1;//here you can use infinity or amount+1 to denote infinity
        }
        //Fill the cell values with minimum number of coins used until that point.
        //variable  and j through columns
        for(int i = 1;i <= m;i++){//i iterates through rows and start with index 1 as you have 0 in index 0
        for(int j=1;j<=n;j++){//j iterates through columns and starts with index 1
        //if my amount is less than the coin denomination just copy the above row as its not chose the coin (case 0)
if(j<coins[i-1]){//coins[0],coins[1]....
//fill the dp matrix with the value above in the case when you dont chose the coin
    dp[i][j]= dp[i-1][j];

}
else{
    //if(j=coins[i-1] or j> coins[i-1]) you will have both 0 case (not choose) and 1 case(to choose) so you find the minimum between them.
    //dp[i-1][j] (0 case) and dp[i][j - coins[i-1]] (1 case as it lies in the cell of amount - coin denomination). you add +1 to chose case as you have picked the coin)
    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j - coins[i-1]]);
}
        }

        }
        //if the last entry is infinity return not found -1;
        if(dp[m][n]==amount+1){
            return -1;
        }
        //last entry would have the min coin amount
        return dp[m][n];
    }

}

// Time Complexity : 2^n [n is the length of the coins array]
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : No[Time limit exceeded]
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
//Lets implement using exhaustive approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins== null || coins.length == 0) return -1;
        return helper(coins,amount,0,0);
        
    }
    private int helper(int[] coins, int amount, int index, int numberOfCoins){
        //base
        if(index == coins.length || amount < 0){
            return -1;
        }
        if(amount == 0){
            return numberOfCoins;
        }
        //logic
        //zero case or do not chose
        int case1 = helper(coins,amount,index+1,numberOfCoins);
        //one case or chose case
        int case2= helper(coins, amount-coins[index],index, numberOfCoins+1);
        if(case1==-1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return Math.min(case1,case2);
    }
}