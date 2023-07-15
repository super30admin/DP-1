// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) { 

        int m = coins.size();
        int n = amount;

        vector<vector<int>> dp(m+1,vector<int> (n+1));

        dp[0][0]=0;

        for(int j=1;j<=amount;j++){
            dp[0][j]=999999;
        }

        for(int i=1;i<=m;i++){

            for(int j=1;j<=n;j++){


                //edge case for invalid/no choose
            
                if(j<coins[i-1]){

                    dp[i][j]=dp[i-1][j];

                }
                else{
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]]);

                }

            }
            
        }

        if(dp[m][n]>=999999){
            return -1;
        }
        return dp[m][n];





        
        
    }

    
};