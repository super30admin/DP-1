/**
Problem: Find the min number of coins needed to make a given amount

Time Complexity: O(n), where n is the length of the given array. 
Space Complexity: O(n), where n is the length of the given array. 
Did this code successfully run on Leetcode : Yes

Approach : Dynammic Programming.
1. Create a matrix where the num of rows is equal to the length of the given array, and number of columns = 2(we either choose the given house or not. The first column denotes not choosing the house, the second one denotes choosing the house)
2. At every cell in the matrix, there are only two possible choices:
    a) You either select the house (or) . If you select the present house, we must not select it's neighboring houses.
    b) You don't. If you don't choose the house, you are free to either select the previous house or not.
3. Among these two choices, we always choose the one that gives you the maximum value.
4. This way, we compute the whole matrix, and our required answer is present in the last row. You now choose the cell which is the maximum among the two cells of the last row.
*/


class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length+1][2];// we only need two column Choose the house or not choose the house
        dp[0][1] = nums[0]; //whatever amount is present in the first house
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]); // if you haven't chosen the present house, you have the option to choose the maximum amount by choosing the prev house, or not choosing the prev house.
            dp[i][1] = nums[i] + dp[i-1][0]; // when you choose the house you can't choose the prev house
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]); //whichever value is more choose that
    }
}