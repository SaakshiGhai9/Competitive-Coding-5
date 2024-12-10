import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a min heap to track time of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through intervals
        for (int[] interval : intervals) {

            // if the room is free earliest meeting has ended , remove it from the heap
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll();
            }
            // Add the current meeting's end time to the heap

            minHeap.add(interval[1]);
        }
        return minHeap.size();
    }
    public static void main(String[] args) {
        MeetingRooms2 solver = new MeetingRooms2();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};

        System.out.println("Example 1: " + solver.minMeetingRooms(intervals1)); // Output: 2
        System.out.println("Example 2: " + solver.minMeetingRooms(intervals2)); // Output: 1
    }
}