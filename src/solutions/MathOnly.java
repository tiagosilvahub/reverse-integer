package src.solutions;

public class MathOnly implements Solution {
    public int solve(int x) {
        int reversed = 0;
        while (x != 0) {
            int remainder = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }
            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }
}
