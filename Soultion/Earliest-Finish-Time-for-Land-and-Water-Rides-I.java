1class Solution {
2    public int earliestFinishTime(
3        int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
4    {
5        int minLandEnd = Integer.MAX_VALUE;
6        int minWaterEnd = Integer.MAX_VALUE;
7
8        int n = landStartTime.length;
9        int m = waterStartTime.length;
10
11        for (int i = 0; i < n; i++) {
12            minLandEnd = Math.min(
13                    minLandEnd,
14                    landStartTime[i] + landDuration[i]);
15        }
16
17        for (int j = 0; j < m; j++) {
18            minWaterEnd = Math.min(
19                    minWaterEnd,
20                    waterStartTime[j] + waterDuration[j]);
21        }
22
23        int ans = Integer.MAX_VALUE;
24
25        // Land -> Water
26        for (int j = 0; j < m; j++) {
27            ans = Math.min(
28                    ans,
29                    Math.max(minLandEnd, waterStartTime[j]) + waterDuration[j]);
30        }
31
32        // Water -> Land
33        for (int i = 0; i < n; i++) {
34            ans = Math.min(
35                    ans,
36                    Math.max(minWaterEnd, landStartTime[i]) + landDuration[i]);
37        }
38
39        return ans;
40    }
41}