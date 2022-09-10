package SimpleGraph;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleGraphTest {
    @Test
    public void isEdgeTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.m_adjacency[0][1] = 1;
        simpleGraph.m_adjacency[1][0] = 1;
        boolean a = simpleGraph.IsEdge(0, 1);
        boolean b = simpleGraph.IsEdge(1, 0);
        assertTrue(a);
        assertTrue(b);
    }

    @Test
    public void addVertexTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        boolean a = simpleGraph.IsEdge(0, 1);
        boolean b = simpleGraph.IsEdge(1, 0);
        assertFalse(a);
        assertFalse(b);
    }

    @Test
    public void addEdgeTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(0, 1);
        assertTrue(simpleGraph.IsEdge(0, 1));
        assertTrue(simpleGraph.IsEdge(1, 0));
    }

    @Test
    public void removeEdgeTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(0, 1);
        assertTrue(simpleGraph.IsEdge(0, 1));
        assertTrue(simpleGraph.IsEdge(1, 0));
        simpleGraph.RemoveEdge(0, 1);
        assertFalse(simpleGraph.IsEdge(0, 1));
        assertFalse(simpleGraph.IsEdge(1, 0));
    }

    @Test
    public void removeVertexTest() {
        SimpleGraph simpleGraph = new SimpleGraph(2);
        simpleGraph.AddVertex(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddEdge(0, 1);
        assertTrue(simpleGraph.IsEdge(0, 1));
        assertTrue(simpleGraph.IsEdge(1, 0));
        simpleGraph.RemoveVertex(0);
        assertNull(simpleGraph.vertex[0]);
        assertFalse(simpleGraph.IsEdge(0, 1));
        assertFalse(simpleGraph.IsEdge(1, 0));
    }

    @Test
    public void depthFirstSearchTest() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 3);
        ArrayList<Vertex> result = simpleGraph.DepthFirstSearch(0, 2);
        ArrayList<Vertex> result2 = simpleGraph.DepthFirstSearch(2, 3);
        ArrayList<Vertex> result3 = simpleGraph.DepthFirstSearch(2, 4);
        assertTrue(result.size() != 0);
        assertEquals(10, result.get(0).Value);
        assertEquals(30, result.get(1).Value);
        assertTrue(result.size() != 0);
        assertEquals(30, result2.get(0).Value);
        assertEquals(10, result2.get(1).Value);
        assertEquals(20, result2.get(2).Value);
        assertEquals(40, result2.get(3).Value);
        assertEquals(0, result3.size());
    }
}