//TC - O(n)
//SC - O(n)

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();

        // Example 1: Robbing houses [1, 2, 3, 1]
        int[] nums1 = {1, 2, 3, 1};
        int result1 = solution.rob(nums1);
        System.out.println("Maximum amount you can rob: " + result1); // Output: 4

        // Example 2: Robbing houses [2, 7, 9, 3, 1]
        int[] nums2 = {2, 7, 9, 3, 1};
        int result2 = solution.rob(nums2);
        System.out.println("Maximum amount you can rob: " + result2); // Output: 12
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int skip = 0;
        int take = nums[0];
        for(int i=1; i<nums.length; i++){
                int currentSkip = skip;
                skip = Math.max(skip, take);
                take = nums[i] + currentSkip;
        }

        return Math.max(skip, take);
    }
}


