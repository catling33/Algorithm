package HashTable;


import java.util.*;

public class VowelSpellchecker {
    // table 1, 2, 3
    Set<String> exactSet = new HashSet<>();
    Map<String, String> lowMap = new HashMap<String, String>();
    Map<String, String> volMap = new HashMap<String, String>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        // sanity check
        if (wordlist == null || wordlist.length == 0 || queries == null || queries.length == 0) {
            return new String[0];
        }
        // result array
        String[] result = new String[queries.length];
        // three hashtables

        for (String word : wordlist) {

            // add to table 1
            exactSet.add(word);

            // add to table 2
            String wordLow = word.toLowerCase();
            lowMap.putIfAbsent(wordLow, word);

            // add to table 3
            String wordVol = replaceVol(wordLow);
            volMap.putIfAbsent(wordVol, word);
        }

        // deal with query
        int i = 0;
        for (String query : queries) {
            result[i] = resolve(query);
            i++;
        }

        // return result array
        return result;
    }

    // replace vowel with * in lower case word
    private String replaceVol(String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (isVol(array[i])) {
                array[i] = '*';
            }
        }
        return new String(array);
    }

    // check if current character is vowel
    private boolean isVol(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }

    // resolve query
    private String resolve(String query) {
        // if matches exactly
        if (exactSet.contains(query)) {
            return query;
        }

        // if match by fixing capitalization
        String queryLow = query.toLowerCase();
        if (lowMap.containsKey(queryLow)) {
            return lowMap.get(queryLow);
        }

        // if match by replacing vowels
        String queryVol = replaceVol(queryLow);
        if (volMap.containsKey(queryVol)) {
            return volMap.get(queryVol);
        }

        // otherwise, return empty string
        return "";
    }

    public static void main (String[] args) {
        VowelSpellchecker sol = new VowelSpellchecker();
        String[] wordList = new String[] {"KiTe","kite","hare","Hare"};
        String[] queries = new String[] {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.print(Arrays.toString(sol.spellchecker(wordList, queries)));
    }
}

// wordlist = ["KiTe","kite","hare","Hare"]

// method : three hashmaps

// 1. match exactly
// use hashset to store the words exactly

// 2. match caplitalization
// use hashmap to store : <lowercase, word in wordlist>
// <kite, KiTe>

// 3. match vowel
// use hashmap to store : <replace vowel with * in lowercase word, word in wordlist>
// <k*t*, KiTe>