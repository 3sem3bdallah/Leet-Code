class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:

        points.sort(key=lambda p: (p[0], -p[1]))
        n, cnt = len(points), 0

        for i in range(n - 1):
            _, y1 = points[i]
            best = -1

            for j in range(i + 1, n):
                y2 = points[j][1]
                if best < y2 <= y1:
                    cnt += 1
                    best = y2
                if best == y1:
                    break

        return cnt
