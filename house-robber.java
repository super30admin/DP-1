//Time complexity = O(n), Space Complexity = O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int chooseCaseAmount = 0;
        int doNotChooseCaseAmount = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = doNotChooseCaseAmount;
            doNotChooseCaseAmount = Math.max(doNotChooseCaseAmount, chooseCaseAmount);
            chooseCaseAmount = temp + nums[i];
        }

        return Math.max(chooseCaseAmount, doNotChooseCaseAmount);
    }
}