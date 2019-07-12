/*
Time Complexity : O(amount * coins interation)
Space Complexity : O(amount)
Did this code successfully run on Leetcode : not tried on Leetcode. It ran on my IDE with correct console output.
Any problem you faced while coding this : Implemented as explained in class.
*/

class coin
{
    // m is size of coins array (number of different coins)
    static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 9999;
        }



        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // case1 : copied value from above
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }// case2 : use that weird formula
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result >= 9999)
        {
            return -1;
        }
        return result;
    }


    public static void main(String args[])
    {
        int coins[] =  {1, 2, 5};
        int A = 11;
        System.out.println("Minimum coins required is "+ coinChange(coins, A) );
    }
}