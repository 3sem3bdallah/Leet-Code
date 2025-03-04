class Solution {
    public String removeOccurrences(String s, String part) {
        int idx = s.indexOf(part);
        while (idx != -1) {
            s = s.substring(0, idx) + s.substring(idx + part.length());
            idx = s.indexOf(part);
        }
        return s;
    }
}
