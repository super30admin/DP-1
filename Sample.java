// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : //thinking about space optimized solution at first place. but eventually got to it


// Your code here along with comments explaining your approach
class Solution {
    //exhaustive
    // public int rob(int[] nums) {
    //     return helper(nums,0, 0);
    // }

    // private int helper(int[] nums, int i, int robbings){
    //     //base
    //     if(i>=nums.length) return robbings;
    //     //logic
    //     //dont choose
    //     int case0= helper(nums, i+1, robbings);
    //     //choose
    //     int case1= helper(nums, i+2, robbings+nums[i]);

    //     return Math.max(case0,case1);
    // }

    //dp with extra array
    // public int rob(int[] nums) {
    //     if(nums.length<2) return nums[0];
    //     int n=nums.length;
    //     int[] dp= new int[n];
    //     dp[0]=nums[0];
    //     dp[1]=Math.max(nums[0],nums[1]);

    //     for(int i=2;i<n;i++){

    //         //max of case dont choose and case choose
    //         dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
    //     }
    //     return dp[n-1];
    // }

    //dp with space optimization
    // public int rob(int[] nums) {
    //     if(nums.length<2) return nums[0];
    //     int n=nums.length;
    //     //now prev=nums[0](basically nums[i-2] in loop) and curr is nums[1]
    //     int prev=nums[0];
    //     int curr=Math.max(nums[0],nums[1]);
    //     for(int i=2;i<n;i++){
    //         int temp=curr; //curr is going to be overwritten so store in temp variable
    //         //case0 dont choose
    //         curr=Math.max(curr,nums[i]+prev);
    //         prev=temp; //prev is now incremented to old current which is stored in temp
    //     }
    //     return curr;
    // }

    //dp with no extra variables
    public int rob(int[] nums) {
        if(nums.length<2) return nums[0]; //null and single house check
        int n=nums.length;
        
        nums[1]=Math.max(nums[0],nums[1]); // 1st index house(if nums[1]>nums[0] then robber will rob 2nd house first)
        for(int i=2;i<n;i++)
            nums[i]=Math.max(nums[i-1],nums[i]+nums[i-2]); // if rob house:(he cannot rob house with immediate behind index but 2 immediate index behind he has robbed)
                                                        //if not rob house:(means he robbed behind house)
        return nums[n-1]; //we store maximum robbings at each given index of array, so max robbings is last index element
    }
}