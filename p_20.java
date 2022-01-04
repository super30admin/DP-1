// Time Complexity :o(2^(n,m))
// Space Complexity :o(m+n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
   
    public int coinChange(int[] coins, int amount) {
        //null
        if(coins == null) return min;        
        return helper(amount,coins,0,0);
    }
    private int helper(int amount,int [] coins,int index,int coinUsed){
        //base or terminating condition
        if(amount == 0){
            return coinUsed;
        }
        if(amount < 0 || index == coins.length)
        {
            return -1;
        }
        

        //logic
        //choose
        int case1 = helper(amount - coins[index], coins, index, coinUsed + 1);
        //not choose
        int case2 = helper(amount, coins, index + 1, coinUsed);
        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return Math.min(case1, case2);
    }
}