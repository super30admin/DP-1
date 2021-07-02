//Brute force approach for Coin Change Problem
//Time Complexity: O(2^(M+N)) where M = amount , N = number of coins
//Space complexity: O(M+N)
//did it run for all the test case in leetcode: No
//did you face any problem: yes, time limit exceeded

//write down your aproach
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0)
            return 0;
        
        return helper(amount, coins, 0, 0);  
    }
    
    private int helper(int amount, int[] coins, int index, int min){
        
        //base case 1
        if(amount == 0)
            return min;
        //base case-2
        if(amount < 0 || index >= coins.length)
            return -1;
        
        //choose the index
        int case1 = helper(amount-coins[index], coins, index, min+1);
        
        //dont choose
        int case2 = helper(amount, coins, index+1, min);
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        
        return Math.min(case1, case2);
    }
}