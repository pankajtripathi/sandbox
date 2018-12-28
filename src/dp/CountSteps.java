package dp;

/*
* Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
* */
public class CountSteps {
    public static void main (String[] args) {
        int dist = 4;
        System.out.println(new CountSteps().printCountDP(dist));
    }

    private int printCountDP(int dist) {
        if (dist == 0 || dist == 1 || dist == 2) return dist;
        int[] count = new int[dist + 1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= dist; i++) {
            count[i] = count[i-1] + count[i-2];
        }

        return count[dist];
    }
}
