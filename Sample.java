
//Problem-1
// Time Complexity :mn(m-amount , n-coins)
// Space Complexity :mn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to do my research on the
// dynamic programming and do as am not aware of the concept.
/* Your code here along with comments explaining your approach: Here the brute force approach could be try greedy algo but
   there are so cases that will be missed.We try by using exhaustive method i.e try all possibilities. We can achieve this
   by using recursion.This has two cases choosing that denomination or not choosing that denomination. If we choose that
   denomination we are going to decrease that denomination from the amount and and increase the minCoins by 1. If amount is equal to
    0 we will return the min coins . It will give the time limit error as this tries the nested things that are already
    repeated.
    The Optimal Approach could be using the Dynamic Programming
    Here we use the 2d dp array as it depends on two decision variables one is the amount and other is the denomination choosen
    At each index of dp we store the mincoins requried to acieve the specific amount with specific coins. In the end of the dp we
will have the requiredn amount witl all the given coins and we return that */

class Solution {
    // private int helper(int [] coins,int i,int amount,int minCoins){
    //Recursion
//     //base
//         if(amount==0) return minCoins;
//         if(i==coins.length || amount<0) return -1;

//         //logic
//         //choose
//         int case1= helper(coins,i,amount-coins[i],minCoins+1);
//         //notchoosen
//         int case2=helper(coins,i+1,amount,minCoins);
//         if(case1==-1) return case2;
//         if(case2==-1) return case1;

//         return Math.min(case1,case2);

    //     }
    public int coinChange(int[] coins, int amount) {
//       //base
//         return helper(coins,0,amount,0);
//         //logic
//     }

        //DP
        int row=coins.length;
        int column = amount;
        int [][] dp=new int[row+1][column+1];

        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=59551;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1])//if amount less than the coin denomination we have only one option not to choose that coin
                {
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]); //for the choosen case we take the mininmum of both the choosen case and the nonchoosen case.
                    //non choosen can be found at same row and the index of that many coin denomination back
                }
            }
        }
        if(dp[row][column]>=59551) return -1;
        return dp[row][column];
    }
}
//Problem-2
// Time Complexity :n
// Space Complexity :n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to do my research on the
// dynamic programming and do as am not aware of the concept.
/* Your code here along with comments explaining your approach: Here the brute force approach could be try greedy algo but
   there are so cases that will be missed.We try by using exhaustive method i.e try all possibilities. We can achieve this
   by using recursion.This has two cases choosing that house orchoosing that denomination. If we choose that house we are
going to increase the maxRobbed with that house money. We do till we cover all the houses withgiven conditios.
    The Optimal Approach could be using the Dynamic Programming
   Here the optimal approach could be use the 1d array. At each index we store the max money we can get by robbing till that
house.In the end of array we will have the maxAmount by robbing all the houses with given condition.*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int [] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];

        //  return helper(nums,0,0);

    }
    //recursion
//     private int helper(int [] nums,int index,int maxAmount){
//         //base
//         if(index>=nums.length) return maxAmount;

//         //logic
//         int case1= helper(nums,index+2,maxAmount+nums[index]);
//         int case2= helper(nums,index+1,maxAmount);

//        return Math.max(case1,case2);

//     }
}