package GraphMatrix;

import java.util.ArrayList;


public class GraphMatr
{
	int indexes = 0;
	ArrayList<Vertex> verts = new ArrayList<>(20);

	Edge[][] Matrix = new Edge[20][20];

	public void addVertex(String name)
	{
		verts.add(new Vertex(name));
	}
	
	public void addEdge(String from, String to, int val)
	{
		Vertex fromV = findVertex(from);
		Vertex toV = findVertex(to);
		Edge newEdge = new Edge(val);
		newEdge.VR = toV;
		Matrix[fromV.index][toV.index] = newEdge;
		
	}


	public Vertex findVertex(String name)
	{
		Vertex ret = null;
		
		for (Vertex vertex : verts)
		{
			if(vertex.val.equals(name))
			{
				ret = vertex;
			}
		}
		if(ret == null)
		{
			ret = new Vertex(name);
			verts.add(ret);
		}
		
		return ret;
	}



	class Vertex
	{
		String val = "";
		int index;
		public Vertex(String val)
		{
			this.val = val;
			index = indexes++;
		}
	}

	class Edge
	{
		int val = 0;
		Vertex VR = null;

		
		
		public Edge(int val)
		{
			this.val = val;
		}
	}
	
	
	public static void main(String[] args)
	{
		
	}
}
