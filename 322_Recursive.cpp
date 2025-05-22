class Solution {
public:

    int helper(vector<int>& coins,int index, int amount){

        if(amount == 0) return 0;
        if(index == coins.size() || amount < 0) return INT_MAX  - 10;

        int case1 = helper(coins,index+1,amount);

        int case2 = helper(coins,index,amount-coins[index]) + 1;

        return min(case1,case2);

    }

    int coinChange(vector<int>& coins, int amount) {
        int res = helper(coins, 0, amount);
        return res >= INT_MAX - 10 ? -1 : res;
    }
};

// Time Complexity -- 2^(m+n)
// Space 2^(m+n)

// This checks each and every case.
// There are cases where there is a problem that is already solved is also solved again.
// Time limit is exceeded 
