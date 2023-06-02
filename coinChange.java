/*
 * Exhaustive approach based on choose or dont choose
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, 0, amount, 0);
    }
    private int helper(int [] coins, int idx, int amount, int coinsUsed)
    {
        //base
        //amount remaining is zero then we have found the path
        if(amount == 0)
        {
            return coinsUsed;
        }
        //amount is negative or coins finished then path not found
        if(amount < 0 || idx == coins.length)
        {
            return -1;
        }

        //logic
        //choose
        int case1 = helper(coins,idx,amount-coins[idx],coinsUsed+1);

        //don't choose
        int case2 = helper(coins,idx+1,amount,coinsUsed);
        //check if case1 or case2 returns -1
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }
}