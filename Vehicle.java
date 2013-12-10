public class Vehicle {
	private String regNbr;
	private String model;
	private String type;
	private String licenseReq;
	private int price;
	private String info;
	private boolean hasHook;
	private String expiryDate;
	// Ange alla variablar som vi ska använda i klassen Vehicle (se UML diagrammet).
	
	public String getRegNbr() {
		return regNbr;
	}
	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLicenseReq() {
		return licenseReq;
	}
	public void setLicenseReq(String licenseReq) {
		this.licenseReq = licenseReq;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isHasHook() {
		return hasHook;
	}
	public void setHasHook(boolean hasHook) {
		this.hasHook = hasHook;
	}
	public String getExpiryDate(){
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate){
		this.expiryDate = expiryDate;
	}
	// Skapa getter och setter för de olika variablarna för att de ska kunna lagra olika information om fordonet!
}
