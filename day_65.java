import java.util.PriorityQueue;

class day_65 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store classes by their potential improvement in pass ratio
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Calculate the initial improvement and add classes to the queue
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double improvement = ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
            pq.offer(new double[]{improvement, pass, total});
        }

        // Distribute extra students
        while (extraStudents > 0) {
            // Extract the class with the largest improvement
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];

            // Assign one extra student
            pass++;
            total++;

            // Recalculate the improvement and push back to the queue
            double newImprovement = ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
            pq.offer(new double[]{newImprovement, pass, total});
            extraStudents--;
        }

        // Calculate the final average pass ratio
        double totalRatio = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;
    }
    public static void main(String[] args) {
        day_65 d = new day_65();
        int[][] classes = {{7, 2}, {4, 3}, {2, 5}};
        int extraStudents = 2;
        System.out.println(d.maxAverageRatio(classes, extraStudents));
    }
}