//322. Coin Change

/*
Greedy doesn't work, with exhaustive method we get TLE
DP: Take minimum between above value and current denomination steps behind.
Time Complexity: O(number of coins * amount)
Space Complexity: O(number of coins * amount) = O(1)
*/

class Solution {
public:

    /*
    int helper(vector<int>& coins, int idx, int amount, int coinsUsed){

        //base case
        if(amount<0 || coins.size() == idx) return INT_MAX;
        if(amount == 0) return coinsUsed;

        //logic
        //when coin choosen
        int case1 = helper(coins,idx, amount-coins[idx], coinsUsed+1);
        //not choosen
        int case2 = helper(coins,idx+1, amount, coinsUsed);

        return min(case1, case2);
    }
    */
    int coinChange(vector<int>& coins, int amount) {
        
        /*
        //exhaustive search
        int ret = helper(coins, 0, amount, 0);
        if(ret == INT_MAX) return -1;
        return ret;
        */

        /*
        //tabulization - bottom up
        int m = coins.size(), n = amount;
        vector<vector<int>> dp(m+1,vector<int>(n+1));

        for(int i=0;i<=n;i++) dp[0][i] = 99999;
        //fill(dp[0], INT_MAX);
        dp[0][0] = 0;
        //because we filled 0 row above, start from next denomination
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                //till the amount is less than denomination of current deno
                if(j<coins[i-1])
                dp[i][j]=dp[i-1][j]; //just fill from the row above
                else
                //go back current denomination steps back
                dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }

        int ret = dp[m][n];
        if(ret >= 99999) return -1;
        return ret;
        */


        //tabulization - optimized - 1D array
        int m = coins.size(), n = amount;
        vector<int> dp(n+1);

        for(int i=0;i<=n;i++) dp[i] = 99999;
        //fill(dp[0], INT_MAX);
        dp[0] = 0;
        //because we filled 0 row above, start from next denomination
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                //till the amount is less than denomination of current deno
                if(j<coins[i-1])
                dp[j]=dp[j]; //just fill from the row above
                else
                //go back current denomination steps back
                dp[j] = min(dp[j], 1+dp[j-coins[i-1]]);
            }
        }

        int ret = dp[n];
        if(ret >= 99999) return -1;
        return ret;
    }


};