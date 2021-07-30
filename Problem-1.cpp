//Time Complexity = O(M*N)
//Space Complexity = O(M*N)
//Where M is the amount and N is the length of the vector coins.
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int dp[coins.size()+1][amount+1],i,j;
        for(i=0;i<=amount;i++)
            dp[0][i]=amount+1;                  //this value depicts infinity. since its not possible to have coins more than amount.                                                  than amount.
        for(i=0;i<=coins.size();i++)            //Assigning the first coloumn(coloumn with amount 0) to 0.
            dp[i][0]=0;
        
        for(i=1;i<=coins.size();i++)
            for(j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
            }
        if(dp[coins.size()][amount]==amount+1)
            return -1;
        return dp[coins.size()][amount];
    }
};
