class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.empty() || coins.size() == 0){
            return -1;
        }
        return helper(coins, amount, 0, 0);
    }
    
    int helper(vector<int>& coins, int amount, int index, int minCoins){
        if(amount == 0){
            return minCoins;
        }
        if(index >= coins.size() || amount < 0){
            return -1;
        }
        
        //dont choose
        int case1 = helper(coins, amount, index+1, minCoins);
        //choose
        int case2 = helper(coins, amount - coins[index], index, minCoins+1);
        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return min(case1, case2);
    }
};
