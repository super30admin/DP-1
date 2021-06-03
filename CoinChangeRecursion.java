// TC: O(2^n)
class Solution {
    public int helper(int[] coins, int amount, int ind, int min) {
        // We have found the min value
        if(amount == 0) {
            return min;
        }

        if(amount < 0 || ind >= coins.length) {
            return -1;
        }
        // Use that coin at ind
        int case1 = helper(coins, amount - coins[ind], ind, min + 1);
        // Don't use coin at ind
        int case2 = helper(coins, amount, ind + 1, min);
        if(case1 == -1) {
            return case2;
        }
        if(case2 == -1) {
            return case1;
        }
        // This is when both the cases are returning valid min valu, we want the smallest of both
        return Math.min(case1, case2);
    }
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        // we are starting at 0th index and current min is 0
        return helper(coins, amount, 0, 0);

    }
}