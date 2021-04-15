package math;

public class DivideTwoIntegers {
    private int HALF_INT_MIN = Integer.MIN_VALUE / 2;
    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(10, 3));
    }

    public int divide(int dividend, int divisor) {
        // Special case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int negatives = 2;
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }

        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }

        /* In the first loop, we simply find the largest double of divisor
         * that fits into the dividend.
         * The >= is because we're working in negatives. In essence, that
         * piece of code is checking that we're still nearer to 0 than we
         * are to INT_MIN. */
        int twiceTheDivisor = divisor;
        int powerOfTwo = -1;
        while (dividend >= HALF_INT_MIN && dividend <= twiceTheDivisor + twiceTheDivisor) {
            twiceTheDivisor += twiceTheDivisor;
            powerOfTwo += powerOfTwo;
        }

        /* In the second loop, we work out which powers of two fit in, by
        * halving highestDouble and highestPowerOfTwo repeatedly.
        * We can do this using bit shifting so that we don't break the
        * rules of the question*/
        int quotient = 0;
        while (dividend <= divisor) {
            if (dividend <= twiceTheDivisor) {
                dividend -= twiceTheDivisor;
                quotient += powerOfTwo;
            }

            // this is to get half of a number without division. = for negative integers.
            powerOfTwo >>= 1;
            twiceTheDivisor >>= 1;
        }

        return negatives != 1 ? -quotient : quotient;
    }
}
