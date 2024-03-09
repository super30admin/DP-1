// Time Complexity : O(n * m)  
//                   ...  n is number of different types of coins
//                   ...  m is amount
// Space Complexity :  O(n * m)                     
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and 
an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
*/


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int size = coins.size();
        if(size == 0) return -1;
        
        int n = coins.size()+1;
        int m = amount+1;

        vector<vector<int>>arr (n, vector<int>(m, 0));
        for (int i = 0; i < m; i++){
            arr[0][i] = amount+1;
        }

        for(int i = 1; i < n; i++){
            int coin = coins[i-1];
            for(int j = 1; j < m; j++){
                if (j < coin){
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = std::min(arr[i-1][j], arr[i][j-coin] + 1);
                }
            }
        }
        if(arr[n-1][m-1] >= amount+1) return -1;
        return arr[n-1][m-1];

    }
};