//Time Complexity - O(2^(mn))
//Space Complexity - O(number of coins)
//Timed out

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
         if(coins.size()==0)
            return -1;
        return helper(coins,amount,0,0);
    }
    int helper(vector<int>& coins,int amount,int i,int count)
    {
        if(amount==0)
            return count;
        if(amount<0 || i==coins.size())
              return -1;
        int case1=helper(coins,amount-coins[i],i,count+1);
        int case2=helper(coins,amount,i+1,count);
        if(case1==-1)
            return case2;
        else if(case2==-1)
            return case1;
        return min(case1,case2);
    }
};

//Time Complexity - O(mn)
//Space Complexity - O(mn)
//Ran successfuly on leetcode

class Solution {
    public:

    int coinChange(vector<int>&coins, int amount) {

       int dp[coins.size()+1][amount+1];
       for(int i = 0; i <= coins.size(); i++)
           dp[i][0] = 0;
       for(int j = 1; j <= amount; j++)
           dp[0][j] = 99999;   //Integer.MAX_VALUE
       for(int i = 1; i <= coins.size(); i++)
       {
           for(int j = 1; j <= amount; j++)
           {
               if(j < coins[i-1])
                  dp[i][j] = dp[i-1][j];
               else
                  dp[i][j] = min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
           }
       }
       int result = dp[coins.size()][amount];
       if(result >= 99999) return -1;
       else return result;
   }

};