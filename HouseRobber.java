// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class HouseRobber {
    public int rob(int[] nums) {
        int house1 = 0;
        int house2 = 0;

        for(int i=0;i<nums.length;i++) {
            int temp = Math.max(nums[i] + house1, house2);
            house1 = house2;
            house2 = temp;
        }

        return house2;
    }
}
