// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we take a dp array since the input variable is only 1. We take the first element as of the array and second 
//as the max of the first and second in the array.Then we take the max of previous and two steps back  + the money at that house. 
//Because we cant take alternate houses. we return the last element of the dp array.
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)return 0;
        if(nums.length ==1)return nums[0];
        int n= nums.length;
        int [] dp= new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)return 0;
        if(nums.length ==1)return nums[0];
        int n= nums.length;
        
        int prev = nums[0];
        int curr = Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            int temp = curr;
            curr = Math.max(curr,nums[i]+prev);
            prev=temp;
        }
        return curr;
    }
}

//Recursive solution
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)return 0;
        return helper(nums,0,0);
    }

    private int helper(int[] nums, int idx, int robbings){
        //base
        if(idx >= nums.length) return robbings; //>= because we are adding 2
        //logic
        //choose
        int case1 = helper(nums, idx+2, robbings + nums[idx]);
        //not choose
        int case2 =helper(nums, idx+1, robbings);
        return Math.max(case1,case2);
    }
}
