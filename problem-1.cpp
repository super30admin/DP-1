// 322. Coin Change
// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
initializing a DP array dp with amount + 1 size, setting all elements to a large value except dp[0], which is initialized to 0. 
Then, iterates through each coin denomination, updating the dp array with the minimum number of coins needed to make up each 
amount from 1 to amount, considering the current coin. Finally, if the value at dp[amount] remains greater than or equal to the 
initialized large value, it means the amount cannot be made up using the given coins, so it returns -1; otherwise, returns 
the minimum number of coins needed stored in dp[amount].


*/

int coinChange(vector<int>& coins, int amount) {
    int m = coins.size(), n = amount;
    int dp[n+1];
    dp[0] = 0;
    for(int i = 1;i <= n;i++)
        dp[i] = 88661; // taking max as random number out of constarints beacuse taking INT_MAX as
    for(int i = 0; i < m; i++ )
    {
        for(int j = 1; j <= n; j++)
        {
            if(j < coins[i])
                continue;     
            dp[j] = min(dp[j], (dp[j-coins[i]]+1));

        }
    }
    if(dp[n]>=88661)
        return -1;
    return dp[n];

}