// Brute Force Solution
// Time Complexity - O(S^n)
// Space Complexity - O(n^2)
// This Solution did not work Successfully on Leetcode because it is not an optimized solution and the time limit exceeded.


class Solution {
    public int coinChange(int[] coins, int amount) {
        int min =0;
        return(helper(coins,0,min,amount));
    }
    private int helper(int[] coins,int i,int min,int amount){
        // Base Case
        if(amount==0)   return min;                         // if the amount is 0 , minimum denomination has been found
        if(amount <0 || i>=coins.length || min>99999)    return -1;     // Denomination cannot be found for any of these conditions
        //Recursion Logic  
        int Case1 = helper(coins,i,min+1,amount-coins[i]);  // When the denomination is chosen
        int Case2 = helper(coins,i+1,min,amount);           // When the denomination is not chosen
        if(Case1 ==-1)  return Case2;
        else if(Case2 ==-1) return Case1;
        else return Math.min(Case1,Case2);              // return the min value of coins between both the cases
        //return min;
    }
}

// Dynamic Programming
