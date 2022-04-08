/**
Problem: https://leetcode.com/problems/coin-change/
TC: O(2^n)
SC: ??
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        return helper(coins, amount, 0, 0);
    }
    
    public int helper(int[] coins, int amount, int index, int coinsUsed) {
        
        if (amount == 0) {
            return coinsUsed;
        }
        
        if (index == coins.length || amount < 0) {
            return -1;
        }
        
        // Case 1: don't consider current coin
        int case1 = helper(coins, amount, index + 1, coinsUsed);
        // Case 2: consider current coin
        int case2 = helper(coins, amount - coins[index], index, 1 + coinsUsed);
        
        if (case1 == -1) {
            return case2;
        }
        
        if (case2 == -1) {
            return case1;
        }
        return Math.min(case1, case2);
    }
}