// Brute force - exhaustive approach. Time complexity O(2^n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }
    
    private int helper(int[] coins, int amount, int i, int minCoinsSoFar) {
        // base
        if (amount < 0 || i == coins.length) return -1;
        if (amount == 0) return minCoinsSoFar;
        
        // logic
        // choose case
        int case1 = helper(coins, amount - coins[i], i, minCoinsSoFar+1);
        // not choose case
        int case0 = helper(coins, amount, i+1, minCoinsSoFar);
        
        if (case0 == -1) return case1;
        if (case1 == -1) return case0;
        return Math.min(case0, case1);
    }
}