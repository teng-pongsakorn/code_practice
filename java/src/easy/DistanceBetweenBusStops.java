package easy;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(dist(distance, start, destination), dist(distance, destination, start));
    }

    private int dist(int[] distance, int start, int destination) {
        int result = 0;
        while (start % distance.length != destination) {
            result += distance[start % distance.length];
            start++;
        }
        return result;
    }
}
