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

    @Test
    public void breadthFirstSearchTest() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(1, 3);
        ArrayList<Vertex> result = simpleGraph.BreadthFirstSearch(0, 2);
        ArrayList<Vertex> result2 = simpleGraph.BreadthFirstSearch(2, 3);
        ArrayList<Vertex> result3 = simpleGraph.BreadthFirstSearch(2, 4);
        assertTrue(result.size() != 0);
        assertEquals(10, result.get(0).Value);
        assertEquals(30, result.get(1).Value);
        assertEquals(30, result2.get(0).Value);
        assertEquals(10, result2.get(1).Value);
        assertEquals(20, result2.get(2).Value);
        assertEquals(40, result2.get(3).Value);
        assertEquals(0, result3.size());
    }

    @Test
    public void breadthFirstSearchTest2() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(1, 4);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(3, 4);
        ArrayList<Vertex> result = simpleGraph.BreadthFirstSearch(0, 4);
        ArrayList<Vertex> result2 = simpleGraph.BreadthFirstSearch(0, 3);
        ArrayList<Vertex> result3 = simpleGraph.BreadthFirstSearch(4, 2);
        assertEquals(3, result.size());
        assertEquals(10, result.get(0).Value);
        assertEquals(20, result.get(1).Value);
        assertEquals(50, result.get(2).Value);
        assertEquals(2, result2.size());
        assertEquals(10, result2.get(0).Value);
        assertEquals(40, result2.get(1).Value);
        assertEquals(3, result3.size());
    }

    @Test
    public void weakVerticesTest(){
        SimpleGraph simpleGraph = new SimpleGraph(4);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 2);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        assertEquals(1, result.size());
        assertEquals(40, result.get(0).Value);
    }

    @Test
    public void weakVerticesTest2(){
        SimpleGraph simpleGraph = new SimpleGraph(4);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(0, 3);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        assertEquals(4, result.size());
    }

    @Test
    public void weakVerticesTest3(){
        SimpleGraph simpleGraph = new SimpleGraph(6);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddVertex(60);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(1, 4);
        simpleGraph.AddEdge(4, 5);
        simpleGraph.AddEdge(2, 5);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        assertEquals(2, result.size());
    }

    @Test
    public void weakVerticesTest4(){
        SimpleGraph simpleGraph = new SimpleGraph(3);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(0, 2);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        assertEquals(0, result.size());
    }

    @Test
    public void weakVerticesTest5(){
        SimpleGraph simpleGraph = new SimpleGraph(9);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddVertex(50);
        simpleGraph.AddVertex(60);
        simpleGraph.AddVertex(70);
        simpleGraph.AddVertex(80);
        simpleGraph.AddVertex(90);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(1, 2);
        simpleGraph.AddEdge(2, 3);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 3);
        simpleGraph.AddEdge(1, 4);
        simpleGraph.AddEdge(1, 5);
        simpleGraph.AddEdge(4, 5);
        simpleGraph.AddEdge(2, 5);
        simpleGraph.AddEdge(5, 6);
        simpleGraph.AddEdge(6, 7);
        simpleGraph.AddEdge(5, 7);
        simpleGraph.AddEdge(7, 8);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        assertEquals(1, result.size());
    }

    @Test
    public void weakVerticesTest6(){
        SimpleGraph simpleGraph = new SimpleGraph(4);
        simpleGraph.AddVertex(10);
        simpleGraph.AddVertex(20);
        simpleGraph.AddVertex(30);
        simpleGraph.AddVertex(40);
        simpleGraph.AddEdge(0, 1);
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        simpleGraph.AddEdge(1, 3);
        ArrayList<Vertex> result = simpleGraph.WeakVertices();
        assertEquals(1, result.size());
    }
}