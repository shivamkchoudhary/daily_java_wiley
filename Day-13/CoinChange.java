package com.shivamkchoudhary;

public class CoinChange {
    public static int makeChange(int amount) {
        int[] coins = {5, 2, 1}; // available
        int numCoins = 0;

        for (int coin : coins) {
            int numCoin = amount / coin;
            numCoins += numCoin;
            amount -= numCoin * coin;

            if (amount == 0) {
                break;
            }
        }

        return numCoins;
    }

    public static void main(String[] args) {
        int numCoins = makeChange(18);
        System.out.println(numCoins);
    }

}
