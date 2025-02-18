// Time Complexity : O(n)
//Space Complexity : O(n)   
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        if(n==1)return prev;
        int curr=Math.max(nums[0],nums[1]+0);
        for(int i=2;i<n;i++){
            int temp=curr;
            curr=Math.max(curr,nums[i]+prev);
            prev=temp;
        }
        return curr;
    }
}