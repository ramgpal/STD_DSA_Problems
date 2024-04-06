import java.util.Arrays;

class PS3 {
    public static int minMeetingRooms(int[][] meetings) {
        int[] startTimes = new int[meetings.length];
        int[] endTimes = new int[meetings.length];

        int index = 0;
        for (int[] meeting : meetings) {
            startTimes[index] = meeting[0];
            endTimes[index] = meeting[1];
            index++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int roomsNeeded = 0;
        int endIndex = 0;

        for (int i = 0; i < meetings.length; i++) {
            if (startTimes[i] < endTimes[endIndex]) {
                roomsNeeded++;
            } else {
                endIndex++;
            }
        }

        return roomsNeeded;
    }

    public static void main(String[] args) {
        int[][] meetingsMatrix = {
            {4, 5},
            {2, 3},
            {2, 4},
            {3, 5}
        };
        // int[][] meetingsMatrix = {
        //     {1, 4},
        //     {2, 5},
        //     {7, 9}
        // };
        System.out.println("Minimum rooms required: " + minMeetingRooms(meetingsMatrix));
    }
}
