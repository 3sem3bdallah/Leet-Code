1class Solution {
2    public static int GCD(int x, int y) {
3        final int bx = Integer.numberOfTrailingZeros(x);
4        final int by = Integer.numberOfTrailingZeros(y);
5        final int bb = (bx < by) ? bx : by;
6        x >>= bx;
7        y >>= by;
8        for (int r; y > 0; y = Math.min(y, r)) {
9            r = x % y;
10            x = y;
11            y = r;
12        }
13        return x << bb;
14    }
15
16    static public int countTriples(int n) {
17        int cnt = 0;
18        int nsqrt = (int) Math.sqrt((double) n);
19        for (int s = 2; s <= nsqrt; s++) {
20            for (int t = 1 + (s & 1); t < s; t += 2) {
21                if (GCD(s, t) != 1)
22                    continue;
23
24                int c = s * s + t * t;
25
26                if (c > n)
27                    break;
28
29                int kmax = n / c;
30                cnt += 2 * kmax;
31            }
32        }
33        return cnt;
34    }
35}