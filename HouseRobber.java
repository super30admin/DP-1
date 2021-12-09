public class HouseRobber {
    public int rob(int[] nums) {

        int skip = 0;
        int take = nums[0];

        for(int i =1; i< nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }

        return Math.max(skip, take);

    }
}

