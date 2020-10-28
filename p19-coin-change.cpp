// Time complexity is O(rows*columns) - rows = size of coins array + 1; columns = amount + 1
// Space complexity is O(rows*columns)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:
/*
    1. 'res' 2-D array is created. We store the minimum number of coins to reach that amount(column) in each cell.
    2. Zeroth row is filled with amount+1 (any number bigger than amount will work).
    3. When the column value(amount) is less than a particular coin denomination,
    we use the minimum number of coins to reach that amount using previous coin denominations.
 */

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size() == 0) return 0;
        int rows = coins.size()+1;
        int columns = amount+1;
        vector<vector<int>> res(rows,vector<int>(columns, 0));
        
        /* When amount = 0, minimum #coins to reach this amount is always zero.
         So, when column = 0, grid values are zeros.
         */
        
        /*
           Assigning a bigger value than amount to zeroth row
           which represents zero coin denomination.
           Make sure it doesn't overflow when something is added to it
        */
        for(int i = 0; i < columns; i++) {
            res[0][i] = amount+1;
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j <= columns-1; j++) {
                /*
                When the column value(amount) is less than a particular coin denomination,
                we use the minimum number of coins to reach that amount using previous coin denominations.
                 */
                if(j < coins[i-1])
                    res[i][j] = res[i-1][j];
                else
                    res[i][j] = min(res[i-1][j], 1+res[i][j-coins[i-1]]);
            }
        }
        // if the last element at the right bottom corner of the grid is 'amount+1', it implies there is no solution, so return -1
        // else return the value stored at last element at the right bottom corner of the grid
        return (res[rows-1][columns-1] == amount+1) ? -1 : res[rows-1][columns-1];
    }
};

// Recursive solution
// Time complexity is O(m*2^(n)) m - amount n - #coin denominations
// Space complexity is ??
 class Solution {
 public:
     int recursiveFn(vector<int> coins, int index, int amount, int minimum) {
         
         if(amount == 0) return minimum;
         if(amount < 0 || index == coins.size()) return -1;
         
         int value1 = recursiveFn(coins, index, amount-coins[index], minimum+1);
         int value2 = recursiveFn(coins, index+1, amount, minimum);
         
         if(value1 == -1)
             return value2;
         if(value2 == -1)
             return value1;
         return min(value1, value2);
     }
     int coinChange(vector<int>& coins, int amount) {
         return recursiveFn(coins, 0, amount, 0);
     }
 };
 
