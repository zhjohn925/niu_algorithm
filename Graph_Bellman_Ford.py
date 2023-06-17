class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, u, v, w):
        self.graph.append([u, v, w])

    def bellman_ford(self, src):
        # Step 1: Initialize distances
        distance = [float("inf")] * self.V
        distance[src] = 0

        # Step 2: Relax all edges V-1 times
        # The process of iteratively updating the distance values of vertices in the graph to 
        # find the shortest paths from the source vertex to all other vertices.
        for _ in range(self.V - 1):
            for u, v, w in self.graph:
                if distance[u] != float("inf") and distance[u] + w < distance[v]:
                    distance[v] = distance[u] + w

        # Step 3: Check for negative weight cycles
        # When it happens, the algorithm knows that it cannot determine the shortest paths correctly.
        for u, v, w in self.graph:
            if distance[u] != float("inf") and distance[u] + w < distance[v]:
                print("Graph contains negative weight cycle")
                return

        # Step 4: Print the shortest distances
        print("Vertex\tDistance from Source")
        for i in range(self.V):
            print(f"{i}\t{distance[i]}")

# Example usage
g = Graph(5)
g.add_edge(0, 1, -1)
g.add_edge(0, 2, 4)
g.add_edge(1, 2, 3)
g.add_edge(1, 3, 2)
g.add_edge(1, 4, 2)
g.add_edge(3, 2, 5)
g.add_edge(3, 1, 1)
g.add_edge(4, 3, -3)
g.bellman_ford(0)

# OUTPUT:
# Vertex  Distance from Source
# 0       0
# 1       -1
# 2       2
# 3       -2
# 4       1
