package packageDeliverySystem;

public class MainClass {

	public static void main(String[] args) throws Exception {
	    MySQLAccess dao = new MySQLAccess();
	    dao.readDataBase();
	  }
}
