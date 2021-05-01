package Math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        // sanity check
        if (bound <= 1) {
            return new ArrayList<Integer>();
        }
        // hashset to store results
        Set<Integer> hashset = new HashSet<>();
        // find upper bound of a and b
        int a = x == 1 ? bound : (int) (Math.log(bound) / Math.log(x));
        int b = y == 1 ? bound : (int) (Math.log(bound) / Math.log(y));
        // two for loops
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int curResult = (int) (Math.pow(x, i) + Math.pow(y, j));
                if ( curResult > bound) {
                    break;
                }
                hashset.add(curResult);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        // return result as array list
        return new ArrayList<>(hashset);
    }
}
