//Time complexity: O(n*amount)
//space complexity: O(n*amount)
class Solution {
public:
//Solution 1: We can go greedy and choose biggest denomination that count towards the total amount, it will fail in certain cases

//Solution 2: Here we make decision at each coin whether to use it or not use it by making recursive calls, having base cases that fails 
//key here is to be able to identify whether to use a DP => sub problems are reapeting thats the key

//This is a good brute force way to the solution but time limit will exceed as it will go exponential
/*
    int coinChange(vector<int>& coins, int amount) {
     return recurse(coins, 0, amount, 0);
    }
    int recurse(vector<int>& coins, int index, int amount, int coinsUsed)
    {
        if(index==coins.size()|| amount<0) return -1;
        if(amount==0) return coinsUsed; 

        int case1=recurse(coins, index+1, amount, coinsUsed);
        int case2= recurse(coins, index, amount-coins[index], coinsUsed+1);

    if(case1==-1) return case2;
    if(case2==-1) return case1;
    return min(case1, case2);
    }
};
*/
//Solution 3: ""DP""
 int coinChange(vector<int>& coins, int amount) {
     //we need greed of size m*n that is denominations number of rows->coins.size()+1 htat is 0-coins.size() and amount+1 number of columns-> 0-amount
     vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1)); 
    //here we need to fill values for first row and a first column 
    
    for(int i=0;i<amount+1;++i)
        dp[0][i]=amount+1;

    for(int j=1;j<=coins.size();++j)
        dp[j][0]=0;

    for(int i=1; i<dp.size();i++)
    {
        for(int j=1; j<dp[0].size();++j)
        {
            if(j<coins[i-1])
                dp[i][j]=dp[i-1][j];
            else
                dp[i][j]=min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
        }
    }
    if(dp[coins.size()][amount]==amount+1)
        return -1;
return dp[coins.size()][amount];
    }


};