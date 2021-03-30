// Time Complexity : O(mn), where m = length of coins array and n is amount
// Space Complexity : O(n) where n is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0) return 0;
        int[] t = new int[amount+1];
        Arrays.fill(t,amount+1);
        
        t[0] = 0;
        
        for(int i=1; i<t.length;i++){
            for(int j=0; j < coins.length; j++){
                if(coins[j] <= i){
                    t[i] = Math.min(1+ t[i - coins[j]], t[i]);
                }
            }
        }
        
        
        return t[t.length-1] == amount + 1 ? -1 : t[t.length-1];
        
    }
}