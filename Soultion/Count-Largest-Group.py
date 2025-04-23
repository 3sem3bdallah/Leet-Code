class Solution:
    def countLargestGroup(self, n: int) -> int:
        def get_digit_sum(x):
            t = 0
            while x > 0:
                t += x % 10
                x //= 10
            return t

        freq = defaultdict(int)
        for i in range(1, n + 1):
            s = get_digit_sum(i)
            freq[s] += 1

        max_size = max(freq.values())
        count = sum(1 for v in freq.values() if v == max_size)
        return count