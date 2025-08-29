// Time complexity- O(m*n), m= number of coins, n = amount
// Space complecity - O(n)
function coinChange(coins: number[], amount: number): number {
	const minCoins: number[] = new Array(amount + 1);
	minCoins[0] = 0;
	for (let currentAmount = 1; currentAmount <= amount; currentAmount++) {
		minCoins[currentAmount] = Infinity;
	}

	for (let coinIndex = 0; coinIndex < coins.length; coinIndex++) {
		const coinValue = coins[coinIndex];
		for (
			let currentAmount = coinValue;
			currentAmount <= amount;
			currentAmount++
		) {
			minCoins[currentAmount] = Math.min(
				minCoins[currentAmount],
				1 + minCoins[currentAmount - coinValue]
			);
		}
	}

	return minCoins[amount] === Infinity ? -1 : minCoins[amount];
}
