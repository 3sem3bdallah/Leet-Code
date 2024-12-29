class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        M = 10 ** 9 + 7
        n = len(target)
        m = len(words[0])

        if m < n:
            return 0

        chars = [Counter(x) for x in zip(*words)]
        gap = m - n + 1
                
        dp = [1] * gap + [0]

        for i in range(n):
            for j in range(gap):
                dp[j] = (dp[j - 1] + dp[j] * chars[i + j][target[i]]) % M

        return dp[gap - 1]