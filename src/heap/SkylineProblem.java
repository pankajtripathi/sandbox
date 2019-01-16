package heap;

import java.util.*;

class SkylineProblem {

    class Point {
        int start;
        int height;
        boolean isStart;

        Point(int start, int height, boolean isStart) {
            this.start = start;
            this.height = height;
            this.isStart = isStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        Point[] points = parsePoints(buildings); // parse points

        List<int[]> result = new ArrayList<>();

        // Create queue to track max height
        PriorityQueue<Integer> maxHeight = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeight.add(0);
        int maxValue = 0;

        int i = 0;
        while (i < points.length) {

            int currentPos = points[i].start;
            // process for all points with same starting pos
            while (i < points.length && points[i].start == currentPos) {
                // if start then add the height to queue else remove the height from queue
                if (points[i].isStart) {
                    maxHeight.add(points[i].height);
                } else {
                    maxHeight.remove(points[i].height);
                }

                i++;
            }


            // if maxHeight is not equal to maxValue seen before then add the point to result else
            // the point got overshadowed
            if (maxHeight.peek() != maxValue) {
                result.add(new int[]{currentPos, maxHeight.peek()});
                maxValue = maxHeight.peek();
            }
        }

        return result;
    }

    private Point[] parsePoints(int[][] buildings) {
        Point[] points = new Point[buildings.length * 2];

        int i = 0;
        for (int[] building : buildings) {
            points[i++] = new Point(building[0], building[2], true);
            points[i++] = new Point(building[1], building[2], false);
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.start));
        return points;
    }

    public static void main(String[] args) {
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };

        for (int[] points : new SkylineProblem().getSkyline(buildings)) {
            System.out.println(Arrays.toString(points));
        }
    }
}
