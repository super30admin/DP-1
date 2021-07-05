// Time Complexity : O(2^(N+M)) //2 because at each point we make 2 choices, N refers to denominations, M is amount
// Space Complexity : O(N+M) //recursive stack will depend on amount and denominations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        //base chase if array is empty
        if(coins == null || coins.length == 0)
            return -1;
        
        return helper(coins, amount, 0, 0);
        
    }
    
    //things that are changing: coins, remaining amount, all the using coins
    //when you reach leaf and amount is 0, we check if it is the min num of coins used
    private int helper(int[] coins, int amount, int index, int min){
        //base case: if amount is 0 we have a solution
        if(amount == 0)
            return min;
        //base case: if index out of bounds or amount is negative then we do not have a solution
        if(amount < 0 || index >= coins.length)
            return -1;
            
        //choose: update amount based on coin chosen, index is same because we might use it again, min increases by 1 because you chose a coin
        int case1 = helper(coins, amount- coins[index], index, min + 1);
        
        //don't choose: only index changes because you are not choosing the coin
        int case2 = helper(coins, amount, index + 1, min);
        
        if(case1 == -1) 
            return case2;
        
        if(case2 == -1)
            return case1;
        
        return Math.min(case1, case2);
    }
}