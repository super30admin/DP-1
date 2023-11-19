//  Time Complexity: O(m * n)
//  Space Complexity: O(m)
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int m = amount;
        int n = coins.length;

        int dp[] = new int[m + 1];

        // Initialize dp with infinite value or amount + 1
        for(int i=1; i<= m; i++){
            dp[i] = amount + 1;
        }

        for(int i=0; i< n; i++){
            for(int j=1; j<=m; j++){
                if(j >= coins[i]){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if(dp[m] == amount + 1) return -1;
        return dp[m];
    }
}