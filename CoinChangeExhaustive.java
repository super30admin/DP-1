// Time Complexity : O(2 pow (m + n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }
    
    public int helper(int[] coins,int amount,int index, int min){
        //base case
        if(amount == 0)
            return min;
        if(amount < 0 || index > coins.length - 1)
            return -1;
        
        //do not consider the coin
        int case1 = helper(coins,amount,index + 1,min);
        
        //consider the coin
        int case2 = helper(coins,amount - coins[index],index,min + 1);
        
        if(case1 == -1)
            return case2;
        else if(case2 == -1)
            return case1;
        //return minimum of the two cases
        return Math.min(case1,case2);
    }
}