1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3
4        int minLengthLand = Integer.MAX_VALUE;
5        int minTotalLand = Integer.MAX_VALUE;
6
7        for (int i = 0; i < landStartTime.length; i++) {
8            minLengthLand = Math.min(
9                    minLengthLand,
10                    landStartTime[i] + landDuration[i]);
11        }
12
13        for (int i = 0; i < waterStartTime.length; i++) {
14
15            int start = Math.max(waterStartTime[i], minLengthLand);
16            minTotalLand = Math.min(
17                    minTotalLand,
18                    start + waterDuration[i]);
19        }
20
21        int minLengthWater = Integer.MAX_VALUE;
22        int minTotalWater = Integer.MAX_VALUE;
23
24        for (int i = 0; i < waterStartTime.length; i++) {
25            minLengthWater = Math.min(
26                    minLengthWater,
27                    waterStartTime[i] + waterDuration[i]);
28        }
29
30        for (int i = 0; i < landStartTime.length; i++) {
31
32            int start = Math.max(landStartTime[i], minLengthWater);
33            minTotalWater = Math.min(
34                    minTotalWater,
35                    start + landDuration[i]);
36        }
37
38        return Math.min(minTotalLand, minTotalWater);
39    }
40}
41