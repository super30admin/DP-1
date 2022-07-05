//TC:O(M*N)
//SC:O(M*N)
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
if(coins.size()==0||amount==0)return 0;
        
        int dummy=amount+1;
        int m=coins.size();
        int n=amount;
        vector<vector<int>>dp(m+1,vector<int>(n+1));
        
        for(int j=1;j<n+1;j++){
            dp[0][j]=amount+1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[m][n]>amount?-1:dp[m][n];
    }