//Time Complexity - O(n * amount)
//Space Complexity - O(n * amount)
//Passed in leetcode
//Problemi faced is i am not able to memoize the recursive code of it, so i did the bottom up solution

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int dp[coins.size()+1][amount+1];
        for(int i=0;i<coins.size()+1;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<amount+1;i++){
            dp[0][i]=amount+1;
        }
        for(int i=1;i<coins.size()+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[coins.size()][amount]==amount+1)
            return -1;
        return dp[coins.size()][amount];
    }
};