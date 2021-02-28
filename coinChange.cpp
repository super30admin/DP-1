// Time Complexity: O(N*K)Where N is the amount and K is the total number of denominations;
// Space Complexity: O(N) where is the amaount
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        int rows = coins.size()+1;
        int cols = amount+1;
        int t[rows][cols];
        
        for(int i = 0; i < cols;i++)t[0][i] = INT_MAX-1;
        for(int i = 0; i< rows;i++)t[i][0] = 0;

        for(int i = 1; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(coins[i-1]<=j){
                    t[i][j]= min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[rows-1][cols-1]==INT_MAX-1 ? -1 : t[rows-1][cols-1];
    }
        
  
};