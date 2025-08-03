class Solution {
public:
    int coinChange(vector<int>& coins, int amount) { //exhaustive method (trying all possibilities )
        int cu=helper(coins,0,amount,0);
        return cu==INT_MAX?-1:cu;
        
    }
private:
     int helper(vector<int>& coins,int i,int amount,int coinused)
     {
        if(amount<0||i==coins.size())return INT_MAX;
        if(amount ==0)return coinused;

        int case0 = helper(coins,i+1,amount,coinused);
        int case1 = helper(coins,i,amount-coins[i],coinused+1);

        return min(case0,case1);
     }
};

/************dp: 2D matrix since there is 2 constraints one is coins and another one is amount ********/
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) { 
        int m = coins.size();
        int n = amount;
        vector<vector<int>>dp(m+1,vector<int>(n+1,0));
        for(int j =1;j<=amount;j++)
        dp[0][j]=99999;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(j<coins[i-1])
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
        return dp[m][n] ==99999?-1:dp[m][n];
     }
};
/********at any point of time will be needing only one row so use 1d array  */
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) { 
        vector<int>dp(amount+1,99999);
        dp[0]=0;
        for(int coin:coins)
        {
            for(int j=coin;j<=amount;j++)
            dp[j]=min(dp[j],1+dp[j-coin]);
        }
        return dp[amount]==99999?-1:dp[amount];
    }
};