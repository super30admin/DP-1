//TC: It is giving time limit exceeded bcz of exponential algo and we are using Exhaustive approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        return helper(amount, coins, 0, 0); 
    }
    
    public int helper(int amount, int[] coins, int index, int coinsUsed){
        
        //base
        if(amount == 0) return coinsUsed;
        if(amount < 0 || index == coins.length) return -1;
        
        //logic
        
        //choose
        int caseChoose = helper(amount - coins[index], coins, index, coinsUsed + 1);
        //not choose
        int caseNotChoose = helper(amount, coins, index + 1, coinsUsed);
        
        if(caseChoose == -1) return caseNotChoose;
        if(caseNotChoose == -1) return caseChoose;
        
        return Math.min(caseChoose,caseNotChoose);
        
        
    }
}