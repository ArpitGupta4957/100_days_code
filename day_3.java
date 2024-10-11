import java.util.*;

class day_3 {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        
        int targetArrivalTime = times[targetFriend][0];

        // Sort times based on arrival time
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] time : times) {
            int arrival = time[0];
            int depart = time[1];

            // Find the first available chair for the current friend
            for (int i = 0; i < n; i++) {
                if (arr[i] <= arrival) {
                    arr[i] = depart;  // Occupy the chair until 'depart'

                    // Check if the current friend is the target friend
                    if (arrival == targetArrivalTime) {
                        return i;  // Return the chair index for the target friend
                    }
                    break;  // Exit loop after assigning chair
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        int targetFriend = sc.nextInt();
        day_3 obj = new day_3();
        System.out.println(obj.smallestChair(times, targetFriend));
    }
}