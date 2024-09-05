import java.util.*;

public class Graph {
    private Map<Location, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addLocation(Location location) {
        adjacencyList.putIfAbsent(location, new ArrayList<>());
    }

    public void addRoute(Location from, Location to, double distance) {
        adjacencyList.get(from).add(new Edge(to, distance));
        adjacencyList.get(to).add(new Edge(from, distance)); // If the route is bidirectional
    }

    // Dijkstra's algorithm to find the shortest path
    public List<Location> findShortestPath(Location start, Location destination) {
        Map<Location, Double> distances = new HashMap<>();
        Map<Location, Location> previous = new HashMap<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(edge -> edge.distance));

        for (Location loc : adjacencyList.keySet()) {
            distances.put(loc, Double.MAX_VALUE);
            previous.put(loc, null);
        }
        distances.put(start, 0.0);
        priorityQueue.add(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            Location current = priorityQueue.poll().location;

            if (current.equals(destination)) {
                return reconstructPath(previous, current);
            }

            for (Edge edge : adjacencyList.get(current)) {
                double newDist = distances.get(current) + edge.distance;
                if (newDist < distances.get(edge.location)) {
                    distances.put(edge.location, newDist);
                    previous.put(edge.location, current);
                    priorityQueue.add(new Edge(edge.location, newDist));
                }
            }
        }
        return Collections.emptyList(); // No path found
    }

    private List<Location> reconstructPath(Map<Location, Location> previous, Location current) {
        List<Location> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    // Search for a location by name
    public Location searchLocation(String name) {
        for (Location loc : adjacencyList.keySet()) {
            if (loc.name.equalsIgnoreCase(name)) {
                return loc;
            }
        }
        return null; // Location not found
    }
    public Set<Location> getLocations() {
        return adjacencyList.keySet();
    }

    public double getDistance(Location from, Location to) {
        for (Edge edge : adjacencyList.get(from)) {
            if (edge.location.equals(to)) {
                return edge.distance;
            }
        }
        return -1; // Return -1 if no direct route exists
    }




    // Edge class to represent a route with a distance
    private static class Edge {
        Location location;
        double distance;

        public Edge(Location location, double distance) {
            this.location = location;
            this.distance = distance;
        }
    }
}
