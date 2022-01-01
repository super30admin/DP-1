//Time complexity of this solution will be O(m*n)
// where m is the size of the given array of coins
// and n is the amount given.
// We are iterating through two loops of lenght m
// and length n

//The space complexity will be O(m*n) as we are creating
// a 2d array to store the values in it for calculation.


// Approach: We started first with the greedy approach.
//The greedy approach failed in few cases, so we tried
//exhaustive approach but the time complexity
//in that case was exponential, so we started 
// looking for subproblems.
// We created a  2d array where rows where the
// given denominations of the coins and the 
// columns were alloted to the amount.
// We started with 0 denomination that how much 
// coins does it need to get amount 0. And then
// for other amounts. We found that we need infinite
// coins of zero denomination to get other amounts except
// zero. Now we increased the index of the denominations
// and started looking for the number of coins required.
// We observed that until the amount is less than the current
// denomination we can simply copy the result of the previous
// denomination and once it is equal to the denomination, we can 
// go steps equal to the number of the denomination back and copy
// the result of the previous denomination and add 1 to it.
// Now we take the minima of the value calculated now and the 
// value for this amount without current denomination.
// So this gives us the minimum number of coins needed.


// The code ran perferctly at leetcode


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> mat(coins.size()+1, vector<int> (amount+1));
        
        mat[0][0] = 0;
        
        for(int j= 1; j < mat[0].size(); j++){
            mat[0][j] = amount + 1;
        }
        
        for(int i=1; i< mat.size(); i++){
            for( int j = 1; j < mat[0].size(); j++){
                if(j < coins[i-1]){
                    mat[i][j] = mat[i-1][j];
                } else {
                     mat[i][j] = min(mat[i-1][j], mat[i][j - coins[i-1]] +1);
                }
            }
        }
        
        int usedCoins =  mat[mat.size()-1][mat[0].size() -1];
        if(usedCoins> amount) return -1;
        return usedCoins;
        
        
        
    }
};