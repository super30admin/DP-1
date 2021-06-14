//this is a DP approach for coin change
//Time complexity : O(n^2)
//space complexity : O(1)
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
      int n=coins.size();
        vector<vector<int>> dp(n+1,vector<int>(amount+1,INT_MAX));
        
        for(int i=0;i<coins.size()+1;i++)
        {
            dp[i][0]=0;
        }
        
        for(int j=1;j<amount+1;j++)
        {
            dp[0][j]=amount+1;
        }
        
        for(int row=1; row<dp.size();row++)
        {
            for(int col=1;col<dp[0].size();col++)
            {
                if(col<coins[row-1])
                {
                    dp[row][col]=dp[row-1][col];
                }
                else
                {
                    dp[row][col]= std::min (dp[row-1][col], 1+dp[row][col-coins[row-1]]);
                }
            }
        }
        int res=dp[dp.size()-1][dp[0].size()-1];
        if(res>amount) return -1;
       
        return res ;
        
    }
};
