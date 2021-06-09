// Time Complexity : O(n^2)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.empty())
            return 0;
        
        //vector<vector<int>> dp(coins.size() + 1 , vector<int> (amount + 1));
        int row = coins.size() + 1;
        int col = amount + 1;
        int dp[row][col];
        
        for(int i = 0; i < row; i++){
            dp[i][0] = 0;   // filling first columns of all rows as zero
        }
        
        for(int j = 1; j < col; j++){
            dp[0][j] = amount + 1;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = std::min(dp[i - 1][j],  1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

    int result = dp[row - 1][col - 1];
    if(result > amount) return -1;
    return result;
    }
};