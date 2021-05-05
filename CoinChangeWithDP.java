package DynamicProgramming;

/*
-------------------------------------------------------------------------------------------------------
    Time complexity : O(log mn) : m=number of coins. n=amount 
    space complexity: O(log mn) : m=number of coins. n=amount 
    Did this code run successfully in leetcode : yes
    problems faces : no
*/
public class CoinChangeWithDP {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                //denomination of coin is less than amount
                if (j < coins[i - 1]) {
                    
                    //zero case
                    dp[i][j] = dp[i - 1][j];
                    
                } else {
                    
                    //zero case and one case
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }

        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        if (result >= amount + 1)
            return -1;

        return result;

    }

}
