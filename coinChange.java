import java.util.Arrays;

// Time Complexity : m as created array and n as given coins array length o(m*n)
// Space Complexity :o(amount)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// ***********************************************************************

/* making new array of size given amount+1 and filling it with maximum value/amount+1 
first loop is moving on created array and 2nd loop is running on given coins of array.
every time checking if the current amount is greater than coin because if the coin number is greater than amount we can not 
make such amount with given coins. after this replacing values of created array with minimum value  */

class Solution {
    public int coinChange(int[] coins, int amount) {
    int[] array = new int[amount+1];
        Arrays.fill(array,amount+1);
        array[0]=0;
        
        for(int i =1;i<=amount;i++){
            for(int j =0;j<=coins.length-1;j++){
                if(i>=coins[j]){
                    array[i]= Math.min(array[i], 1+array[i-coins[j]]);
                }
            }
        }
        return array[amount]==amount+1 ? -1 : array[amount];
    }
}