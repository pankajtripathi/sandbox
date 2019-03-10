package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeMeetings {
    public static void main(String[] args) {
        List<Meeting> meetings = Arrays.asList(
                new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8),
                new Meeting(10, 12), new Meeting(9, 10)
        );

        for (Meeting meeting: new MergeMeetings().mergeRanges(meetings)) {
            System.out.println("Start: " + meeting.startTime  + " " + "End: " + meeting.endTime);
        }
    }

    static class Meeting {
        private int startTime;
        private int endTime;

        Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }
    }

    private List<Meeting> mergeRanges(List<Meeting> meetings) {
        // merge meetings ranges
        List<Meeting> result = new ArrayList<>();
        meetings.sort(Comparator.comparingInt(m -> m.startTime));

        Meeting prev = null;
        for (Meeting meeting : meetings) {
            if (prev == null) {
                prev = meeting;
            } else if (prev.endTime >= meeting.startTime) {
                prev.endTime = Math.max(prev.endTime, meeting.endTime);
            } else {
                result.add(prev);
                prev = meeting;
            }
        }

        result.add(prev);
        return result;
    }
}
