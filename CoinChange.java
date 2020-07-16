// Time Complexity : O(n*k) n = 1 to amount k=number of coins.
// Space Complexity : O(n) memorization array for n+1 elems
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  // yes dp problem

// Your code here along with comments explaining your approach
  //create a memorization array, that stores the number of ways we can get amount.
  //using bottom up approch cal the lowest amount and walk towards the amount
  //we want.
  // O(n*k) because , for each amount we are going over all coins.
  
class Solution {
    public int coinChange(int[] coins, int amount) {
        int ways[] = new int[amount+1];
        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;
        for(int i = 1 ; i < ways.length; i++){
            for(int coin: coins){
                if(coin > i)
                    continue;
                ways[i] = Math.min(ways[i], ways[i-coin] == Integer.MAX_VALUE? Integer.MAX_VALUE: ways[i-coin]+1);
            }
        }
        if(ways[amount] == Integer.MAX_VALUE)
            return -1;
        return ways[amount];
    }
}
