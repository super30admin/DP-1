// Coin_Change.cpp : This file contains the 'main' function. Program execution begins and ends there.
/*
DP Bottom Up approach
Time Complexity - O(N*M) N is amount and M is number of coins
Space complexity - O(N)

*/
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        //sort(coins.begin(),coins.end());
        //fill array with maximim amount +1;
        vector<int> dp(amount + 1, amount + 1);
        dp[0] = 0;//for 0 amount we require zero denominations
        //iterate through 1 to amount and compute minimum denomiantions for each amount.
        for (int i = 1;i <= amount;i++) {
            for (int j = 0;j < coins.size();j++) {
                if (coins[j] <= i)
                {
                    /*if we are choosing this coin what is the remaining amount (i-coins[j]) and the minimum number of coins required for the remaining amount dp[i-coins[j]]. since we are choosing this coin add 1 and compare this with previous number of coins (dp[i]). select the minimum among them)*/
                    dp[i] = min(dp[i], 1 + dp[i - coins[j]]);
                }
                // else break;   //if we are sorting then we can break here.
            }
        }
        if (dp[amount] >= amount + 1)
            return -1;
        else return dp[amount];
    }
};
int main()
{
    std::cout << "Hello World!\n";
}
