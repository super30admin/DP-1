class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
      int m = coins.size();
      int n= amount;
      vector<vector<int>> dp(m+1,vector<int>(n+1));
      dp[0][0] = 0;
          for(int j =1; j<=n;j++){
                  dp[0][j]=1e9;
          }
      for(int i =1; i<=m;i++ ){
          for(int j =0; j<=n;j++){
              if(coins[i-1]>j){
                  dp[i][j]=dp[i-1][j];
              }
              else{
                  dp[i][j]= min(dp[i-1][j],dp[i][j-coins[i-1]]+1 );
              }
          }
      } 
       if(dp[m][n] == 1e9){return -1;}
       else return dp[m][n];
    }
};