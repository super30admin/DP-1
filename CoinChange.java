// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// =================== TOP-DOWN =================================
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        if(amount == 0) return 0;
        
        return coinChange(coins, amount, new int[amount]);
    }
    
    private int coinChange(int[] coins, int amount, int[] memo) {
        if( amount < 0) return -1;
        if( amount == 0) return 0;
        
        if(memo[amount - 1] != 0) return memo[amount - 1]; //result found
        int min = Integer.MAX_VALUE;
        
        for(int coin: coins) {
            int res = coinChange(coins, amount - coin, memo);
            if( res >= 0 && res < min) 
                min = res + 1;
        }
        
        memo[amount - 1] = (min == Integer.MAX_VALUE)? -1 : min;
        
        return memo[amount - 1];
        
    }
}