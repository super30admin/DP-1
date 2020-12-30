// Time Complexity : O(amount * coins length)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Either pick a coin or not, search for min in all possible solution. 2^n computaions.
// Memoization to reduce the complexity. If aleady calculated for a mounr, use that.

//Top Down
public int coinChange(int[] coins, int amount) {
    return helper(coins, amount, new int[amount]);
}

public int helper(int[] coins, int amount, int[] count){
    if(amount < 0) return -1;
    if(amount == 0) return 0;
    if(count[amount-1] != 0 ) return count[amount-1];
    int min = Integer.MAX_VALUE;
    for(int coin : coins){
        int a = helper(coins,amount-coin,count) + 1;
        if(a>0 && a<min){
            min = a;
        }
    }
    if(min == Integer.MAX_VALUE)            
        count[amount-1] = -1;
    else count[amount-1] = min;
    return count[amount - 1];
}

// Time Complexity : O(amount * coins length)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can get to an amount by picking a coin. 
// number pof coins required will be number of used for amount minus coin value plus 1. 
// try all coins, pick minumum, store in array. 

//Bottom Up
public int coinChange(int[] coins, int amount) {
    int[] count = new int[amount+1];
    for(int i = 1; i<= amount; i++){
        count[i] = Integer.MAX_VALUE-1;
    }
    for(int i = 1; i<= amount; i++){
        for(int j = 0; j< coins.length;j++){
            if(coins[j]<=i){
                count[i] = Math.min(count[i], count[i-coins[j]]+1);
            }
        }
    }
    return count[amount] == Integer.MAX_VALUE-1? -1 : count[amount];
}