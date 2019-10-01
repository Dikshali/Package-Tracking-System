package packageDeliverySystem;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Shortest implements Runnable {
	private PackageModel packageModel = new PackageModel();
	private Thread t;
	
	public Shortest() {

	}
	public Shortest(PackageModel packageModel) {
		this.packageModel = packageModel;
	}

	public void createPath() throws Exception{
        Vertex v =new Vertex();
        ArrayList<Vertex> cityList = new ArrayList<>();
        cityList = v.createGraph();
        for(int i=0;i<cityList.size();i++) {
        	Vertex src = cityList.get(i);
        	if(src.name.equalsIgnoreCase(packageModel.getSource())) {
        		computePaths(src);
        		break;
        	}
        }
        List<Vertex> path = new ArrayList<>();
        for(int i=0;i<cityList.size();i++) {
        	Vertex dst = cityList.get(i);

        	if(dst.name.equalsIgnoreCase(packageModel.getDestination())) {
        		path=getShortestPathTo(dst);
        		break;
        	}
        }
        System.out.println("Path: "+ path);
        ShipPackage trackpackage = new ShipPackage(path, packageModel.getTrackingId());
        trackpackage.start();
	}
	
	public void computePaths(Vertex source){
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();
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

	@Override
	public void run() {
		System.out.println("Running thread in Shortest "+ packageModel.getTrackingId());
		try {
			createPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void start(){
		System.out.println("Starting " +  packageModel.getTrackingId());
	      if (t == null) {
	         t = new Thread (this);
	         t.start ();
	      }
    }
}