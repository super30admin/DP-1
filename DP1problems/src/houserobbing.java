class houserobbing {
    public int rob(int[] nums) {
        int c=0;
        int dc=0;

        for(int x: nums){
            int temp=dc;
            dc=Math.min(c,dc);
            c=temp+x;
        }
        return Math.max(c,dc);

    }
}

//time complexity is O(1)