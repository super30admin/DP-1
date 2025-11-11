class Solution {
    int[][] memo;

    public int coinChange(int[] coins, int amount) {
       
        int m = coins.length;
        int n = amount;
        this.memo = new int[m+1][n+1];

        int re = helper(coins, 0, amount);

        if(re == 99999) return -1;
        return re;
    }

    private int helper(int[] coins, int i, int amount){
        
        if(amount < 0 || i == coins.length) return 99999;

        if(amount == 0) return 0;

        if(memo[i][amount] != 0 ) return memo[i][amount];

        int case0 = helper(coins, i+1, amount);
        int case1 = 1 + helper(coins, i, amount - coins[i]);
      
        memo[i][amount] = Math.min(case0, case1);
        
        return Math.min(case0, case1);
    }
}

Time Complexity : O(m*n)
Space Complexity : O(m*n)