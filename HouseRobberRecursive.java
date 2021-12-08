/**
 Time and space complexity is exponential i.e 2^n
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        return houseRobHelper(nums, 0, 0);
    }

    private int houseRobHelper(int nums[], int index, int amountRobbed) {
        if(index >= nums.length)
            return amountRobbed;

        //Don't ron current house and go for next
        int case0 = houseRobHelper(nums, index + 1, amountRobbed);
        //Rob current hiuse and go for one after next
        int case1 = houseRobHelper(nums, index + 2, amountRobbed + nums[index]);

        return Math.max(case0, case1);
    }
