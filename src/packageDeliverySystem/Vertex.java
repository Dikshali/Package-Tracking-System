package packageDeliverySystem;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>
{
	public String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	public Vertex(String argName) { name = argName; }
	public String toString() { return name; }
	public int compareTo(Vertex other)
	{
		return Double.compare(minDistance, other.minDistance);
	}
	
	public Vertex() {
		
	}
	
	public ArrayList<Vertex> createGraph() {
		 // mark all the vertices 
        Vertex Northborough = new Vertex("Northborough, MA");
        Vertex Edison = new Vertex("Edison, NJ");
        Vertex Pittsburgh = new Vertex("Pittsburgh, PA");
        Vertex Allentown = new Vertex("Allentown, PABD Strap Endlinksth");
        Vertex Martinsburg = new Vertex("Martinsburg, WV");
        Vertex Charlotte = new Vertex("Charlotte, NC");
        Vertex Atlanta = new Vertex("Atlanta, GA");
        Vertex Orlando = new Vertex("Orlando, FL");
        Vertex Memphis = new Vertex("Memphis, TN");
        Vertex Grove_City = new Vertex("Grove City, OH");
        Vertex Indianapolis = new Vertex("Indianapolis, IN");
        Vertex Detroit = new Vertex("Detroit, MI");
        Vertex New_Berlin = new Vertex("New Berlin, WI");
        Vertex Minneapolis = new Vertex("Minneapolis, MN");
        Vertex St_Louis = new Vertex("St. Louis, MO");
        Vertex Kansas = new Vertex("Kansas, KS");
        Vertex Dallas = new Vertex("Dallas, TX");
        Vertex Houston = new Vertex("Houston, TX");
        Vertex Denver = new Vertex("Denver, CO");
        Vertex Salt_Lake_City = new Vertex("Salt Lake City, UT");
        Vertex Phoenix = new Vertex("Phoenix, AZ");
        Vertex Los_Angeles = new Vertex("Los Angeles, CA");
        Vertex Chino = new Vertex("Chino, CA");
        Vertex Sacramento = new Vertex("Sacramento, CA");
        Vertex Seattle = new Vertex("Seattle, WA");

        // set the edges and weight
        Northborough.adjacencies = new Edge[]{ new Edge(Edison, 1),new Edge(Pittsburgh,1),new Edge(Allentown,1),new Edge(Martinsburg,1) };
        Edison.adjacencies = new Edge[]{ new Edge(Northborough, 1),new Edge(Pittsburgh,1),new Edge(Allentown,1),new Edge(Martinsburg,1) };
        Pittsburgh.adjacencies = new Edge[]{ new Edge(Allentown, 1),new Edge(Martinsburg,1),new Edge(Grove_City,1),new Edge(Detroit,1) };
        Allentown.adjacencies = new Edge[]{ new Edge(Northborough, 1),new Edge(Edison,1),new Edge(Pittsburgh,1),new Edge(Martinsburg,1) };
        Martinsburg.adjacencies = new Edge[]{ new Edge(Edison, 1),new Edge(Pittsburgh,1),new Edge(Allentown,1),new Edge(Grove_City,1) };
        Charlotte.adjacencies = new Edge[]{ new Edge(Pittsburgh, 1),new Edge(Martinsburg,1),new Edge(Atlanta,1),new Edge(Grove_City,1) };
        Atlanta.adjacencies = new Edge[]{ new Edge(Charlotte, 1),new Edge(Orlando,1),new Edge(Memphis,1),new Edge(Grove_City,1) };
        Orlando.adjacencies = new Edge[]{ new Edge(Martinsburg, 1),new Edge(Charlotte,1),new Edge(Atlanta,1),new Edge(Memphis,1) };
        Memphis.adjacencies = new Edge[]{ new Edge(Atlanta, 1),new Edge(St_Louis,1),new Edge(Kansas,1),new Edge(Dallas,1) };
        Grove_City.adjacencies = new Edge[]{ new Edge(Pittsburgh, 1),new Edge(Martinsburg,1),new Edge(Indianapolis,1),new Edge(Detroit,1) };
        Indianapolis.adjacencies = new Edge[]{ new Edge(Grove_City, 1),new Edge(Detroit,1),new Edge(New_Berlin,1),new Edge(St_Louis,1) };
        Detroit.adjacencies = new Edge[]{ new Edge(Pittsburgh, 1),new Edge(Grove_City,1),new Edge(Indianapolis,1),new Edge(New_Berlin,1) };
        New_Berlin.adjacencies = new Edge[]{ new Edge(Grove_City, 1),new Edge(Indianapolis,1),new Edge(Detroit,1),new Edge(Minneapolis,1) };
        Minneapolis.adjacencies = new Edge[]{ new Edge(Indianapolis, 1),new Edge(New_Berlin,1),new Edge(St_Louis,1),new Edge(Kansas,1) };
        St_Louis.adjacencies = new Edge[]{ new Edge(Memphis, 1),new Edge(Indianapolis,1),new Edge(New_Berlin,1),new Edge(Kansas,1) };
        Kansas.adjacencies = new Edge[]{ new Edge(Denver, 1),new Edge(New_Berlin,1),new Edge(Minneapolis,1),new Edge(St_Louis,1) };
        Dallas.adjacencies = new Edge[]{ new Edge(Memphis, 1),new Edge(St_Louis,1),new Edge(Kansas,1),new Edge(Houston,1) };
        Houston.adjacencies = new Edge[]{ new Edge(Memphis, 1),new Edge(Atlanta,1),new Edge(Kansas,1),new Edge(Dallas,1) };
        Denver.adjacencies = new Edge[]{ new Edge(Minneapolis, 1),new Edge(Kansas,1),new Edge(Salt_Lake_City,1),new Edge(Phoenix,1) };
        Salt_Lake_City.adjacencies = new Edge[]{ new Edge(Denver, 1),new Edge(Phoenix,1),new Edge(Chino,1),new Edge(Sacramento,1) };
        Phoenix.adjacencies = new Edge[]{ new Edge(Denver, 1),new Edge(Salt_Lake_City,1),new Edge(Los_Angeles,1),new Edge(Chino,1) };
        Los_Angeles.adjacencies = new Edge[]{ new Edge(Salt_Lake_City, 1),new Edge(Phoenix,1),new Edge(Chino,1),new Edge(Sacramento,1) };
        Chino.adjacencies = new Edge[]{ new Edge(Salt_Lake_City, 1),new Edge(Phoenix,1),new Edge(Los_Angeles,1),new Edge(Sacramento,1) };
        Sacramento.adjacencies = new Edge[]{ new Edge(Salt_Lake_City, 1),new Edge(Phoenix,1),new Edge(Los_Angeles,1),new Edge(Seattle,1) };
        Seattle.adjacencies = new Edge[]{ new Edge(Salt_Lake_City, 1),new Edge(Los_Angeles,1),new Edge(Chino,1),new Edge(Sacramento,1) };
        
        ArrayList<Vertex> cityList = new ArrayList<>();
        cityList.add(Northborough);
        cityList.add(Edison);
        cityList.add(Pittsburgh);
        cityList.add(Allentown);
        cityList.add(Martinsburg);
        cityList.add(Charlotte);
        cityList.add(Atlanta);
        cityList.add(Orlando);
        cityList.add(Memphis);
        cityList.add(Grove_City);
        cityList.add(Indianapolis);
        cityList.add(Detroit);
        cityList.add(New_Berlin);
        cityList.add(Minneapolis);
        cityList.add(St_Louis);
        cityList.add(Kansas);
        cityList.add(Dallas);
        cityList.add(Houston);
        cityList.add(Denver);
        cityList.add(Salt_Lake_City);
        cityList.add(Phoenix);
        cityList.add(Los_Angeles);
        cityList.add(Chino);
        cityList.add(Sacramento);
        cityList.add(Seattle);
        
        return cityList;
	}

}
