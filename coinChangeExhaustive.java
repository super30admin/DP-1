// Time Complexity : 2^n, exponential time, not an efficient solution
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Works only on sample test cases
// Any problem you faced while coding this :

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //1. recrusive exhaustive way

        if(coins == null || coins.length == 0){
            return -1;
        }

        return recurse(coins, amount, 0, 0);

        //2. DP way
        

    }

    private int recurse(int[] coins, int amount, int index, int coinUsed){
        //base case
        if( index == coins.length || amount < 0){
            return -1;
        }
        if(amount == 0){
            return coinUsed;
        }

        //logic
        //case 0 -> do no choose coin
        int case1 = recurse(coins, amount, index + 1, coinUsed);
        //case 1 -> choose coin
        int case2 = recurse(coins, amount - coins[index], index, coinUsed + 1);

        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return Math.min(case1, case2);
    }
}