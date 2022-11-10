//Approach 1

// Time Complexity : O(S^n) where S is the amount and n is the number of coins
// Space Complexity : O(n) max depth of recursion is n
// Did this code successfully run on Leetcode : No - Time Limit Exceeded
// Any problem you faced while coding this : Coming up with the recursive intuition 

/*
Recursive function to calculate the coins used for every combinatin of coins selected 
This is going to be an exhaustive search 
*/

class Solution {
private:
    int helper(vector<int> coins, int amount, int index, int coinCounter){
        //recursion break cases
        // (1) We reached the end of the array - i.e there are no elements left
        // (2) The amount became -ve 
        // (3) The solution i.e amount = 0
        if(index == coins.size() || amount < 0)
            return -1;
        else if(amount == 0)
            return coinCounter;

        //you don't select it
        //we will move on to the next index and the rest remain the same since we have not selected the coin 
        int case1 = helper(coins, amount, index+1, coinCounter);

        //you select it
        //amount reduces by that coin and index remains the same (assuming we have infinite supp;y of the coins)
        //we picked a coin, thus counter increases 
        int case2 = helper(coins, amount-coins[index], index, coinCounter+1);

        //if we hit the break case
        if(case1 == -1)
            return case2;
        if (case2 == -1)
            return case1;


        //separate for -1 as that would have been selected at this point 
        return ((case1<case2)? case1 : case2);
    }
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size() == 0)
            return -1;

        return helper(coins, amount, 0, 0);
    }
};


//Approach 2

// Time Complexity : O(mn) where m is the number of coins available and n is the amount
// Space Complexity : O(mn) max depth of recursion is n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with the intuition for dp

/*
Dynamic programming 
We see that there are repeated sub-problems in the recursion tree
We calculate that only once and use the precomputed answers to update the current value 


dp array: 
rows denote the array or the coins we have chosen and the columns represent the amount we are trying to make from it 

   0 1 2 3 4 5 6 7 8 9 10 11
0  0 ∞ ∞ ∞ ∞ ∞ ∞ ∞ ∞ ∞ ∞  ∞
1  0 x y 
2  0 a b c
5  0           l m 

x: we are selecting [1] to make amount = 1 
= [1] amt 0 + 1
= 1

y: [1] to make amount = 2
= [1] amt 1 + 1
= 2

a: [1,2] to make amount = 1
i) we pick 2 in which case amount becomes negative 
ii) we don't pick, so we just copy over the [1] amt 1 

b:  [1,2] to make amount = 2
answer is min of the following
i) we pick 2 in which case amount becomes 0 and answer is([1,2] amt 0 + 1)
ii) we don't pick, so we just copy over the ([1] amt 0)

c: [1,2] amount = 3
answer is min of the following
i) we pick 2 in which case amount becomes 1 and answer is([1,2] amt 1 + 1)
ii) we don't pick, so we just copy over the ([1] amt 1)


l: [1,2,5] amt = 6
min of 
i) pick 5 => [1,2,5] amt 1 + 1 = 1 + 1 = 2
ii) no 5  => [1,2] amt 6 = 3

m: [1,2,5] amt = 7
min of
i) pick 5 => [1,2,5] amt 2 + 1 
ii) no 5  => [1,2] amt 7


*/

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        //edge case
        if(coins.size() == 0)
            return -1;
        //creating 2d dp
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1));
        
        //initialising my top row with amount + 1 so we don't hit int overflow if there is a INT_MAX + 1
        for(int i=1; i<amount+1; i++)
            dp[0][i] = amount+1; 
        

        for(int i=1; i<(coins.size()+1); i++)
            for(int j=1; j<amount+1; j++){
                //if the amount becomes -ve after picking a coin, we only have 1 choice and that is to not pick it 
                if((j-coins[i-1]) < 0)
                    dp[i][j] = dp[i-1][j];

                //we take a min of picking it, reducing the amount by coin value or the value by not picking it
                else
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
            }

        //if it's more than amount which is in our case = infinity, no solution exists
        if(dp[coins.size()][amount] > amount)
            return -1;
        return dp[coins.size()][amount];
    }
};


