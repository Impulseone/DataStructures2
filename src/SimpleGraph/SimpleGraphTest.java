package SimpleGraph;

import org.junit.Test;

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
    public void removeVertexTest(){
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
}