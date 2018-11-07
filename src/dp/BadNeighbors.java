package dp;

import java.util.Arrays;

public class BadNeighbors {
    public static void main(String[] args) {
        int[] donations =  {10, 3, 2, 5, 7, 8 };
        System.out.println(new BadNeighbors().maxDonations(donations));
    }

    private int maxDonations(int[] donations) {
        int N = donations.length;
        // if 1st element is included
        int sum1 = donationHelper(Arrays.copyOfRange(donations, 0,  N - 1));
        // if first is excluded
        int sum2 = donationHelper(Arrays.copyOfRange(donations, 1, N - 2))  + donations[N - 1];

        return Math.max(sum1, sum2);
    }

    private int donationHelper(int[] donations) {
        if (donations.length == 0) return 0;
        if (donations.length == 1) return donations[0];
        if (donations.length == 2) return Math.max(donations[0], donations[1]);

        int sum1 = donationHelper(Arrays.copyOfRange(donations, 0,  donations.length - 1));
        int sum2 = donationHelper(Arrays.copyOfRange(donations, 0, donations.length - 2))  + donations[donations.length - 1];

        return Math.max(sum1, sum2);
    }
}
