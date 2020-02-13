// Time Complexity : O(2^(M+N))?? for brute-force and O(MN) for dp where M is amount and N is coin array length 
// Space Complexity : O(M+N) recursive call stack space and O(NM) auxilliary space for dp
// Did this code successfully run on Leetcode : TLE for brute-force and successful for dp
// Any problem you faced while coding this : Not sure if the time complexity for brute-force approach is right.


// ============= BRUTE FORCE - TIME LIMIT EXCEEDED =============

/*
Algorithm:
==========
1. Generate the binary tree of all possible cases of picking and not picking every coin at every level
2. Pick the minimum of picking and not picking in every scenario
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        return helper(coins, amount, 0, 0);
    }
    
    private int helper(int[] coins, int amount, int index, int min) {
        if( amount < 0 || index >= coins.length) return -1;
        if( amount == 0 ) return min;  
        
        //coin picked, update amount and min
        int picked = helper(coins, amount - coins[index], index, min + 1);

        //coin not picked, update index
        int notPicked = helper(coins, amount, index+1, min);
        
        if(picked == -1) return notPicked;
        if(notPicked == -1) return picked;
        
        return Math.min( picked, notPicked);
    }
}

// ========================== DP =========================================

/*
Algorithm:
==========
1. Update minimum change matrix based on set of conditions:
 i. If column index less than coin value, update it with its above value in matrix
 ii. Else, update the value with minimum of above value and minChange[i][j-d] where d is current denomination being considered
2. If number of coins in the end greater than amount, implies it is impossible case. So, return -1, else return minChange
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        
        // create denomination matrix
        int[][] minChange = new int[coins.length + 1][amount + 1];
        
        // update first column with 0's for denomination 0
        for(int j = 0; j <= coins.length; j++) 
            minChange[j][0] = 0;
        
        // update matrix for denomination 0
        for(int j = 1; j <= amount; j++) 
            minChange[0][j] = amount + 1;
        
        
        for(int i = 1; i < minChange.length; i++) {
            for(int j = 1; j < minChange[0].length; j++) {
                if(j < coins[i-1]) {
                    minChange[i][j] = minChange[i-1][j];
                }
                else {
                    minChange[i][j] = Math.min(minChange[i-1][j],minChange[i][j - coins[i-1]]+1);
                }
            }
        }
        int result = minChange[minChange.length-1][minChange[0].length-1];
        
        if(result == amount+1) return -1;
        return result ;
    }
}