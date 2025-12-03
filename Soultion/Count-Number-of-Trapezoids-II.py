1from typing import List
2from collections import defaultdict
3from math import gcd
4
5
6class Solution:
7    def countTrapezoids(self, points: List[List[int]]) -> int:
8        n = len(points)
9        SHIFT = 3000
10
11        def encode_pair(a: int, b: int) -> int:
12            return ((a + SHIFT) << 13) ^ (b + SHIFT)
13
14        by_slope = defaultdict(lambda: defaultdict(int))
15        by_vector = defaultdict(lambda: defaultdict(int))
16
17        for i in range(n):
18            x1, y1 = points[i]
19            for j in range(i + 1, n):
20                x2, y2 = points[j]
21                dx = x2 - x1
22                dy = y2 - y1
23
24                if dx < 0 or (dx == 0 and dy < 0):
25                    dx = -dx
26                    dy = -dy
27
28                g = gcd(dx, dy)
29                ux = dx // g
30                uy = dy // g
31
32                line_id = ux * y1 - uy * x1
33
34                slope_key = encode_pair(ux, uy)
35                vector_key = encode_pair(dx, dy)
36
37                by_slope[slope_key][line_id] += 1
38                by_vector[vector_key][line_id] += 1
39
40        def count_pairs(mp) -> int:
41            ans = 0
42            for inner in mp.values():
43                counts = inner.values()
44                s = sum(counts)
45                sum_sq = sum(c * c for c in counts)
46                ans += (s * s - sum_sq) // 2
47            return ans
48
49        with_parallel = count_pairs(by_slope)
50        parallelogram_twice = count_pairs(by_vector)
51
52        return with_parallel - parallelogram_twice // 2
53