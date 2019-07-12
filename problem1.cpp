// Time Complexity : O(n) --> need to iterate through the entire array once
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No problem. 


// Your code here along with comments explaining your approach

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        int dp[coins.size()+1][amount+1];

        for(int i = 0; i<=coins.size(); i++)
        {
            dp[i][0] = 0;
        }

        for(int j = 1; j<=amount; j++)
        {
            dp[0][j] = 9999;
        }

        for(int i = 1; i<coins.size() + 1; i++ )
            for(int j = 1; j<amount+1; j++)
            {
                if(j <coins[i - 1])
                    dp[i][j] = dp[i -1][j];
                else
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
            }

            int result = dp[coins.size()][amount];

            if(result >= 9999)
                return -1;
            else
                return result;
    }
};