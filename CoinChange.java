/**

Recursive Approach(Top Down) without Memoization
TC - O(m*n) where m is the number of coins. and n is the total amount. So total m*n unique problems can be found.
SC - O(m*n) where m is the number of coins. and n is the total amount. This space is being used for memoization.

Dynamic programming 

- overlapping subproblems
- Optimal substructure.
- precompute subproblems into some storage.


- Top Down
    -start with the original problem and break it down to subproblems and solve those to solve original problem.
    - Figure out the recursion and add memoization into it.
    - In recursion, space is being used automatically. 

- Bottom Up
    - starts with the base case and iterate over the problem to reach to the end goal.
    - Iterative approach.
    - In iterative, we have control over space.
    
    [1,2,5]  amount = 11
**/
class Solution {
    
    int dp[][];
    
    public int coinChange(int[] coins, int amount) {
        
         dp = new int[coins.length][amount+1];
        
        int ans = coinChangeHelper(coins, amount, 0);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int coinChangeHelper(int coins[], int amount, int index)
    {
        // base conditions
        if (amount == 0)
        {
            return 0;
        }
        
        if (amount < 0 || index == coins.length)
        {
            return Integer.MAX_VALUE;
        }
        
        if (dp[index][amount] > 0)
        {
            return dp[index][amount];
        }
        
        int chooseTheIndex = coinChangeHelper(coins, amount - coins[index], index);
        int notChooseTheIndex = coinChangeHelper(coins, amount, index + 1);
        
        if (chooseTheIndex != Integer.MAX_VALUE)
        {
            chooseTheIndex += 1;
        }
        
        int min = Math.min(chooseTheIndex, notChooseTheIndex);
        
        dp[index][amount] = min;
        
        return min;
    }
}