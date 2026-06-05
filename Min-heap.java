import java.util.PriorityQueue;
import java.util.Collections;

 class SpotifyLeaderboard {

    public static void main(String[] args) {

        // Artist Names
        String[] artists = {
                "Artist1", "Artist2", "Artist3",
                "Artist4", "Artist5", "Artist6",
                "Artist7", "Artist8", "Artist9",
                "Artist10", "Artist11", "Artist12"
        };

        // Monthly Listener Counts (in millions)
        int[] listeners = {
                45, 12, 78, 23, 56,
                89, 34, 67, 18, 91,
                50, 39
        };

        int k = 5;

        // Min-Heap for Top 5 Listener Counts
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        System.out.println("Building Min-Heap:\n");

        // Process all artists
        for (int i = 0; i < listeners.length; i++) {

            int count = listeners[i];

            // Fill heap initially
            if (minHeap.size() < k) {
                minHeap.add(count);

                System.out.println(
                        artists[i] + " inserted -> " + count + "M");
            }

            // Replace smallest element if current is larger
            else if (count > minHeap.peek()) {

                System.out.println(
                        artists[i] + " replaces "
                                + minHeap.peek() + "M with "
                                + count + "M");

                minHeap.poll();
                minHeap.add(count);
            }

            // Ignore smaller values
            else {

                System.out.println(
                        artists[i] + " ignored -> "
                                + count + "M");
            }
        }

        // Display Final Heap
        System.out.println("\nFinal Min-Heap:");
        System.out.println(minHeap);

        // Sort results in descending order
        PriorityQueue<Integer> result =
                new PriorityQueue<>(Collections.reverseOrder());

        result.addAll(minHeap);

        // Display Top 5
        System.out.println("\nTop 5 Artists Listener Counts:");

        while (!result.isEmpty()) {
            System.out.println(result.poll() + "M");
        }
    }
}