package math;

/*
* Implement pow(x, n), which calculates x raised to the power n (i.e., xn)
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
* */
public class PowXN {
    public static void main(String[] args) {
        System.out.println(new PowXN().myPow(2, 10));
        System.out.println(new PowXN().myPow(2, 3));
        System.out.println(new PowXN().myPow(2, -2));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) return (temp * temp);
        if (n > 0) return (temp * temp) * x;
        return (temp * temp) / x;
    }
}
