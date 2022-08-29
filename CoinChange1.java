// Time Complexity:  O(m*n) where m is the number of coins and n is the total amount
// Space Complexity : O(m*n) where m is the number of coins and n is the total amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



class CoinChange1 {
    // Dynamic Programming approach
        public int coinChange(int[] coins, int amount) {

            //null check
            if(coins == null || coins.length == 0)
                return 0;

            int m = coins.length;
            int n = amount;

            int dp[][] = new int[m+1][n+1];

            //fill the first value with 0
            dp[0][0] = 0;

            //fill the top row
            for (int j=1 ; j < dp[0].length ; j++){
                dp[0][j] = amount +1;
            }

            //fill the table
            for(int i=1; i< dp.length ; i++){
                for(int j=1 ; j<dp[0].length ; j++){

                    // till amount is not equal to denomination, fill the values as it is from above row
                    if(j< coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }

                    else{
                        dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                    }
                }
            }

            int result = dp[m][n];
            if(result > amount)
                return -1;
            return result;
        }
}

/* This is recursive method TC: 2^n where n is number of possibilities in the diagram. This gives Time Limit Exceeded in LC, so we go with DP approach.


class Solution {
    public int coinChange(int[] coins, int amount) {

        //null case
        if(coins == null || coins.length == 0)
            return 0;
        return helper(coins, amount, 0,0);
    }

    private int helper(int[] coins, int amount, int idx, int min){

        //base case
        if(amount < 0 || idx == coins.length)
            return -1;

        if(amount == 0)
            return min;

        //case1 - if coin is chosen
        int case1 = helper(coins, amount - coins[idx], idx , min+1);

        //case0 - if coin is not chosen
        int case0 = helper(coins, amount , idx +1 , min);

        if(case1 == -1)
            return case0;

        if(case0 == -1)
            return case1;

        return Math.min(case0,case1);
    }

}

*/

}
