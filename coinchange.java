// Time Complexity : O(amount * n) where n is coins length
// Space Complexity : O(amount * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] prev_coin_store = new int[coins.length+1][amount+1];
        
        for(int i=0;i<coins.length+1;i++) {
            prev_coin_store[i][0]=0;
            for(int j=1;j<amount+1;j++) {
                if(i==0)
                    prev_coin_store[i][j]=99999;
                else {
                    int coin=coins[i-1];
                    if(j<coin) {
                        prev_coin_store[i][j]=prev_coin_store[i-1][j];                        
                    }
                    else {
                        int prev_index=j-coin;
                        prev_coin_store[i][j]=Math.min(prev_coin_store[i-1][j],prev_coin_store[i][prev_index]+1);
                    }
                }
            }
        }
        
        int result=prev_coin_store[coins.length][amount];
        return (result>=99999)?-1:result;
    }
}