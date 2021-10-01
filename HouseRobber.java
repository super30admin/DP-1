// Time Complexity : O(N)
// Space Complexity :  O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];

        int[] table = new int[n];
        table[0] = nums[0];
        table[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i<n;i++){
            table[i] = Math.max(nums[i] + table[i-2],table[i-1]);
        }
        return table[n-1];


    }
}