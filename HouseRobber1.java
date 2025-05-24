// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : doing memorization took me some time

public class HouseRobber1 {
    static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            int next = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = next;
        }
        return curr;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println("Maximum money that can be robbed: " + rob(nums));
    }
}
