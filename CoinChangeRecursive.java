// Time Complexity : o(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
class CoinChangeRecursive {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,0,amount,0);
    }
    
    public int helper (int[] coins, int i, int amount, int min) {
        //Base Case
        if (amount <0 || i>coins.length -1) return -1;
        if (amount == 0) return min;
        //case1: choose the coin
        int case1 = helper(coins,i,amount-coins[i],min+1);
        
        //case2: Not choose the coin
        int case2 = helper(coins,i+1,amount,min);
        
        if (case1==-1) 
            return case2;
        
        else if (case2== -1) 
            return case1;
        
        else 
            return Math.min(case1, case2);
        
    }
}