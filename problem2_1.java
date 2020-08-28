//Time Complexity= O(N)
//Space Complexity =O(1)

class Solution {
    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;

        int C = 0, DC = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = DC;
            DC = Math.max(C, DC);

            C = temp + nums[i];
        }
        return Math.max(C, DC);
    }
}