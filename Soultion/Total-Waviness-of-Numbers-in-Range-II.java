1class Solution {
2    private int getDir(int a, int b) {
3        if (a < b)
4            return 0;
5        if (a == b)
6            return 1;
7        return 2;
8    }
9
10    private boolean matchDir(int dir1, int dir2) {
11        return (dir1 == 0 && dir2 == 2) || (dir1 == 2 && dir2 == 0);
12    }
13
14    private int index(int pos, int tie, int lastDir, int lastDigit) {
15        return ((pos * 2 + tie) * 3 + lastDir) * 10 + lastDigit;
16    }
17
18    private long helper(long num) {
19        if (num <= 0)
20            return 0;
21        char[] chars = Long.toString(num).toCharArray();
22        int m = chars.length;
23        int[] digits = new int[m];
24        for (int i = 0; i < m; i++) {
25            digits[i] = chars[i] - '0';
26        }
27
28        long[] totalWaviness = new long[m * 2 * 3 * 10];
29        long[] totalWays = new long[m * 2 * 3 * 10];
30        for (int firstPos = 0; firstPos < m; firstPos++) {
31            int maxFirstDigit = firstPos == 0 ? digits[0] : 9;
32            for (int firstDigit = 1; firstDigit <= maxFirstDigit; firstDigit++) {
33                int tie = firstPos == 0 ? (firstDigit < digits[0] ? 1 : 0) : 1;
34                int lastDir = 1;
35                totalWays[index(firstPos, tie, lastDir, firstDigit)]++;
36            }
37        }
38        for (int pos = 0; pos + 1 < m; pos++) {
39            for (int tie = 0; tie < 2; tie++) {
40                for (int lastDir = 0; lastDir < 3; lastDir++) {
41                    for (int lastDigit = 0; lastDigit < 10; lastDigit++) {
42                        int idx = index(pos, tie, lastDir, lastDigit);
43                        if (totalWays[idx] == 0)
44                            continue;
45
46                        int maxNextDigit = tie == 1 ? 9 : digits[pos + 1];
47                        for (int nextDigit = 0; nextDigit <= maxNextDigit; nextDigit++) {
48                            int newTie = (tie == 1 || nextDigit < digits[pos + 1]) ? 1 : 0;
49                            int newDir = getDir(lastDigit, nextDigit);
50                            int newIdx = index(pos + 1, newTie, newDir, nextDigit);
51
52                            totalWaviness[newIdx] += totalWaviness[idx]
53                                    + totalWays[idx] * (matchDir(lastDir, newDir) ? 1 : 0);
54                            totalWays[newIdx] += totalWays[idx];
55                        }
56                    }
57                }
58            }
59        }
60        long ans = 0;
61        for (int tie = 0; tie < 2; tie++) {
62            for (int lastDir = 0; lastDir < 3; lastDir++) {
63                for (int lastDigit = 0; lastDigit < 10; lastDigit++) {
64                    ans += totalWaviness[index(m - 1, tie, lastDir, lastDigit)];
65                }
66            }
67        }
68        return ans;
69    }
70
71    public long totalWaviness(long num1, long num2) {
72        return helper(num2) - helper(num1 - 1);
73
74    }
75}