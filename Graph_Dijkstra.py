import sys
import heapq

def dijkstra(graph, start):
    # Initialize distances to all nodes as infinity
    distances = {node: sys.maxsize for node in graph}
    # Set the distance to the start node as 0
    distances[start] = 0
    # Priority queue to store nodes with their corresponding distances
    priority_queue = [(0, start)]

    while priority_queue:
        # Pop the node with the smallest distance
        current_distance, current_node = heapq.heappop(priority_queue)

        # Ignore if we have already found a shorter path to the current node
        if current_distance > distances[current_node]:
            continue

        # Explore neighbors of the current node
        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            # If a shorter path to the neighbor is found, update the distance
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                # Add the neighbor to the priority queue
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances

# Example usage
graph = {
    'A': {'B': 5, 'C': 2},
    'B': {'A': 5, 'C': 1, 'D': 3},
    'C': {'A': 2, 'B': 1, 'D': 6},
    'D': {'B': 3, 'C': 6}
}
start_node = 'A'

distances = dijkstra(graph, start_node)
print("Shortest distances from the start node:")
for node, distance in distances.items():
    print(f"Node: {node}, Distance: {distance}")
