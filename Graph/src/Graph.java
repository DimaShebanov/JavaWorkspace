import java.util.ArrayList;

public class Graph implements Cloneable
{
	Vertex root = null;

	public void addVertex(String val)
	{
		findVert(val);  //ищем вершину и если не нашли то добавляем ее
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		Graph ngr = new Graph();
		Vertex tmp = root;
		while(tmp != null)
		{
			ngr.addVertex(tmp.val);
			Edge tmpedge = tmp.root;
			while(tmpedge != null)
			{
				ngr.addEdge(tmp.val, tmpedge.VR.val, tmpedge.val);
				tmpedge = tmpedge.next;
			}
			tmp = tmp.next;
		}

		return ngr;
	}


	private Vertex addVertexIn(String val)
	{
		Vertex vert = new Vertex(val);

		vert.next = root;

		return vert;
	}

	public Vertex findVert(String val)
	{
		Vertex vert = root;
		while(vert != null)
		{
			if(vert.val == val)
			{
				break;
			}
			vert = vert.next;
		}
		//если не нашли вершину - добавляем ее
		if(vert == null)
		{
			root = addVertexIn(val);
			vert = root;
		}

		return vert;
	}



	public void addEdge(String from, String to, int val)
	{
		Vertex fromVert = findVert(from);
		Vertex toVert = findVert(to);
		Edge tmp = new Edge(val);

		tmp.next = fromVert.root;
		fromVert.root = tmp;
		tmp.VR = toVert;
	}

	public void delEdge(String from, String to)
	{
		Vertex vert = root;
		while(vert != null)
		{
			if(vert.val == from)
			{
				break;
			}
			vert = vert.next;
		}
		if(vert == null || vert.root == null)
		{
			return;
		}
		else
		{
			vert.root = delEdgeIn(vert.root, to);
		}

	}


	private Edge delEdgeIn(Edge edg, String val)
	{
		if(edg == null)
		{
			return null;
		}
		if(val.equals(edg.VR.val))
		{
			return edg.next;
		}
		else
		{
			edg.next = delEdgeIn(edg.next, val);
		}
		return edg;
	}






	public void delVertex(String val)
	{
		root = delVertexIn(root, val);
	}



	private Vertex delVertexIn(Vertex vert, String val)
	{
		if(vert == null)
		{
			return null;
		}
		vert.next = delVertexIn(vert.next, val);
		if(val.equals(vert.val))
		{
			return vert.next;
		}
		else
		{
			vert.root = delEdgeIn(vert.root, val);
		}

		return vert;
	}

	@Override
	public String toString()
	{
		String str = "";
		Vertex tmp = root;
		while(tmp != null)
		{
			str += tmp.toString();
			tmp = tmp.next;
		}
		return str;
	}

	public Vertex[] detour()
	{
		ArrayList<Vertex> verts = new ArrayList<>();
		Vertex[] arr = null;

		verts.add(root);
		detourDepth(root, verts);

		return verts.toArray(arr);
	}



	private void detourDepth(Vertex p, ArrayList<Vertex> verts)
	{
		if(verts.contains( p ))
		{
			return;
		}
		if(p.root != null)
		{
			verts.add( p );
			return;
		}
		verts.add( p );
		Edge tmp = p.root;
		while(tmp != null)
		{
			detourDepth(tmp.VR, verts);



			tmp = tmp.next;
		}
	}

	
	
	 class Way
	 {
		 ArrayList<Graph> ways = 
	 }
	
	
	
	
	public static void main(String[] args)
	{
		Graph g = new Graph();

		g.addEdge("Dnipro", "Kiev", 555);
		g.addEdge("Lviv", "Rovno", 203);
		System.out.println(g); 
		System.out.println("_________________________________");
		Graph grr = null;
		try
		{
			grr = (Graph) g.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		System.out.println(grr);
	}





	class Vertex
	{
		Vertex next = null;
		String val = "";
		Edge root = null;

		public Vertex(String val)
		{
			this.val = val;
		}

		@Override
		public String toString()
		{
			String str = val + ":\n";
			Edge tmp = root;
			while(tmp != null)
			{
				str += tmp.toString();
				tmp = tmp.next;
			}

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
			String str = "\t==>" + VR.val + "   " + val + "\n";
			return str;
		}
	}








}
