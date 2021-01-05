// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Brute force solution involves creating a tree which either accepts or rejects the coin in calculating the total amount, iteratively. Optimised solution includes fitting this tree into a matrix, where the current cell is populated by calculating the minimum, if the current coin is rejected or if it is accepted. The maximum number of coins used will be the bottom leftmost cell of the matrix. 

public class CoinChangeRecursion {
    public int coinChange(int[] coins, int amount) {
        if(coins == null) return -1;
        
        return calculate(coins, amount, 0, 0);
    }
    
    private int calculate(int[] coins, int amount, int index, int count){
        //base case
        if(amount == 0) return count;
        if(amount < 0 || index >= coins.length ) return -1;
        
        //recursive case
        int case1 = calculate(coins, amount - coins[index] , index, count+1);
        
        int case2 = calculate(coins, amount , index + 1, count);
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        
        return Math.min(case1, case2);
    }
}
