// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] matrix = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;++i) matrix[i][0] = 0;
        for(int target=1;target<amount+1;target++) matrix[0][target] = 9999;
        for(int i=1;i<coins.length+1;i++)
            for(int target = 1;target<amount+1;target++)
            {   
                if((target-coins[i-1])<0) matrix[i][target] = matrix[i-1][target];
                else
                {
                    matrix[i][target] = Math.min(matrix[i-1][target],(matrix[i][target-coins[i-1]])+1);
                }
            }
        if(matrix[coins.length][amount]>=9999) return -1;
        return matrix[coins.length][amount];
    }
}