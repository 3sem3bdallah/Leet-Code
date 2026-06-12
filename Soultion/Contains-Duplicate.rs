1use std::collections::HashSet;
2
3impl Solution {
4    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
5        let n = nums.len();
6        let set: HashSet<_> = nums.into_iter().collect();
7        set.len() != n
8    }
9}