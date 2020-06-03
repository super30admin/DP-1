// Time Complexity :O(n) n-length of the array
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : gets confusing at few cases
class Solution {
public int rob(int[] nums) {
     int curr=0;
     int next=0;
     for(int i=0;i<nums.length;i++)
     {
             int temp=curr; // stores i-1
             curr=Math.max(next+nums[i],curr); // get the max between [i]+[i-2] and [i-1]
             next=temp; //moving [i-1] to [i-2] to add with next loop's current element

     }
    return Math.max(curr,past);
        
    }
}

// Alternate approach
// Time Complexity :O(n) n-length of the array
// Space Complexity :O(n) 
/*
class Solution {
public int rob(int[] nums) {
        
    int dp[]=new int[nums.length];
    if(nums==null || nums.length==0) return 0;
    if(nums.length==1) return nums[0];
    if(nums.length==2) return Math.max(nums[0],nums[1]);
    dp[0]=nums[0];
    dp[1]=Math.max(nums[0],nums[1]);
    for(int i=2;i<nums.length;i++)
    {
        dp[i]=Math.max(nums[i]+dp[i-2] , dp[i-1]);
    }
    return dp[nums.length-1];
}
}
*/