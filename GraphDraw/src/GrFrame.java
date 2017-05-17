import javax.swing.JFrame;

public class GrFrame extends JFrame
{
	
	public GrFrame()
	{
		setBounds(100, 100, 600, 600);
		setLayout(null);
		
		Graph graph = new Graph();
		graph.addEdge("Kiev", "Moscow", 700);
		graph.addEdge("Lviv", "Dnipro", 100);
		graph.addEdge("Kiev", "Astana", 780);
		graph.addEdge("Kharkiv", "St Peterburg", 900);
		graph.addEdge("Kiev", "Lviv", 790);
		graph.addEdge("Dnipro", "Ulan - Ude", 700);
		graph.addEdge("Moscow", "Lviv", 500);
		graph.addEdge("Moscow", "Dnipro", 500);
		graph.addEdge("Kharkiv", "Lviv", 500);
		graph.addEdge("Lviv", "St Peterburg", 500);
		graph.addEdge("St Peterburg", "Kiev", 500);
		graph.addEdge("Baku", "Kiev", 500);
		graph.addEdge("Siberia", "Kiev", 500);
		graph.addEdge("Paris", "Kiev", 500);
		
		add(new GrPan(graph));		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
