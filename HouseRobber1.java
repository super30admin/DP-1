import java.util.Arrays;

/**
 * This uses top-down approach. This solution is memoised. This has o(n) time complexity where n is the length of nums. The Space complexity is O(n).
 */
public class HouseRobber1 {

    private int memo[];

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return maxAmountRobbed(nums, 0);
    }

    private int maxAmountRobbed(int[] nums, int index) {

        if (index == nums.length) return 0;

        if (index > nums.length) return 0;

        if (memo[index] != -1) return memo[index];

        // not choose
        int notChoose = maxAmountRobbed(nums, index + 1);

        // choose
        int choose = nums[index] + maxAmountRobbed(nums, index + 2);
        int result = Math.max(choose, notChoose);
        memo[index] = result;
        return result;
    }

    public static void main(String[] args) {
        int rob = new HouseRobber1().rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);

        rob = new HouseRobber1().rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}
