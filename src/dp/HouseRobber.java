package dp;

public class HouseRobber {
    public static void main(String[] args) {
        int arr[] = { 10, 3, 2, 5, 7, 8 };
        System.out.println(new HouseRobber().rob(arr));
    }

    private int rob(int[] arr) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                even += arr[i];
                // doing this coz robber can rob houses at the edge
                even = Math.max(even, odd);
            } else {
                odd += arr[i];
                odd = Math.max(odd, even);
            }
        }

        return Math.max(even, odd);
    }
}
