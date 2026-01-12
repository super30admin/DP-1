// Time Complexity : O(amount * n) where n is number of coins
// Space Complexity : O(amount * n) where n is number of coins
// Did this code successfully run on Leetcode : No, time exceeded
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
//Bruce force - recursive solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        int res= helper(coins, amount, 0);
        if (res>=Integer.MAX_VALUE-10) {
            return -1;
        }
        return res;
    }
        private int helper(int[] coins, int amount, int idx){
            //base 
            if (amount ==0 ) return 0;
            if (idx== coins.length || amount <0 ) return Integer.MAX_VALUE - 10;
            // just so it infinity wont overflow when we add the coins addition.

            //logic
            // did not choose
            int case1 = helper (coins, amount, idx +1);
            // choose
            int case2 =1 + helper(coins, amount- coins[idx], idx);
            int res= Math.min(case1, case2);
            return res;

        }
}