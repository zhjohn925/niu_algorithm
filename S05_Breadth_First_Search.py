# Breadth-First Search (BFS) is an algorithm used for traversing or searching tree or graph data structures. 
# It explores all the vertices of a given level before moving to the vertices at the next level. 
# BFS uses a queue (FIFO) data structure to keep track of the vertices to visit.
# BFS ensures that nodes are visited in a breadth-wise manner, i.e., all the nodes at the same level are 
# visited before moving to the next level.
# 
# Here's a step-by-step explanation of how the Breadth-First Search algorithm works:
#
#  1. Start with an initial node or vertex and enqueue it into a queue (FIFO).
#  2. Mark the current node as visited and process it. This could involve printing the node's value or 
#     performing some other operations.
#  3. Dequeue a node from the front of the queue (FIFO).
#  4. Enqueue all the unvisited neighboring nodes of the dequeued node into the queue.
#  5. Repeat steps 3-4 until the queue becomes empty.
#  6. Continue this process until all nodes in the graph or tree have been visited.

from collections import deque

def bfs(graph, start):
    visited = set()  # Set to keep track of visited nodes
    queue = deque([start])  # Queue to store nodes for traversal

    while queue:
        node = queue.popleft()  # Dequeue a node from the front of the queue (FIFO)

        if node not in visited:
            visited.add(node)
            print(node)  # Process the node

            # Enqueue unvisited neighboring nodes into the queue (FIFO)
            queue.extend(neighbor for neighbor in graph[node] if neighbor not in visited)

# Example usage:
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

bfs(graph, 'A')

# The output:
# A
# B
# C
# D
# E
# F

