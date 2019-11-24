# reverse-integer
Given a 32-bit signed integer, reverse digits of an integer.

https://leetcode.com/problems/reverse-integer/

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Example 1:
```
Input: 123
Output: 321
```

Example 2:
```
Input: -123
Output: -321
```

Example 3:

```
Input: 120
Output: 21
```

We can easily achive the solution by converting to string, reverting it, and catching an integer overflow:

```
try {
    String s = Integer.toString(x);
    int reversed;
    int sign = 1;
    if( s.substring(0,1).equals("-")) {
        s = s.substring(1);
        sign = -1;
    }
    StringBuilder reservedString = new StringBuilder();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
        reservedString.insert(0, c);
    }
    reversed = Integer.parseInt(reservedString.toString());
    reversed *= sign;
    return reversed;
} catch (NumberFormatException e ) {
    // integer overflow
    return 0;
}

```

but it is hardly ideal when there is a mathematical solution. It is simple to reverse a number using only division and remainder:


```
public int solve(int x) {
    int reversed = 0;
    while (x != 0) {
        int remainder = x % 10;
        x /= 10;
        reversed = reversed * 10 + remainder;
    }
    return reversed;
}
```

The max value for an integer is 2147483647 and the min is -2147483648

For an integer overflow to occur, then either:

214748364X > 2147483647 or -214748364X < -2147483648 where X is the next digit to add, the remainder. In other words:

the reversed number is bigger than 214748364 and we still have 1 more digit to add or

the reversed number is exactly 214748364 and the digit we are about to add is bigger than 7 or

the reversed number is smaller than -214748364 and we still have 1 more digit to add or

the reversed number is exactly -214748364 and the digit we are about to add is bigger than 8.

```
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
```

