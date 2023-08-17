package dataset;

import java.util.ArrayList;
import java.util.LinkedList;

class EdgeNode {
	int vex;
	int adjvex;
	int weight;
	EdgeNode next;
	
	public EdgeNode(int vex, int adjvex, int weight) {
		// TODO Auto-generated constructor stub
		this.vex = vex;
		this.adjvex = adjvex;
		this.weight = weight;
		this.next = null;
	}
}

class VertexNode {
	String data;
	EdgeNode firstedge;
	
	public VertexNode(String data) {
		this.data = data;
		this.firstedge = null;
	}
}

public class AdjacencyList {
	private ArrayList<VertexNode> vexs;
	int numVertexes;
	int numEdges;
	boolean[] visited;
	
	public AdjacencyList(int numVertexes, int numEdges){
		this.numVertexes = numVertexes;
		this.numEdges = numEdges;
		this.vexs = new ArrayList<VertexNode>(numVertexes);
		this.visited = new boolean[numVertexes];
	}
	
	private void insertVex(VertexNode v) {
		vexs.add(v);
	}
	
	private void insertEdge(EdgeNode e) {
		int i = e.vex;
		int j = e.adjvex;
		VertexNode vexi = vexs.get(i);
		VertexNode vexj = vexs.get(j);
		e.next = vexi.firstedge;
		vexi.firstedge = e;
		
		EdgeNode e2 = new EdgeNode(j, i, 1);
		e2.next = vexj.firstedge;
		vexj.firstedge = e2;
	}
	private void show() {
		for(int i = 0; i < numVertexes; i++) {
			VertexNode vex = vexs.get(i);
			System.out.println("[" + vex.data + "]=>");
			
			EdgeNode node =  vex.firstedge;
			while(node != null) {
				System.out.print(vexs.get(node.adjvex).data + "(" + node.adjvex + ")" + "->");
				node = node.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}
	
	private void DFS(int i){
		EdgeNode p;
		visited[i]  = true;
		
		System.out.print(vexs.get(i).data + " ");
		p = vexs.get(i).firstedge;
		while( p != null) {
			if(!visited[p.adjvex]) {
				DFS(p.adjvex);
			}
			p = p.next;
		}
	}
	
	private void DFSTraverse() {
		int i;
		for(i = 0; i < numVertexes; i++) {
			visited[i]  = false;
		}
		for(i = 0; i < numVertexes; i++) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	
	private void BFSTraverse() {
		EdgeNode p;
		int i;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(i = 0; i < numVertexes; i++) {
			if(!visited[i]) {
				visited[i] = true;
				System.out.print(vexs.get(i).data + " ");
				queue.addLast(i);
				
				while(!queue.isEmpty()) {
					i = queue.removeFirst();
					p = vexs.get(i).firstedge;
					
					while( p != null) {
						if(!visited[p.adjvex]) {
							visited[p.adjvex] = true;
							System.out.print(vexs.get(p.adjvex).data + " ");
							queue.addLast(p.adjvex);
						}
						p = p.next;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
        int numVertexes = 9;
        int numEdges = 15;
        AdjacencyList graph = new AdjacencyList(numVertexes, numEdges);
        graph.insertVex(new VertexNode("A"));
        graph.insertVex(new VertexNode("B"));
        graph.insertVex(new VertexNode("C"));
        graph.insertVex(new VertexNode("D"));
        graph.insertVex(new VertexNode("E"));
        graph.insertVex(new VertexNode("F"));
        graph.insertVex(new VertexNode("G"));
        graph.insertVex(new VertexNode("H"));
        graph.insertVex(new VertexNode("I"));
        graph.insertEdge(new EdgeNode(0, 1, 1));
        graph.insertEdge(new EdgeNode(0, 5, 1));
        graph.insertEdge(new EdgeNode(1, 2, 1));
        graph.insertEdge(new EdgeNode(1, 6, 1));
        graph.insertEdge(new EdgeNode(1, 8, 1));
        graph.insertEdge(new EdgeNode(2, 3, 1));
        graph.insertEdge(new EdgeNode(2, 8, 1));
        graph.insertEdge(new EdgeNode(3, 4, 1));
        graph.insertEdge(new EdgeNode(3, 6, 1));
        graph.insertEdge(new EdgeNode(3, 7, 1));
        graph.insertEdge(new EdgeNode(3, 8, 1));
        graph.insertEdge(new EdgeNode(4, 7, 1));
        graph.insertEdge(new EdgeNode(4, 5, 1));
        graph.insertEdge(new EdgeNode(5, 6, 1));
        graph.insertEdge(new EdgeNode(6, 7, 1));
        System.out.println("邻接表");
        graph.show();
        System.out.print("深度优先遍历：");
        graph.DFSTraverse();
        System.out.println();
        System.out.print("广度优先遍历：");
        graph.BFSTraverse();
	}
}

