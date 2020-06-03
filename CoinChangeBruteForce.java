// Time Complexity : Exponential
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Using Brute force

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0,0);
    }
    
    private int helper(int[] coins, int amount, int idx, int min){
        //Base
        if(amount == 0) return min;
        if(amount < 0 || idx > coins.length - 1) return - 1;
    
        //Logic

        int case1 = helper(coins, amount, idx+1,min);
        int case2 = helper(coins, amount-coins[idx], idx, min+1);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1,case2);
    }
}
    