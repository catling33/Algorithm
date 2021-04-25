package Math;

public class IntegerToEnglish {
    public String numberToWords(int num) {
        // sanity check
        if (num == 0) {
            return "Zero";
        }

        // group into three digits per group
        int billion = num / 1000000000;
        num %= 1000000000;
        int million = num / 1000000;
        num %= 1000000;
        int thousand = num / 1000;
        num %= 1000;
        int rest = num;

        // result string
        String result = "";
        // concatenate each group
        if (billion != 0) {
            result = three(billion) + " Billion";
        }
        if (million != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += three(million) + " Million";
        }
        if (thousand != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += three(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += three(rest);
        }

        // return result
        return result;
    }
    // convert three digits
    private String three(int num) {
        // get hundred digit and rest value
        int hundred = num / 100;
        num %= 100;
        int rest = num;
        // result string
        String result = "";
        // concatenate
        if (hundred != 0) {
            result += one(hundred) + " Hundred";
        }
        if (rest != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += two(rest);
        }
        // return result string
        return result;
    }

    // convert two digits
    private String two(int num) {
        // 0 - 19 --> convert and return
        if (num < 10) {
            return one(num);
        }
        if (num < 20) {
            return twoLessThan20(num);
        }
        // 20 - 99
        // find tenner and rest
        // read tenner
        // if rest > 0, append rest after tenner
        int tenner = num / 10;
        num %= 10;
        int rest = num;
        String result = "";
        if (tenner != 0) {
            result += ten(tenner);
        }
        if (rest != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += one(rest);
        }
        // return result string
        return
                result;
    }
    // convert 10 - 19
    private String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    // convert tenner
    private String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    // convert one digit
    public String one(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
}
