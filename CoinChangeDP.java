/**
 Time complexity: O(n * m) where n = coins length and m is amount
 Space complexity: O(n * m) where n = coins length and m is amount

 Approach here we are storing the results
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int noOfCoins = coins.length;
        int[][] dp = new int[noOfCoins + 1][amount + 1];

        for (int j = 1; j < amount + 1; j++) {
            //assign the combination of 0 coins and amount as greater than one as something infinite but here we can keep it as amount + 1 as that is infinite for us we are avoiding here to use infinite as it might cause integer overflow
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < noOfCoins + 1; i++) {
            int currentCoinVal = coins[i - 1];
            for (int j = 1; j< amount + 1; j++) {
                // so case where coin value is more than amount we can make it possible only by not sing that particular coin and that case is just above row
                if (j < currentCoinVal) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //case 0 is don't pick up coin which is one row above us and 2nd case is pick up the coin that is one 1 + as we are picking that coint and then current amount - coin amount
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - currentCoinVal]);
                }
            }
        }

        // so consider scenario where achieving amount is not possble [2, 5] 1 so entire array will be filled by amount + 1;
        if(dp[noOfCoins][amount] > amount) {
            return -1;
        }

        return dp[noOfCoins][amount];
    }
}