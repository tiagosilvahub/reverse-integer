package src;

import src.solutions.MathOnly;
import src.solutions.Solution;
import src.solutions.StringReverse;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] solutions =
                new Solution[]{
                        new StringReverse(),
                        new MathOnly()
                };

        var input = new int[]{
                123,
                321,
                -123,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
        };
        // add test case results
        var output = new int[]{
                321,
                123,
                -321,
                0,
                0
        };

        // add the type of result here and in src.SolutionStrategy.java
        int result;

        int errors = 0;
        int nTestCases = input.length;
        for (Solution s : solutions) {
            for (int i = 0; i < nTestCases; i++) {
                result = s.solve(input[i]);
                if( output[i] != result) {
                    System.out.println("Solution " + s.getClass().getName() + " wrong for input " + input[i]);
                    System.out.println("Expected: " + output[i] + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(nTestCases - errors + " tests passed.");
        }
        System.out.println(errors + " tests failed.");
        System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
    }
}

