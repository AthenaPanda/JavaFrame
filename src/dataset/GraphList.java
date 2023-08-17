package dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class GraphList {

	static final int  MAXVNUM = 16;
	Graph graph = new Graph();
	
	public void create_list(Graph graph)
	{
		int i, j;
		int u, v;	
		
		System.out.println("Please enter the num of node and edge:");
		Scanner scanner = new Scanner(System.in);
		graph.vnum = scanner.nextInt();
		graph.edgenum = scanner.nextInt();
		
		System.out.println("please enter the node message:");
		
		for(i = 0; i < graph.vnum; i++)
			graph.vex[i].data = scanner.nextInt();
		for(i = 0; i < graph.vnum; i++)
			graph.vex[i].first = null;
	
		System.out.println("Please every edge message:");
		
		while(graph.edgenum > 0)
		{
			u = scanner.nextInt();
			v = scanner.nextInt();
			
			int  uIndex = 0, vIndex = 0;
			//find the u, v location
			for(i = 0; i < graph.vnum; i++)
			{
				if(u == graph.vex[i].data)
					uIndex = i;
				
				if(v == graph.vex[i].data)
					vIndex = i;
			}
			
			//add the edge to the list
			AdjNode node = new AdjNode();
			node.v = vIndex;
			node.next = graph.vex[uIndex].first;
			graph.vex[uIndex].first = node;
			
			
			graph.edgenum--;
		}
		
		
	}
	
	public void DFSvisit(Graph graph)
	{
		int[] visited = new int[MAXVNUM];
		
		for(int i = 0; i < graph.vnum; i++)
		{
			int id = graph.vex[i].first.v;
			 //next visit
			
		}
	}

}


//边
class AdjNode {
	int v;
	AdjNode next;
	
	public AdjNode() {
		// TODO Auto-generated constructor stub
	}
}

//顶点
class VexNode {
	int data;
	AdjNode first;
}

//邻接表
class Graph {
	//一组顶点
	VexNode vex[] = new VexNode[GraphList.MAXVNUM];
	int vnum;
	int edgenum;
	
}