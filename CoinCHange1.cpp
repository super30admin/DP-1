//TC = O(m*n) m is number of coins, n is the amount
//SC = O(m*n)

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;
        int dp[m+1][n+1];

        for(int j = 1; j <= n; j++)
        {
            dp[0][j] = amount + 1;
        }

        for(int i = 1 ; i<= m; i++)
        {
           for(int j = 1; j <= n; j++)
        { 
            if(j < coins[i-1])
            {
                dp[i][j] = dp[i-1][j];
            }
            else
            {
               dp[i][j] = min (dp[i-1][j] , 1 + dp[i][j - coins[i-1]]); 
            }
        }
        }

        if(dp[m][n] == amount + 1) return -1;

        return dp[m][n];
    }
};