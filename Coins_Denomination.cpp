// Time Complexity :O(n*size_of_coins)
// Space Complexity : O(n*size_of_coins)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Beginnning of DP... Building the idea is hard as this point..


// Here we used a DP approach to solve the problem.
// Forming a 2D matrix with coints vs amount.
// when checking for min number of coins for a particular amount we can check the value for 
// amount - coin value as we will then have a single definitive case which we can add to it.
// 
// We will check  for the min value because addinng new denomination might increse the coins alse..
// so we will check for min value between , withour the coin denomination and with that coin ( 1 + val for [amount - coin])

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int> > mytable(coins.size()+1,vector<int> (amount+1, 0));
        
        
        for (int k =0; k< coins.size()+1; k++){
                mytable[k][0] = 0;
            }
            for (int k =1; k< amount+1; k++){
                mytable[0][k] = 9999;
            }
        for (int i =1; i < coins.size()+1; i++){
            for ( int j = 1; j < amount+1; j++){
               if (j < coins[i-1]){
                   mytable[i][j] = mytable[i-1][j];
               } 
                else {
                    mytable[i][j] =  min(mytable[i-1][j] , 1+ mytable[i][j-coins[i-1]]);
                }
            }
            
            
        }
        return (mytable[coins.size()][amount] >= 9999) ? -1: mytable[coins.size()][amount] ;
    }
};