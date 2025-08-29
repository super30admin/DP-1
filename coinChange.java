// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public int coinChange(int[] coins, int amount) {
        int re = helper(coins, 0, amount, 0);
        if (re == Integer.MAX_VALUE) {
            return -1;
        }
        return re;
    }

    private int helper(int[] coins, int i, int amount, int coinsUsed) {
        if (amount < 0 || i == coins.length){
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return coinsUsed;
        }

        int case0 = helper(coins, i + 1, amount, coinsUsed);

        int case1 = helper(coins, i, amount - coins[i], coinsUsed + 1);

        return Math.min(case0, case1);
    }
}
