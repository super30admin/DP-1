class houseRobber {

    public int rob(int[] nums) {
        
        int total = 0;
        for (int i=0; i<nums.length; i++) {
            if (arr[i + 1] > arr[i]) {
                total += arr[i + 1];
            } else {
                total += arr[i];
            }
        }

        return total;
        
    }

}   