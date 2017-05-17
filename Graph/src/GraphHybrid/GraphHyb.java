package GraphHybrid;

import java.util.ArrayList;




public class GraphHyb
{
	Vertex root = null;
	
	public void addVertex(String name)
	{
		findVertex(name);
	}
	
	public void addEdge(String from, String to, int val)
	{
		Vertex fromV = findVertex(from);
		Vertex toV = findVertex(to);
		Edge edge = new Edge(val);
		edge.VR = toV;
		fromV.edges.add(edge);
	}
	
	@Override
	public String toString()
	{
		String str = "GraphHybrid[\n";
		Vertex tmp = root;
		while(tmp != null)
		{
			str += tmp.toString();
			tmp = tmp.next;
		}
		return str;
	}
	
	public Vertex findVertex(String name)
	{
		if(root == null)
		{
			root = new Vertex(name);
		}
		Vertex tmp = root;
		
		while(tmp != null)
		{
			if(name.equals(tmp.val))
			{
				break;
			}
			tmp = tmp.next;
		}
		if(tmp == null)
		{
			tmp = new Vertex(name);
			tmp.next = root;
			root = tmp;
		}
		
		return tmp;
	}
	
	class Vertex
	{
		Vertex next = null;
		String val = "";
		ArrayList<Edge> edges = new ArrayList<>();
		
		public Vertex(String val)
		{
			this.val = val;
		}
		
		@Override
		public String toString()
		{
			String str = val + "\n";
			
			for (Edge edge : edges)
			{
				str += edge.toString();
			}
			
			str += "\n";
			
			
			return str;
		}
	}

	
	class Edge
	{
		int val = 0;
		Edge next = null;
		Vertex VR = null;
		
		public Edge(int val)
		{
			this.val = val;
		}
		
		@Override
		public String toString()
		{
			String str = "==" + val + "==>" + VR.val + "\n";
			return str;
		}
	}
	
	public static void main(String[] args)
	{
		GraphHyb gh = new GraphHyb();
		gh.addEdge("Kyiv", "Dnipro", 20);
		gh.addEdge("Kyiv", "Lviv", 40);
		gh.addEdge("Dnipro", "Lviv", 100);
		gh.addEdge("Rivne", "Kyiv", 10);
		System.out.println(gh);
	}
}
