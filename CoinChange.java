// Time Complexity: O(A*C) where, A is the amount, and K is the number of coins.
// Space Complexity: O(A)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Learning Dynamic Programming.. haha


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        Integer[] result = new Integer[amount+1];
        result[0] = 0;
        for(int i = 1 ; i <= amount; i++){
            int minCoins = amount+1;
            for(Integer chosenCoin: coins){
                int minSubProblem = i-chosenCoin;
                if(minSubProblem < 0) {
                    continue;
                }
                if(result[minSubProblem] != null){
                    int newMin = result[minSubProblem]+1;
                    if(minCoins > newMin){
                        minCoins = newMin;
                    }
                }
            }
            result[i] = minCoins;
        }
        
        int answer = result[result.length-1];
        if(answer > amount) return -1;
        return result[result.length-1];
    }
}