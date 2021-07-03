//time complexity Exponential
//space complexity O(1)

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }

    private int helper(int[] coins, int amount, int index, int min){
        //Base
        if(amount < 0 || index > coins.length - 1) return -1;
        if(amount == 0) return min;

        //Logic
        //case1
        int case1 = helper(coins, amount, index+1, min);
        int case2 = helper(coins, amount-coins[index], index, min+1);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }
}
