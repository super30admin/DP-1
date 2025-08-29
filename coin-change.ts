// Time complexity- O(m*n), m= number of coins, n = amount
// Space complecity - O(n)
function coinChange(coins: number[], amount: number): number {
	const minCoins: number[] = new Array(amount + 1).fill(Infinity);
	minCoins[0] = 0;

	for (let coin of coins) {
		for (let i = coin; i <= amount; i++) {
			// minCoins[i - coin] = remaiing amount after using curent coin in iteration
			minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
		}
	}

	return minCoins[amount] === Infinity ? -1 : minCoins[amount];
}
