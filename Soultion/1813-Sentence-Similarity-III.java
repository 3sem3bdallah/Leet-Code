class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int n1 = words1.length;
        int n2 = words2.length;

        int i = 0;
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }

        int j = 0;
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }

        return i + j == Math.min(n1, n2);
    }
}
