// Time Complexity: O(number of coins * amount) as we are checking each amount value upto target amount with each denomination coin.
// Space complexity: O(number of coins * amount) a matrix is created to reach the final output
// Did you complete problem at leet code: Yes
// Any problems faced: wasn't able to identify index to be used 

//explain your code here
// Idea here is to solve the subproblem reaching upto target amount. first we can calculate
// what is the minimum number of coins required for achieving amount 1 with each coin denomination there is only 1 possibility using coin of denomination 1.
// further we can calculate for each amount by comparing if the number of coins taken from previous coin denomination lesser or greater than the usage of a combination of current coin and previous coin denomination, min value is carry forwarded.
// a base case allows us to return that no combination accesses a sum of target if the amount is lesser than the min of last min found.
// last index value sifnifies the least value that can be used to get total sum.
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int[][] arr = new int[coins.length+1][amount+1];
        for(int j=1; j<=amount; j++) {
            arr[0][j] = amount+50;
        }
        for(int i=1; i<arr.length; i++) {
            for(int j=1; j<arr[0].length; j++) {
                if(coins[i-1]>j) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = Math.min(arr[i-1][j], 1+arr[i][j-coins[i-1]]);
                }
            }
        }
        if(arr[arr.length-1][arr[0].length-1]>amount) return -1;
        return arr[arr.length-1][arr[0].length-1];
    }
}