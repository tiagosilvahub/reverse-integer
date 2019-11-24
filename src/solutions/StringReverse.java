package src.solutions;

public class StringReverse implements Solution {
    public int solve(int x) {
        try {
            int sign = x < 0 ? -1 : 1;
            StringBuilder reservedString = new StringBuilder(Integer.toString(Math.abs(x)));
            reservedString.reverse();
            return Integer.parseInt(reservedString.toString()) * sign;
        } catch (NumberFormatException e ) {
            // integer overflow
            return 0;
        }
    }
}
