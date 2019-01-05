package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
* */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // get room for first meeting
        queue.add(intervals[0].end);
        int roomCount = 1;

        for (int i = 1; i < intervals.length; i++) {
            // The meeting starts just after first one ended so no need for new room but interval will change
            // so remove last interval and add new one. otherwise add new room and add it's interval to queue.
            if (intervals[i].start >= queue.peek()) {
                queue.poll();
            } else {
                roomCount++;
            }

            // add new interval
            queue.add(intervals[i].end);
        }

        return roomCount;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        Interval interval1 = new Interval(0, 30);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);

        intervals[0] = interval1;
        intervals[1] = interval2;
        intervals[2] = interval3;

        System.out.println(new MeetingRooms().minMeetingRooms(intervals));
    }
}
