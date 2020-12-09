// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size()==0){
            return 0;
        }
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1));
        int m = dp.size();
        int n = dp[0].size();
        for(int i=1;i<n;i++){
            dp[0][i]=amount+1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m-1][n-1]==amount+1){
            return -1;
        }
        return dp[m-1][n-1];
    }
};
