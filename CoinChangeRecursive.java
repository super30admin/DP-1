/**
 * Time complexity is exponential as we are using all the comibinations
 * space complexity is also exponential
 * Approach is here we are taking all combinations without memoization or storing temporary data
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;

        return coinChangeHelper(coins, 0, amount, 0);
    }

    public int coinChangeHelper(int coins[], int index, int amount, int coinsUsed){
        if(amount == 0) {
            return coinsUsed;
        }

        if (amount < 0 || index >= coins.length) {
            return -1;
        }

        //do not use coin at index so amount won't change and index will increase as we are not considering this coin
        int case0 = coinChangeHelper(coins, index + 1, amount, coinsUsed);

        //Case 1 is we are considering the coin so amount will be deducted from the coin used and index won't increment as we can use this coin again as we have infinite supply
        int case1 = coinChangeHelper(coins, index, amount - coins[index], coinsUsed + 1);

        if (case0 == -1) {
            return case1;
        }

        if (case1 == -1) {
            return case0;
        }

        return Math.min(case0, case1);
    }
}