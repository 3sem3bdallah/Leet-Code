class Solution {
    public int[] closestPrimes(int left, int right) {

        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                primes.add(num);
            }
        }

        if (primes.size() < 2) {
            return new int[] { -1, -1 };
        }

        int minGap = Integer.MAX_VALUE;
        int[] bestPair = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int gap = primes.get(i + 1) - primes.get(i);
            if (gap < minGap) {
                minGap = gap;
                bestPair[0] = primes.get(i);
                bestPair[1] = primes.get(i + 1);
            }
        }

        return bestPair;
    }
}
