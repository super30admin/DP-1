class coinChange {

    public int coinChange(int[] coins, int amount) {

        int[] arr = new int[coins.length];
        int count = 0;

        int curr = 0;
        for (int i=0; i<coins.length; i++) {
            arr[i] = curr + arr[i];
            curr+= arr[i];

            if (curr == amount) {
                count++;
            }
        }

        return count;
        
    }

}