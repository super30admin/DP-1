o(nd) time and o(n) space
class CoinChange{
 public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    
		int [] numOfCoins= new int[n+1];
		Arrays.fill(numOfCoins,Integer.MAX_VALUE);
		numOfCoins[0]=0;
		int toCompare=0;
		
		for ( int denom : denoms){
			
			for ( int amount = 0 ; amount<numOfCoins.length;amount++){
				if(denom<=amount){
					if(numOfCoins[amount-denom]==Integer.MAX_VALUE){
						toCompare= numOfCoins[amount-denom];
					}else{
						toCompare=numOfCoins[amount-denom]+1;
					}
					numOfCoins[amount]=Math.min(numOfCoins[amount],toCompare);
				}
			}
		}
    return numOfCoins[n]!=Integer.MAX_VALUE? numOfCoins[n]:-1;
  } 
}
