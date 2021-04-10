package HashMap;

import java.util.HashMap;
import java.util.Map;

public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        // sanity check
        if (words == null || words.length == 0 || order == null || order.length() == 0) {
            return false;
        }
        // hashmap to record charater and its weight
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        // iterate through the words array
        // compare each adjacent pair
        // return false if any pair is not in order
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        // return true
        return true;
    }
    // check if two pairs are in order
    private boolean isOrder(String one, String two, Map<Character, Integer> orderMap) {
        // two pointers iterate each word at same time
        // if current one's character is smaller than two's
        // return false
        int i = 0;
        while (i < one.length()) {
            if (i >= two.length()) {
                return false;
            }
            int oneWeight = orderMap.get(one.charAt(i));
            int twoWeight = orderMap.get(two.charAt(i));
            if (oneWeight < twoWeight) {
                return true;
            }
            if (oneWeight > twoWeight) {
                return false;
            }
            i++;
        }
        // return true
        return true;
    }
    public static void main(String[] args) {
        VerifyAlienDictionary sol = new VerifyAlienDictionary();
        String[] words = {"ubg","kwh"};
        String order = "qcipyamwvdjtesbghlorufnkzx";
        System.out.println(sol.isAlienSorted(words, order));
    }
}
