
public class Warehouse {
	// Vi måste ha med Warehouse klassen för att vet var de olika fordonen befinner sig och hur mycket dem rymmer.
	private String location;
	private int capacity;
	
		public Warehouse(String location, int capacity){
			this.location = location;
			this.capacity = capacity;
		}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	// Skapar getter och setter precis som vanligt för att kunna lägga in olika info.
}