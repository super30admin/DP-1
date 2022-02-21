// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] arr = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            for(int j=0;j<amount+1;j++){
                if(i == 0){
                    if(j==0){
                        arr[i][j] = 0;
                    }
                    else{
                        arr[i][j] = 10001;
                    }
                }
                else{
                    if(coins[i-1]<=j){
                        arr[i][j] = Math.min(arr[i-1][j],arr[i][j-coins[i-1]]+1);
                    }
                    else{
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }
        if(arr[coins.length][amount]==10001){
            return -1;
        }
        return arr[coins.length][amount];
    }
}