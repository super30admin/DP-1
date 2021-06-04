class Solution {
    // Time Complexity: O(m * n), m indicates the required amount, 
    // n indicates the coin denominations.
    // Space Complexit: O(m)
    public int coinChange(int[] coins, int amount) {
        int[][] f = new int[coins.length + 1][amount + 1];
        for(int[] a: f) Arrays.fill(a, Integer.MAX_VALUE);
        // fill the first column
        for(int i = 0; i <= coins.length; i++){
            f[i][0] = 0;
        }
        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                f[i][j] = f[i - 1][j];
                if(j >= coins[i - 1]){
                    if(f[i][j - coins[i - 1]] != Integer.MAX_VALUE)
                        f[i][j] = Math.min(f[i][j], f[i][j - coins[i - 1]] + 1);
                }
                    
            }
        }
        return f[coins.length][amount] == Integer.MAX_VALUE ? -1 : f[coins.length][amount];
    }
}