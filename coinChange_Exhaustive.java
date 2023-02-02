//Exhaustive approach
//Top down approach
//TC: O(2^(m+n))
//SC: exponential 
class Solution {
    public int coinChange(int[] coins, int amount) {
        //base case
        if(coins == null || coins.length == 0) return 0;
        return helper(coins, amount, 0, 0);      
    }
    
    private int helper(int[] coins, int amount, int i, int min){
        //base
        if(amount == 0) return min;
        if(i == coins.length || amount < 0) return -1;
        
        //choose
        int case1 = helper(coins, amount-coins[i],i,min+1);   
        //not choose
        int case0 = helper(coins, amount, i+1, min);
        
        if(case1 == -1) return case0;
        if(case0 == -1) return case1;
        
        return Math.min(case1,case0);
    
    }
}
