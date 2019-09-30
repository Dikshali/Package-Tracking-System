package packageDeliverySystem;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

	public class Shortest
	{
	    public void computePaths(Vertex source)
	    {
	        source.minDistance = 0.;
	        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
	        vertexQueue.add(source);

	        while (!vertexQueue.isEmpty()) {
	            Vertex u = vertexQueue.poll();

	            // Visit each edge exiting u
	            for (Edge e : u.adjacencies)
	            {
	                Vertex v = e.target;
	                double weight = e.weight;
	                double distanceThroughU = u.minDistance + weight;
	                if (distanceThroughU < v.minDistance) {
	                    vertexQueue.remove(v);
	                    v.minDistance = distanceThroughU ;
	                    v.previous = u;
	                    vertexQueue.add(v);
	                }
	            }
	        }
	    }

	    public List<Vertex> getShortestPathTo(Vertex target)
	    {
	        List<Vertex> path = new ArrayList<Vertex>();
	        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
	            path.add(vertex);

	        Collections.reverse(path);
	        return path;
	    }
	    
	    
	    
	/*
	 * public static void main(String[] args) { Shortest s = new Shortest(); Vertex
	 * v =new Vertex(); ArrayList<Vertex> cityList = new ArrayList<>(); cityList =
	 * v.createGraph(); for(int i=0;i<cityList.size();i++) { Vertex source =
	 * cityList.get(i); if(source.name.equalsIgnoreCase("Northborough, MA")) {
	 * s.computePaths(source); break; } } List<Vertex> path = new ArrayList<>();
	 * for(int i=0;i<cityList.size();i++) { Vertex destination = cityList.get(i);
	 * 
	 * if(destination.name.equalsIgnoreCase("Detroit, MI")) {
	 * path=s.getShortestPathTo(destination); break; } }
	 * System.out.println("Path: "+ path.get(0)); System.out.println("Path: "+
	 * path.get(1)); System.out.println("Path: "+ path.get(2));
	 * //s.computePaths());s.computePaths()); // run Dijkstra //
	 * System.out.println("Distance to " + Orlando + ": " + Orlando.minDistance);
	 * //List<Vertex> path = s.getShortestPathTo(Orlando);
	 * //System.out.println("Path: " + path); }
	 */
	}