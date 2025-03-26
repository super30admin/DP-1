// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We decide on each step should we select the house or not.In doing so, if we select the current house,
we add it with the house's robbed result which is atleast 2 steps back. If we dont select the current house,
then we select the previous house result. We take max of both and decide which ones to keep and move ahead

* */
class HouseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];

        int[] dp=new int[n];
        int prev=nums[0];
        int curr=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++)
        {
            int temp=curr;
            curr=Math.max(curr,prev+nums[i]);
            prev=temp;
        }
        return curr;
    }
}