// recursive solution is exponential TC causes time limit to be exceeded
// hence we should choose DP solution where we store results and build on them subsequently

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return 0;
        }
        return helper(coins, amount, 0, 0);
    }
    private int helper(int[] coins, int amount, int index, int coinsUsed) {
        //base
        if(amount == 0) {
            return coinsUsed;
        }
        if(amount < 0 || index == coins.length) {
            return -1;
        }
        //logic
        //0 or not pick case
        int case0 = helper(coins, amount, index + 1, coinsUsed);
        //1 or pick case
        int case1 = helper(coins, amount - coins[index], index, coinsUsed + 1);
        if(case0 == -1) {
            return case1;
        }
        if(case1 == -1) {
            return case0;
        }
        return Math.min(case0, case1);
    }
}