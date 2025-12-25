1class Solution {
2public:
3    long long maximumHappinessSum(vector<int>& christmasJoy, int gifts) {
4        sort(christmasJoy.begin(), christmasJoy.end(), greater<int>());
5
6        long long totalJoy = 0;
7        for (int turn = 0; turn < gifts; ++turn) {
8            int currentJoy = christmasJoy[turn] - turn;
9            if (currentJoy <= 0)
10                break;
11            totalJoy += currentJoy;
12        }
13
14        return totalJoy;
15    }
16};