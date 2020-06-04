//house-robber
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        int prevMax=0; // to store the prev we got
        int currMax=0; // to store the curr sum we are getting

        for(int i=0;i<nums.length;i++)
        {
            int temp = prevMax; // swap the two values so that the next value is added to the non-adjacent one
            prevMax = currMax;
            currMax = temp;
            currMax = Math.max(currMax+nums[i], prevMax); // add the value to currmax and check the max value between curr and prev
            
        }
        return currMax; 
    }
}

//coin-change
// Time Complexity : 2^n * k where n is lengthof coins array and k is the amount
// Space Complexity : o(n) stack space
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded due to recursion


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins==null)
            return 0; // as no coins choosed
        
        int mincoins = helper(coins, amount, 0, 0); // calling helper func
        return mincoins;
    }
    
    private int helper(int[] coins, int amount, int index, int minCoins)
    {
     //base
        if(amount==0) // when amount becomes zero we have a valid path so return the min no of coins
            return minCoins;
        if(amount<0 || index>coins.length-1) // if the amount becomes less than 0 as we decrease it or the index exceeds the coins array length
            return -1; // we have an invalid path
    //logic
        //choose
        int case1 = helper(coins, amount - coins[index], index, minCoins+1); // index same as can choose same coin again and again, decreasing the amount by the coin value and increasing minCoins as we chose the coin
        //not choosing
        int case2 = helper(coins, amount, index+1, minCoins); // not choosing so go to the next coin and increment index
        
        if(case1 == -1) // while comparing the two values if case1 gives -1
            return case2; // choose case2 and vice versa
        if(case2 == -1)
            return case1;
        return Math.min(case1, case2); // else if both case1 and 2 gives some value, choose the min one
    }
}

// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins==null)
            return 0;
        
        int dp[][] = new int[coins.length+1][amount+1]; // considering 0 for dummy row and amount+1 to consider amount 0
        int n = dp.length; 
        int m = dp[0].length;
        for(int j = 1; j < m ; j++) // intializing the first row to infinity exculding the first column ie. amount 0 so we start i from 1
        {
             dp[0][j] = amount+1; // infinty in the case as the number of coins needed should never exceed the amount value or take 9999
        }
        
        for(int i=1;i<n;i++) // already filled row 0 ( i represents coin denomination)
        {
            for(int j=1;j<m;j++) // default value for 0th row is 0 i.e for amount 0, zero coins needed (j represents amount)
            {
                if(j<coins[i-1]) // amount to be calculated is less than the coin denomination(accessed by i-1 since in the coin array there is no 0 value and i is the index for dp array)
                {
                   dp[i][j] = dp[i-1][j]; //zero case where value has been taken from the value above it
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                    //value will be the min from zero case and one case (considering the value in the row at the coin demoniation steps back)
                }
            }
            
        }
        
        
        if(dp[n-1][m-1]>= amount+1) // if the value at last index is greater or equal to infinity or take 9999
            return -1; // no coins can make the amount 
            return dp[n-1][m-1]; // the last index value
        
    }
}