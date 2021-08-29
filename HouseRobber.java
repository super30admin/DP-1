// Time Complexity : O(n)  n=number of elements in input Array.
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class HouseRobbere {
 public static int rob(int[] nums) {
        int norob=0;
        int rob=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int temp=norob;
            norob=Math.max(rob,norob);
            rob=temp+nums[i];     
        }
        return Math.max(rob,norob);
    }
}