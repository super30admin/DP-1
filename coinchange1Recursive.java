// Time Complexity :O(m * n) m- no.of coins , n is amount
// Space Complexity :O(1);
// Did this code successfully run on Leetcode :Y (TLE error)
// Any problem you faced while coding this : I faced the TLE error so I did this in DP approach to overcome it.

import java.lang.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        return helper(coins, 0, amount, 0);
        
        
    }
       private int helper(int[] coins, int i, int amount, int mincoins)
       {
           if(amount==0)
               return mincoins;
           if(amount<0 || i == coins.length)
               return -1;
           
         //choose
             int case1= helper(coins,i,amount-coins[i],mincoins+1);
           
         //no choose
              int case2= helper(coins,i+1,amount,mincoins);
           
           if(case1==-1)
               return case2;
           if(case2==-1)
               return case1;
           
           return Math.min(case1,case2);
       
        
    }
}

