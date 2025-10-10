// Time Complexity : O(m*n), where m and n are number of coins and amount respectively.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We create a matrix with rows as coins and columns as amount starting from 0. The zeroth row will have max values because
// it's not possible to get a denomination with 0 coin. We iterate and find the values of the matrix with a logic and the last value of
// the matrix gives the solution to get minimum coins.

// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] arr = new int[coins.length+1][amount+1];

        for(int j = 0; j < amount + 1; j++){
            arr[0][j] = Integer.MAX_VALUE - 100; // set the 1st row(zero) to infinite values
        }

        for(int i = 1; i <= coins.length; i++){
            for(int j = 1 ; j <= amount; j++){
                if(j < coins[i-1]){ //until demoination value equals the amount
                    arr[i][j] = arr[i-1][j];
                }else{
                    arr[i][j] = Math.min(arr[i-1][j], 1 + arr[i][j-coins[i-1]]); //compare the previous row's element with number of steps back element
                }
            }
        }
        if(arr[coins.length][amount] == Integer.MAX_VALUE - 100){
            return -1;
        }
        return arr[coins.length][amount];
    }
}