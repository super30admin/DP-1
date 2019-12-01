class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
      return helper(coins, 0, amount, 0);

    }

    int helper(vector<int>& coins,int i, int amount, int min){
        //base case
        if (i > coins.size() -1 || amount < 0) return -1;
        if (amount == 0 ) return min;

    //case 1: choosing a coin
    int case1 = helper(coins, i, amount - coins[i], min + 1 );

    //case 2: not chossing a coin
    int case2 = helper(coins, i + 1, amount, min );

    if(case1 == -1) return case2;
    else if(case2 == -1) return case1;
    else return std::min(case1, case2);
    }
};

//Leetcode: time limit exceeded
//Time Complexity: O(amount^n)
//Space Complexity: O(n)
