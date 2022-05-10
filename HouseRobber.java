//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

public class HouseRobber {
    public int rob(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        int n = nums.length;
        int chose = nums[0];
        int notChose = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int temp = chose;
            chose = Math.max(notChose, chose);
            notChose = nums[i] + temp;
        }
        return Math.max(notChose, chose);
    }
}
