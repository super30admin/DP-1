/*
 * TC: O(n), n: amount
 * SC: O(n), n" amount, for memoization.
 * 
 * Approach: I will recurse though all the coins and which return my values to the parents function, i would take the min values returned from the childrens.
 * Stop the recursion when i achive my target .also when my target becomes negative.Use memoization,
 * to chache the resulkts of subproblems.
 */


class Solution {
    int memo[];
    public int coinChange(int[] coins, int amount) {
        this.memo = new int[amount+1];
        int result = helper(coins,amount);
        return  (result == Integer.MAX_VALUE) ? -1 : result ;
    }

    private int helper(int[] coins, int amount){
        if(amount == 0)
            return 0;
        if(amount < 0) 
            return -1;
        if(memo[amount] != 0) return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int result = helper(coins, amount - coin);
            if(result < min && result >= 0){
                min =1+result;
            }
        }
        memo[amount] = min;
        return memo[amount];
    }
}