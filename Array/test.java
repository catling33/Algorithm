package Array;

public class test {
    public boolean equal(int[] one, int[] two) {
        return one.equals(two);
    }
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {1, 2};
        test sol = new test();
        System.out.println(sol.equal(a, b));
    }
}
