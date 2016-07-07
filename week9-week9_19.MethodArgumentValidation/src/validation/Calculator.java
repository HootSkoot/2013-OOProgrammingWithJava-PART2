package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        if ( fromInteger < 0 ) {
            throw new IllegalArgumentException("Integer must be non negative");
        }

        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if ( setSize < 0 || setSize < 0 ) {
            throw new IllegalArgumentException("sets must be non-negative");
        }
        if ( subsetSize > setSize) {
            throw new IllegalArgumentException("Subsetsize must be less than setsize");
        }

        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
