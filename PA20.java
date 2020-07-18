//LeetCode 198. House Robber
//Time Complexity : O(n) // nn is number of houses
//Space Complexity: O(1)

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int nc=0;
        int sc= nums[0];
        int temp=0;
        for(int i =1;i<nums.length ;i++){
            temp= nc;
            nc= Math.max(nc,sc);
            sc= temp+nums[i];
        }
        return Math.max(nc,sc);
    }
}