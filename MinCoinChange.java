// Time Complexity : O(M * N), where M = amount and N = length of coins array
// Space Complexity : O(M * N), where M = amount and N = length of coins array used as memo + O(M) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Cache to memoize result of recursive calls
    private static int[][] memo;
    public int coinChange(int[] coins, int amount) {
        // Initialize Cache
        memo = new int[amount + 1][coins.length];
       // Intialize with -ve values indicating this is not possible to solve
        for(int[] arr: memo)
        {
            Arrays.fill(arr, -1);
        }
        
        int result = helper(coins, amount, 0);

        // if result is greater than infinity, means it is not possible so return -1 otherwise result.
        return result >= (int)1e9 ? -1 : result;
    }
    
    private int helper(int[] coins, int amt, int ind)
    {
        // If Amount is 0 we dont need any coin
        if(amt == 0)
        {
            return 0;
        }
        // if we've reached the end of the array; means it is not possible to make change for this amount
        if(ind >= coins.length)
        {
            return (int)1e9;
        }
        // if we've already solved the problem for this amount at this index; return it from cache memo.
        if(memo[amt][ind] != -1)
        {
            return memo[amt][ind];
        }
        // There can be 2 ways to make change; init both of em to infiniy
        int ways1 = (int)1e9, ways2 = (int)1e9;

        // if amount is > or equal to the denominations indicated by coins at this index
        // We can take 1 coin from this index, amt reduces to amt - coins[ind]
        // as we've unlimited coins we can give call to recursion using same index and changed param
        if(amt >= coins[ind])
        {
            ways1 =  1 + helper(coins, amt - coins[ind], ind);
        }
        // Other way can be without choosing this coin going for next index
        ways2 = helper(coins, amt, ind + 1);
        // Store result in cache; ir. min value from both approaches
        memo[amt][ind] = Math.min(ways1, ways2);
        // return memo.
        return memo[amt][ind];
        
    }
}