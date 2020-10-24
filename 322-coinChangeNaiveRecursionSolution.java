// Time Complexity : Not sure
// Space Complexity :  O(m+n) not sure, n = length of array, m = amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
/**
 *the length of the recursion stack = m + n => n= [2, 5] m = 6
 index -> index of the current element from the coins array

 */
package DP;

public class coinChangeRecursive {

    public static int coinChange(int[] coins, int amount){

        //edge case
        if(coins == null || coins.length == 0) return -1;
        return helper(coins, amount, 0, 0);  //amount: amount left.
    }

    public static int helper(int[] coins, int amount, int index, int min){

        //base case
        if(amount == 0) return min;   //valid case
        if(amount < 0 || index == coins.length) return -1; //invalid case


        //logic --> either choose or don't choose
        //choose
        System.out.println("index: "+ index + "min " + min);
        int case1 = helper(coins, amount - coins[index], index, min + 1);

        System.out.println("case 1: "+ case1);
        //don't choose
        int case2 = helper(coins, amount, index + 1, min);
        System.out.println("case 2: "+ case2);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        System.out.println("Minimum: "+ Math.min(case1, case2));
        return Math.min(case1, case2);   //choosing the min from the solutions which we got in the recursive tree eg. [2,2,2] or [2,5]
    }

    public static void main(String args[]){

        int[] coins = new int[]{2,5};
        int amount = 6;
        System.out.println("Minimum number of coins needed: "+ coinChange(coins, amount));
    }
}
