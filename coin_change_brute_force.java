//Coin Change Brute Force
//Time: Exponential
//https://leetcode.com/submissions/detail/614425075/

class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int result = calculateCoins(coins, amount, 0, 0);
        
       if(result == Integer.MAX_VALUE) {
           return -1;
       }
       return result;
        
    }
    
    public int calculateCoins(int[] coins, int sum, int count, int index) {
        
        //Base conditions
        if(sum == 0) {
            return count;
        }
        
        if(sum < 0) {
            return Integer.MAX_VALUE;
        }
        
        if(index == coins.length) {
             return Integer.MAX_VALUE;
        }
        
        int taken = calculateCoins(coins, sum - coins[index], count + 1, index);
        int notTaken = calculateCoins(coins, sum, count, index + 1);
        
        
        return Math.min(taken, notTaken);
    }
}