// Time Complexity : O(T/min(coins))
// Space Complexity : O(T/min(coins))
// Did this code successfully run on Leetcode : Time Limit Exceeded

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }
    private int helper(int[] coins, int amount, int index, int totalCoin){
        if(index>=coins.length || amount<0)
            return -1;
        if(amount == 0)
            return totalCoin;
        // case 1: we choose coin
        int case1 = helper(coins, amount, index+1, totalCoin);
        //case 2 : we dont choose coin
        int case2 = helper(coins, amount-coins[index], index, totalCoin+1); 

        if(case1==-1) return case2;
        if(case2==-1) return case1 ;

        else return Math.min(case1, case2);
    }
}