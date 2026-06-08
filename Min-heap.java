import java.util.PriorityQueue;
import java.util.Scanner;

public class SpotifyTopK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        System.out.println("Enter number of artists:");
        int n = sc.nextInt();

        System.out.println("Enter Top-K value:");
        int k = sc.nextInt();

        System.out.println("Enter Monthly Listener Counts:");

        for (int i = 0; i < n; i++) {

            int listeners = sc.nextInt();

            // First K elements
            if (minHeap.size() < k) {

                minHeap.add(listeners);
            }

            // Replace minimum if larger value found
            else if (listeners > minHeap.peek()) {

                minHeap.poll();

                minHeap.add(listeners);
            }
        }

        System.out.println("\nTop " + k + " Monthly Listener Counts:");

        while (!minHeap.isEmpty()) {

            System.out.println(minHeap.poll() + " Million");
        }

        sc.close();
    }
}
