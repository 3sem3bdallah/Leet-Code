1impl Solution {
2    pub fn is_anagram(s: String, t: String) -> bool {
3
4        let mut s = s.chars().collect::<Vec<char>>();
5        let mut t = t.chars().collect::<Vec<char>>();
6
7        s.sort();
8        t.sort();
9        
10        s == t
11    }
12}