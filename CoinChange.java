// Time Complexity : O(2pow(m+n)) where m coins len, n amount
// Space Complexity :O(2pow(m+n)) we are keeping track of each recursion call, whic increases heap memory
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach
//The approach is to do recursion and go on a selecting or not selecting current coins
//if selected we will keep the index same, not selected move to next coins
//in recursion call we find the min at each node from two cases and return the min
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int value = helper(coins,amount,0);
        if(value==Integer.MAX_VALUE-2)
        {
            return -1;
        }
        return value;
    }

    private int helper(int[] coins,int amount,int index)
    {
        //base case
        if(amount<0 || index==coins.length)
        {
            return Integer.MAX_VALUE - 2;
        }
        if(amount==0)
        {
            return 0;
        }
        //taking current index
        int case1 = 1 + helper(coins,amount - coins[index],index);
        //not-taking current index
        int case2 = helper(coins,amount,index+1);
        return Math.min(case1,case2);
    }
}

// Time Complexity : O(m*n) where m coins len, n amount
// Space Complexity :O(m*n) we are keeping track of each recursion call in memory, in theory it will be max m*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//The approach is to do recursion and go on a selecting or not selecting current coins with memorization
//if selected we will keep the index same, not selected move to next coins
//in recursion call we find the min at each node from two cases and save the min in memory and return the min
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] mem = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        int value = helper(coins,amount,0,mem);
        if(value==Integer.MAX_VALUE-2)
        {
            return -1;
        }
        return value;
    }

    private int helper(int[] coins,int amount,int index,int[][] mem)
    {
        //base case
        if(amount<0 || index==coins.length)
        {
            return Integer.MAX_VALUE - 2;
        }
        if(amount==0)
        {
            return 0;
        }
        //check if you have seen this node before
        if(mem[index][amount]!=-1)
        {
            return mem[index][amount];
        }
        //taking current index
        int case1 = 1 + helper(coins,amount - coins[index],index,mem);
        //not-taking current index
        int case2 = helper(coins,amount,index+1,mem);
        int min = Math.min(case1,case2);
        mem[index][amount] = min;
        return min;
    }
}

// Time Complexity : O(m*n) where m coins len, n amount
// Space Complexity :O(m*n) we are keeping track of each recursion call in memory, in theory it will be max m*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
        {
            return 0;
        }
        int[][] mem = new int[coins.length+1][amount+1];
        //first row using 0 coins, put a MAX value
        Arrays.fill(mem[0], Integer.MAX_VALUE-1);
        mem[0][0] = 0;

        //go over each coin values
        for(int i = 1;i<=coins.length;i++)
        {
            // till amount is less than current coin, fill upper coin value
            // else calculate using current coin
            for(int j = 1;j<=amount;j++)
            {
                int withOutCurrentCoin = mem[i-1][j];
                int withCurrentCoin = Integer.MAX_VALUE-1;
                if(j>=coins[i-1])
                {
                    withCurrentCoin = 1 + mem[i][j-coins[i-1]];
                }
                mem[i][j] = Math.min(withOutCurrentCoin,withCurrentCoin);

            }
        }
        return mem[coins.length][amount]==Integer.MAX_VALUE -1? -1 : mem[coins.length][amount];
    }
}

// Time Complexity : O(m*n) where m coins len, n amount
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
//It is similar to previous soln with just we are overwriting each mem value from previous one
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
        {
            return 0;
        }
        int[] mem = new int[amount+1];
        Arrays.fill(mem, Integer.MAX_VALUE-1);
        mem[0] = 0;

        for(int i = 1;i<=coins.length;i++)
        {
            for(int j = 1;j<=amount;j++)
            {
                int withOutCurrentCoin = mem[j];
                int withCurrentCoin = Integer.MAX_VALUE-1;
                if(j>=coins[i-1])
                {
                    withCurrentCoin = 1 + mem[j-coins[i-1]];
                }
                mem[j] = Math.min(withOutCurrentCoin,withCurrentCoin);
            }
        }
        return mem[amount]==Integer.MAX_VALUE -1? -1 : mem[amount];
    }
}