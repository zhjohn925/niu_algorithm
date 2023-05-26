# Depth-First Search (DFS) is an algorithm used for traversing or searching tree or graph data structures. 
# It explores the depth of a data structure before backtracking. 
# DFS starts at a given node or vertex and explores as far as possible along each branch before backtracking.
# 
# Here's a step-by-step explanation of how the Depth-First Search algorithm works:
#
#   1. Start with an initial node or vertex.
#   2. Mark the current node as visited and process it. This could involve printing the node's value or 
#      performing some other operations.
#   3. If the current node has unvisited neighboring nodes, choose one of them and recursively apply 
#      the DFS algorithm to it.
#   4. Repeat step 3 until there are no more unvisited neighboring nodes.
#   5. Backtrack to the previous node and repeat step 3 if there are still unvisited neighboring nodes.
#   6. Continue this process until all nodes in the graph or tree have been visited.

# 'start' is the starting node in 'graph' for the DFS traversal.
def dfs1(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    print(start)  # Process the node

    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)

# 'start' is the starting node in 'graph' for the DFS traversal.
# The algorithm uses a stack to keep track of nodes to visit. It pops the top node from the stack, 
# checks if it has been visited, processes it, and adds its unvisited neighboring nodes to the stack. 
# This process continues until the stack becomes empty.
def dfs2(graph, start):
    visited = set()  # Set to keep track of visited nodes
    stack = [start]  # Stack to store nodes for traversal

    while stack:
        node = stack.pop()  # Pop the top node from the stack

        if node not in visited:
            visited.add(node)
            print(node)  # Process the node

            # Push unvisited neighboring nodes onto the stack
            stack.extend(neighbor for neighbor in graph[node] if neighbor not in visited)

# Example usage:
graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

dfs2(graph, 'A')

# Output: 
# A
# C
# F
# B
# E
# D





