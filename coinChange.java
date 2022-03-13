// Time Complexity : O(m*n) ,where m is length of coins array and n is amount given
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

class coinChange {
    public int coin_Change(int[] coins, int amount) {
        // null case
        if (coins == null || coins.length == 0)
            return -1;
        int m = coins.length, n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 1; j < dp[0].length; j++) { // filling first row with infinity except 0th index in first row
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //coins[i-1] = dp[i][] because in dp array we have a dummy row
                if (coins[i - 1] > j) { // if the denomination of coin is greater than the amount to be made , then we
                                        // will not have choose case because it will not be a valid case
                    // zero case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // taking min of zero case and
                                                                                    // choose case ; for choose case we
                                                                                    // have to take those many steps
                                                                                    // back as that of denomination of
                                                                                    // coin
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if (result > amount)   //if it is not a valid case i.e if we have infinity at last row ,last column
            return -1;
        return result;
    }
}