// Time Complexity :O(n) going to exponential (not sure about the Time complexity)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : ran but for a few cases Exceeded time limit
// Any problem you faced while coding this : figuring out the better solution 


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int minNoOfCoins = -1;
        // null case
        if(coins.length ==0 || coins == null)
            return minNoOfCoins;
        
        minNoOfCoins = helper(coins,0,amount,0);
        
        return minNoOfCoins;
    }
    private int helper(int[] coins,int index,int leftAmount , int coinsCount)
    {
        // base
            if(leftAmount == 0 )
            return coinsCount;
        
        if(leftAmount  < 0 || index == coins.length  )
            return -1;
    
        
        // logic
        
        // not to take this coin anymore
       int  case1 = helper(coins,index+1,leftAmount, coinsCount);
        // take this coin
       int case2 = helper(coins,index,leftAmount-coins[index], coinsCount+1) ;
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        
           return Math.min(case1,case2);
    }
}