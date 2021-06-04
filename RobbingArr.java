package dp1;

public class RobbingArr {

    public int rob(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int[] arr = new int[nums.length];
        int n = nums.length;
        if (n >= 1) {
            arr[0] = nums[0];
        }

        if (n >= 2) {
            arr[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < n; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        }

        return arr[n - 1];
    }
}
