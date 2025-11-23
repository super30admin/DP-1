// DP with constant space
// Time: O(N)
// Space: O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int previousHouse = nums[0];
        int currentHouse = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i ++) {
            int temp = currentHouse;
            // Consider max between robbery until adjacent house and robbery until adjacent - 1 house + current house.
            currentHouse = Math.max(currentHouse, previousHouse + nums[i]);
            previousHouse = temp;
        }
        return currentHouse;
    }
}