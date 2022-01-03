class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        auto result = helper(coins, amount, 0, 0);
        if(result == INT_MAX) return -1;
        return result;
    }

    int helper(vector<int>& coins, int amount, int index, int coinsUsed){
        
        // base
        if(amount == 0){
            return coinsUsed;
        }
        
        if(amount<0 || index == coins.size()){
            return INT_MAX;
        }
        //case 1 take
        
        int case1 = helper(coins, amount - coins[index], index, coinsUsed + 1);
        
        //case 2 dont take
        int case2 = helper(coins, amount, index + 1, coinsUsed);
        
        return min(case1, case2);
        
        
    }
};
