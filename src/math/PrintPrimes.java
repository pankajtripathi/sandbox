package math;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimes {
    public static void main(String[] args) {
        new PrintPrimes().printPrimes(10);
    }

    private void printPrimes(int num) {
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);

        for (int i = 3; i < num; i+=2) {
            boolean isPrime = true;

            for (int prime : primeNumbers) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeNumbers.add(i);
            }
        }

        System.out.println(primeNumbers);
    }
}
