class Solution {
public:
    int numRabbits(vector<int>& answers) {
        map<int, int> mp;
        for(auto &it: answers){
            mp[it]++;
        }
        int ans = 0;
        for(auto &it: mp){
            if(it.first + 1 < it.second){
                int div = it.second / (it.first + 1);
                int rem = it.second % (it.first + 1);
                ans += div * (1 + it.first) + (rem > 0 ? it.first + 1: 0);
            }
            else{
                ans += 1 + it.first;
            }
        }
        return ans;
    }
};