1class Solution {
2public:
3    void sortColors(vector<int>& nums) {
4        int l = 0;
5        int m = 0;
6        int h = nums.size()-1;
7
8        while(m<=h){
9            if(nums[m]==0){
10                swap(nums[l], nums[m]);
11                l++;
12                m++;
13            }
14            else if(nums[m]==1){
15                m++;
16            }
17            else if(nums[m]==2){
18                swap(nums[m], nums[h]);
19                h--;
20            }
21        }
22    }
23};