/**
 * This uses top down approach. The time complexity is O(2 power n) where n is the length of nums.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        return maxAmountRobbed(nums, 0);
    }

    private int maxAmountRobbed(int[] nums, int index) {

        if (index == nums.length) return 0;

        if (index > nums.length) return 0;

        // not choose
        int notChoose = maxAmountRobbed(nums, index + 1);

        // choose
        int choose = nums[index] + maxAmountRobbed(nums, index + 2);
        return Math.max(choose, notChoose);
    }

    public static void main(String[] args) {
        int rob = new HouseRobber().rob(new int[]{2, 7, 9, 3, 1, 8});
        System.out.println(rob);

        rob = new HouseRobber().rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}
