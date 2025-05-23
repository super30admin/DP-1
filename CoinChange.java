// Time Complexity : O(n*m) where n is the number of coins and m is the amount
// Space Complexity : O(n*m) where n is the number of coins and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class CoinChange {

    /*
     **** 
     * The table method ****
     * 0 1 2 3 4 5 6
     * 0 0 & & & & & &
     * 2 0 & 1 & 2 & 3
     * 5 0 & 1 & 2 1 3
     * 
     */
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];

        dp[0][0] = 0;

        // fill top row with &
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1;
        }

        // below we are using coins[i-1] since we are mapping with the original array
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) { // when the current index of the amount is still less than the current
                                        // denomination
                    dp[i][j] = dp[i - 1][j];
                } else { // take steps back as much as denomination
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        int result = dp[coins.length][amount];
        if (result > amount)
            return -1;
        return result;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount)); // Output: 3
    }
}