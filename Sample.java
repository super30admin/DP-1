// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


Problem1:: Coin Change

Bruteforce: 

Recursive solution: either we choose a coin or not choose a coin

if we choose a coin => amount - coins[i] & min + 1 & i;
if we not choose a coin ==> amount, min, i=i+1;

Time Complexity : O(m2^n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : not really


DP Approach:
create a 2D array of length no of coins +1  and amount +1
check if the current index is less than the denomination value copy the array from above
else take minimum from above row and backward - coinvalue Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
check the base condition if last index is greater than 999 or amount +1;

Time Complexity : O(m*n)
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : initially felt a little difficult to deal with 2D array, need to practice more.


==================================================================================================
  
Problem 2: House Robber


BruteForce :: Recursive

Only two cases we have either choose a house or not choose a house
//        int choosen =  helper(nums, i+2, sum + nums[i]);
       
//        int notChossen =  helper(nums, i+1, sum); 
  
//        return Math.max(choosen, notChossen);

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes


Optimal DP solution:
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);   --not chosen
            dp[i][1] = dp[i-1][0] + nums[i];               -- chosen

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


