// recursive approach
// Time Complexity : 2^n
// Space Complexity : n
class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins.length == 0) return -1;

        return helper(coins, amount , 0 , 0);

    }

    private int helper(int[] coins, int amount , int index , int min)
    {
        //base case

        if(amount == 0) return min;

        if(amount < 0 || index >= coins.length) return -1;

        //recursive case

        //choose that coin

        int choose = helper(coins, amount-coins[index] , index , min+1);

        // dont choose that coin

        int notchoose = helper(coins, amount , index+1 , min);

        if(notchoose == -1) return choose;
        if(choose == -1) return notchoose;

        return Math.min(choose,notchoose);


    }
}


// dp
// Time Complexity : mxn
// Space Complexity : mxn

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0 ; i<=coins.length ; i++)
        {
            for(int j=0 ; j<=amount ; j++)
            {
                if(i==0 && j>0) dp[i][j] = amount+1;

                else if(j==0) dp[i][j] = 0;

                else if(coins[i-1] > j) dp[i][j] = dp[i-1][j];

                else dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-coins[i-1]]+1);

            }
        }

        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];

    }
}
