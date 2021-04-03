package String;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // sanity check
        // check valid (long string, short string)
        if (sentence1.length() >= sentence2.length()) {
            return helper(sentence1, sentence2);
        } else {
            return helper(sentence2, sentence1);
        }
    }
    // check valide
    private boolean helper(String longer, String shorter) {
        // parse to array of strings
        String[] one = longer.split(" ");
        String[] two = shorter.split(" ");
        int i = 0;
        int j = 0;
        boolean insert = false;
        while (i < one.length && j < two.length) {
            if (one[i].equals(two[j])) {
                i++;
                j++;
            } else if (!one[i].equals(two[j]) && !insert) {
                insert = true;
                while (i < one.length && !one[i].equals(two[j])) {
                    i++;
                }
            } else {
                return false;
            }
        }
        // iterate
        // return
        if (insert == false) {
            return j == two.length;
        } else {
            return i == one.length && j == two.length;
        }
    }

    public static void main(String[] args) {
        SentenceSimilarity sol = new SentenceSimilarity();
        String s1 = "of";
        String s2 = "A lot of words";
        System.out.println(sol.areSentencesSimilar(s1, s2));
    }
}
