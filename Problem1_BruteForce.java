//Problem: 322. Coin Change
/** 3 Pointer Approcach: 
 * Used recursive tree to to iterate over all possible sets.
 * Choose any coin and go with : 
 * LEFT - NOT Choosesn 
 * RIGHT - Choosen. 
 * The approach will cover all possible combinations. However, its time complexity is exponential.
 */ 
//
//time Complexity :
// O(2^X) => where X = TargetAmount/Minimum Coin value

// Space Complexity :
// O(X) => where X = TargetAmount/Minimum Coin value

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO. Initially took some time to comprehend the logic, later it was intiutive.

class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinsused(coins, amount, 0, 0);        
    }
    
    public int coinsused(int[] coins, int amountleft, int count, int coinIndex){
        
        if(amountleft==0)
            return count;
        
        if(amountleft < 0)
            return -1;
        
        if(coinIndex>=coins.length){
            return -1; 
        }
        
        int amt = coins[coinIndex];
        
         int cnt1 = coinsused(coins, amountleft, count, coinIndex+1);  
         int cnt2 = coinsused(coins, amountleft-amt, count+1, 0);  
        
         if(cnt1==-1) return cnt2;
         if(cnt2==-1) return cnt1;
         return Integer.min(cnt1, cnt2);
    }
}