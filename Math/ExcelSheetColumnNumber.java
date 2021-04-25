package Math;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        // sanity check
        // result int
        int result = 0;
        // scan from left to right
        // result += result * 26 + current character's corresponding value
        for (int i = 0; i < columnTitle.length(); i++) {
            int cur = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + cur;
        }
        // return result
        return result;
    }
}
