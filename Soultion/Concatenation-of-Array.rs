1impl Solution {
2    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
3        let res = [nums.clone(), nums].concat();
4        return res;
5    }
6}