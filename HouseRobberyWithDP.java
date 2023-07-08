// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class HouseRobberyWithDP {

    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        if (nums.length == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        int temp = 0;

        for(int i=2; i<nums.length; i++)
        {
            temp = curr;
            curr = Math.max(curr, nums[i]+prev);
            prev = temp;
        }

        return curr;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
