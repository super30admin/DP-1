// Time Complexity :O(N) where N is no. of houses.
// Space Complexity : O(1), since two variables take and skip are used.
// Did this code successfully run on Leetcode :yes
/* Approach- skip variable denotes the house is skipped which means we can consider
the max(previous skip + previous take )value. take variable denotes that the house is robbed,
which means that the previous house is not robbed so, the take value is current house property value +
previous skip */
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int skip=0,take=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+nums[i];
        }
        return Math.max(skip,take);
    }
}