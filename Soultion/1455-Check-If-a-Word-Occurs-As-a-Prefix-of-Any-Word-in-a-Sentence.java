class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int idx = 0; idx < words.length; idx++) {
            if (words[idx].startsWith(searchWord)) {
                return idx + 1;
            }
        }
        return -1;
    }
}