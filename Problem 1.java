// https://leetcode.com/problems/coin-change/
// Time Complexity : DP: O(MN), M is the amount, and N is the number of elements in input array
// Space Complexity : DP - O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    private int INFINITY=99999;

    // Exhuastive rcursive solution
    private int helper(int[] coins, int amount, int idx, int coinsUsed){
        // base case
        if(amount<0||idx==coins.length) return Integer.MAX_VALUE;
        if(amount==0)   return coinsUsed;

        //choose coin at current index, and can be used again
        int case1=helper(coins, amount-coins[idx], idx, 1+coinsUsed);
        //do not choose coin at current index and skip
        int case2=helper(coins,amount,idx+1,coinsUsed);

        return Math.min(case1, case2);
    }

    private int dp(int[] coins, int amount){
        int m=coins.length;
        int n=amount;

        //dp array of size (m+1)*(n+1)
        int[][] storage = new int[m+1][n+1];

        // For amount 0, we need 0 coins
        storage[0][0]=0;

        // To make amount 0 from any non-zero denom we need infinite coins
        for(int i=1;i<=n;i++)   storage[0][i]=INFINITY;

        // Start building up the tree
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                // Cannot choose current denomination so picking up prev
                if(j<coins[i-1])    storage[i][j]=storage[i-1][j];
                else{
                    int case1=storage[i-1][j];  // Don't use current denomination
                    int case2=1+storage[i][j-coins[i-1]];   // Use current denomination

                    storage[i][j]=Math.min(case1, case2);
                }
            }
        }

        // Check for infinity, we cannot make amount with given denominations
        if(storage[m][n]>=INFINITY) return -1;
        return storage[m][n];
    }

    public int coinChange(int[] coins, int amount) {
        // 1. Recursive, exhaustive approach
        // int result = helper(coins, amount, 0, 0);
        // if(result==Integer.MAX_VALUE)   return -1;
        // return result;

        // 2. Bottom - up dp of above exhaustive approach
        return dp(coins, amount);
    }
}
