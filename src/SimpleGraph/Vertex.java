import java.util.*;

class Vertex {
    public int Value;
    public boolean hit;

    public Vertex(int val) {
        Value = val;
        hit = false;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        Vertex vertex1 = new Vertex(value);
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = vertex1;
                return;
            }
        }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке vertex
    public void RemoveVertex(int v) {
        vertex[v] = null;
        m_adjacency[v][v] = 0;
        if (v + 1 < max_vertex) {
            m_adjacency[v][v + 1] = 0;
            m_adjacency[v + 1][v] = 0;
        }
        if (v - 1 >= 0) {
            m_adjacency[v - 1][v] = 0;
            m_adjacency[v][v - 1] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        Stack<Vertex> stack = new Stack<>();
        for (Vertex vertex1 : vertex) {
            vertex1.hit = false;
        }
        return depthFirstSearch(VFrom, VTo, stack);
    }

    private ArrayList<Vertex> depthFirstSearch(int currentIndex, int VTo, Stack<Vertex> stack) {
        vertex[currentIndex].hit = true;
        if (!stack.contains(vertex[currentIndex])) {
            stack.push(vertex[currentIndex]);
        }
        ArrayList<Vertex> adjacents = findAdjacents(currentIndex);
        if (adjacents.contains(vertex[VTo])) {
            stack.push(vertex[VTo]);
            return new ArrayList<>(stack);
        }
        Vertex notHitVertex = findNotHitAdjacent(adjacents);
        if (notHitVertex != null) {
            int index = getIndexOfVertex(notHitVertex);
            return depthFirstSearch(index, VTo, stack);
        }

        stack.pop();
        if (stack.isEmpty()) {
            return new ArrayList<>();
        }
        return depthFirstSearch(getIndexOfVertex(stack.get(0)), VTo, stack);
    }

    private ArrayList<Vertex> findAdjacents(int index) {
        ArrayList<Vertex> adjacents = new ArrayList<>();
        for (int i = 0; i < max_vertex; i++) {
            if (m_adjacency[index][i] == 1) adjacents.add(vertex[i]);
        }
        return adjacents;
    }

    private ArrayList<Vertex> findNotHitAdjacents(ArrayList<Vertex> adjacents) {
        ArrayList<Vertex> notHitAdjacents = new ArrayList<>();
        for (Vertex adjacent : adjacents) {
            if (!adjacent.hit) notHitAdjacents.add(adjacent);
        }
        return notHitAdjacents;
    }

    private Vertex findNotHitAdjacent(ArrayList<Vertex> adjacents) {
        for (Vertex adjacent : adjacents) {
            if (!adjacent.hit) return adjacent;
        }
        return null;
    }

    private int getIndexOfVertex(Vertex vertex1) {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i].equals(vertex1)) return i;
        }
        return -1;
    }
}