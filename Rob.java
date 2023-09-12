// Time Complexity :
//O(n)
// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode :
//yes
// Any problem you faced while coding this :
//No

// Your code here along with comments explaining your approach
//taking variable skip and take instead of array 0,1 for robbing that house vs not robbing
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        for(int i = 1;i<n; i++) {
            int temp = skip;
            skip = Math.max(skip,take);
            take = nums[i] + temp;
        }
        return Math.max(skip,take);
    }
}