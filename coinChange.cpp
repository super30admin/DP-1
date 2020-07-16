//Time Complexity - O(m*n)
//Space Complexity - O(m*n)
//Runs successfuly on leetcode

class Solution {
    public:

    int coinChange(vector<int>&coins, int amount) {
        //edge
        if(coins.empty() || coins.size() == 0) return 0;
       int dp[coins.size()+1][amount+1];
       for(int i = 0; i <= coins.size(); i++)
           dp[i][0] = 0;
       for(int j = 1; j <= amount; j++)
           dp[0][j] = 99999;  
       for(int i = 1; i <= coins.size(); i++)
       {
           for(int j = 1; j <= amount; j++)
           {
               if(j < coins[i-1])
                  dp[i][j] = dp[i-1][j];
               else
                  dp[i][j] = min(dp[i-1][j],dp[i][j - coins[i-1]]+1);
           }
       }
       int result = dp[coins.size()][amount];
       if(result >= 99999) 
           return -1;
       else 
           return result;
   }

};