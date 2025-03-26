class Solution {
    public int coinChange(int[] coins, int amount) {

        //using recursion T(m, n) = 2 ^ (m+n = depth of recurisve tree)
        // space complixity is stack size m+n
        // leetcode time limit exceeding
        //going for better approach Dynamic programming
        int coinsUsed = 0;
        int index = 0;
        int sum = amount;

        coinsUsed = helper(coins, index = 0, sum, coinsUsed);
        if(coinsUsed == Integer.MAX_VALUE) return -1;

        return coinsUsed;

    }

    private int helper(int[] coins, int index, int sum, int coinsUsed)
    {
        if(sum == 0) return coinsUsed;
        else if(sum < 0 || index >= coins.length) return Integer.MAX_VALUE;

        int coinsUsedL = helper(coins, index+1, sum, coinsUsed);
        int coinsUsedR = helper(coins, index,  sum - coins[index], coinsUsed+1);

        return Math.min(coinsUsedL, coinsUsedR);

    }
}