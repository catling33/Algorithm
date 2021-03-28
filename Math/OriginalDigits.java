package Math;

public class OriginalDigits {
    public String originalDigits(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return "";
        }
        // int[] result to record count of each integer
        int[] result = new int[10];
        // int[] count to record count of each character
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // step1
        result[0] = count['z' - 'a'];
        result[2] = count['w' - 'a'];
        result[4] = count['u' - 'a'];
        result[6] = count['x' - 'a'];
        result[8] = count['g' - 'a'];
        // step2
        result[3] = count['h' - 'a'] - result[8];
        result[5] = count['f' - 'a'] - result[4];
        result[7] = count['s' - 'a'] - result[6];
        // step3
        result[1] = count['o' - 'a'] - result[4] - result[2] - result[0];
        result[9] = count['i' - 'a'] - result[6] - result[8] - result[5];
        // return string
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            int c = result[i];
            while (c > 0) {
                sol.append(i);
                c--;
            }
        }
        return new String(sol);
    }

    public static void main(String[] args) {
        OriginalDigits sol = new OriginalDigits();
        String s = "owoztneoer";
        System.out.print(sol.originalDigits(s));
    }
}
