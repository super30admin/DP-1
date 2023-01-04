//TC : O(N2)
//sc: o(N)
class Solution {
public:
    vector<int>dp;
    int coinChange(vector<int>& coins, int amount) {
        if(amount<1){return 0;}
        int n = coins.size();
        dp.resize(amount,0);
        return coinChangeMemo(coins,amount,n);
    }
    int coinChangeMemo(vector<int>& coins,int amount,int n){
       if(amount==0){
           return 0;
       }
        if(amount<0){
            return -1;
        }
        if(dp[amount-1]!=0){
            return dp[amount-1];
        }
        int min_coins = INT_MAX;
        for(auto coin:coins){
            int res = coinChangeMemo(coins,amount-coin,n);
            if(res>=0 && res<min_coins){
                min_coins = res+1;
            }
        }
        dp[amount-1] = (min_coins==INT_MAX)? -1:min_coins;
    return dp[amount-1];
    }
};
