// To solve this problem we need to use Dynamic Program approach. Our objective here is to minimize the number of coins, this is also the optimal substructure for this problem. 
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size()+1;
        int n = amount+1;
        int dp[m][n];
        
        // Initialize Columns
        for(int i=1; i<n;i++){
            dp[0][i] = 99999;
        }
        
        // Initialize Columns
        for(int j=0; j<m; j++){
            dp[j][0] = 0;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                
                 dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]]+1);}
            }
        }
        
        if(dp[m-1][n-1] == 99999){
            return -1;
        }
        
        return dp[m-1][n-1];
    }
};

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
