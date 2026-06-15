class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        //TC: O(m*n)
        //SC: O(m*n)
       vector<vector<int>> dp(coins.size()+1,vector<int>(amount+1));
       if(coins.size()==0)
            return -1;

        for(int i=0;i<amount+1;i++)
        {
            dp[0][i]=amount+1;
        }
        for(int j=1;j<=coins.size();++j)
            dp[j][0]=0;

        for(int i=1;i<dp.size();i++)
        {
            for(int j=1; j<dp[0].size();j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[coins.size()][amount]==amount+1)
            return -1;
        return dp[coins.size()][amount];


   
       //exhaustive method:
     /*  return recurse(coins, 0, amount, 0);
    }

    int recurse(vector<int>& coins, int index, int amount, int coinsUsed)
    {
        if(index==coins.size()|| amount<0) return -1;
        if(amount==0) return coinsUsed; 

         int case2= recurse(coins, index, amount-coins[index], coinsUsed+1);
        int case1=recurse(coins, index+1, amount, coinsUsed);
       

    if(case1==-1) return case2;
    if(case2==-1) return case1;
    return min(case1, case2);
    }*/


    }
};


