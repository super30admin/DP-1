class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int skip=0;
        int take =nums[0];
        for(int i=1;i<nums.length;i++)
        {
            //not choose 0
            int temp = skip; //store previous skip
            skip = Math.max(skip,take);
            //choose 1
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}

//Time complexity is O(N).
//Space complexity is O(1) since we are making use skip and take. If an array was used then it would be O(N).