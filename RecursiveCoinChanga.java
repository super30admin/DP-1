// Time Complexity : O(2^n * m) n: no.of element, m : length of the binary tree
// Space Complexity :O(m + n) = n: no.of element, m : length of the binary tree
// Did this code successfully run on Leetcode : NO : Got TLE
// Any problem you faced while coding this :

class Solution {
    public int coinChange(int[] coins, int amount) {
        //base case
        if(coins ==  null || coins.length == 0) return 0;
        
        return helper(coins, amount, 0, 0);
        
    }
    
    public int helper(int[] coins, int amount, int i, int min){
        //base case
        if(amount < 0 || i >= coins.length) return -1;
        if(amount == 0) return min;
        
        // case 1: if coin is selected
        int case1 = helper(coins, amount-coins[i], i, min+1);
        
        // case 2: if coin is not selected
        int case2 = helper(coins, amount, i+1, min);
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        
        return Math.min(case1, case2);
        
    }
}