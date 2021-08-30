// Coin Change


// Time Complexity : O(n*m) 
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Minor syntax issues, solved them.


// Your code here along with comments explaining your approach

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size() == 0) return -1;
        vector<vector<int>> dp( coins.size() + 1 , vector<int> (amount+1));   // initialising coin array with size(+1 for dummy row)
        dp[0][0] = 0;  // first element in dummy row is set to 0
        for(int j = 1; j<dp[0].size(); j++)
        {
            dp[0][j] = amount+1;     // filling the remaining elements of first row                   
        }
        for(int i= 1; i<dp.size(); i++)
        {
            for(int j = 1; j<dp[0].size(); j++)
            {
                //coin not chosen
                if(j<coins[i-1]){ 
                    dp[i][j] =  dp[i-1][j]; // if coin is not chosen i.e. 0 path then the previous row value is selected
                    }
                    //coin chosen
                else{
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);   // minimum of previous solution and the selected coin
                }
            }
        }
        if(dp[dp.size() - 1][dp[0].size()-1] > amount) return -1;  
        return dp[dp.size() - 1][dp[0].size()-1];  // getting the last row and column element which gets minimum size 
    }
};


/*      RECURSIVE METHOD
class Solution {
public:


    int coinChange(vector<int>& coins, int amount) {
        if(coins.size() == 0) return -1;
        return helper(coins, amount, 0, 0);
    }
    
    int helper(vector<int> &coins, int amount, int index, int coinsUsed)
    {
        // base case
        if(amount<0 || index==coins.size()) return -1;
        if(amount == 0) return coinsUsed;
        
        // logic
        // considering coin
        int case1 = helper(coins, amount-coins[index], index, coinsUsed + 1);    
        // not considering coin
        int case2 = helper(coins, amount, index+1, coinsUsed);
        if(case1 == -1 ) return case2;
        if(case2 == -1) return case1;
        
        return min(case1, case2);

      
    };
  */

// int main(){
    
//     return 0;
// }